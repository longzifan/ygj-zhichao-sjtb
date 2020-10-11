package com.tb.service.main;

import com.sticker.online.core.anno.RouteHandler;
import com.sticker.online.core.anno.RouteMapping;
import com.sticker.online.core.anno.RouteMethod;
import com.sticker.online.core.handlerfactory.RouterHandlerFactory;
import com.sticker.online.core.utils.ReflectionUtil;
import com.sticker.online.core.vertx.RouterUtil;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.CookieHandler;
import io.vertx.ext.web.handler.CorsHandler;
import io.vertx.ext.web.handler.StaticHandler;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName: NewRouterHandlerFactory
 * @Description:
 * @Author: wangf
 * @Date: 2020/1/9 0009 14:42
 * @Version: 1.0
 **/
public class NewRouterHandlerFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(RouterHandlerFactory.class);
    private static volatile Reflections reflections;
    private static final String GATEWAY_PREFIX = "/";
    private volatile String gatewayPrefix = "/";

    public NewRouterHandlerFactory(String routerScanAddress) {
        Objects.requireNonNull(routerScanAddress, "The router package address scan is empty.");
        reflections = ReflectionUtil.getReflections(routerScanAddress);
    }

    public NewRouterHandlerFactory(List<String> routerScanAddresses) {
        Objects.requireNonNull(routerScanAddresses, "The router package address scan is empty.");
        reflections = ReflectionUtil.getReflections(routerScanAddresses);
    }

    public NewRouterHandlerFactory(String routerScanAddress, String gatewayPrefix) {
        Objects.requireNonNull(routerScanAddress, "The router package address scan is empty.");
        reflections = ReflectionUtil.getReflections(routerScanAddress);
        this.gatewayPrefix = gatewayPrefix;
    }

    public Router createRouter() {
        Router router = RouterUtil.getRouter();
        router.route().handler((ctx) -> {
            ctx.response().headers().add(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8");
            ctx.response().headers().add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
            ctx.response().headers().add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "POST, GET, OPTIONS, PUT, DELETE, " +
                    "HEAD");
            ctx.response().headers().add(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "X-PINGOTHER, Origin,Content-Type," +
                    " Accept, X-Requested-With, Dev, Authorization, Version, Token,X-Access-Token");
            ctx.response().headers().add(HttpHeaders.ACCESS_CONTROL_MAX_AGE, "1728000");
            ctx.next();
        });
        String filepath = "statics" + File.separator + "upload";
        router.route().handler(BodyHandler.create(true).setUploadsDirectory(filepath));
        router.route().handler(CookieHandler.create());
        router.route("/web/*").handler(StaticHandler.create("static"));
        Set<HttpMethod> method = new HashSet<HttpMethod>() {
            {
                this.add(HttpMethod.GET);
                this.add(HttpMethod.POST);
                this.add(HttpMethod.OPTIONS);
                this.add(HttpMethod.PUT);
                this.add(HttpMethod.DELETE);
                this.add(HttpMethod.HEAD);
            }
        };
        router.route().handler(CorsHandler.create("*").allowedMethods(method));
        router.route().handler(CookieHandler.create());
        try {
            Set<Class<?>> handlers = reflections.getTypesAnnotatedWith(RouteHandler.class);
            Comparator<Class<?>> comparator = (c1, c2) -> {
                RouteHandler routeHandler1 = (RouteHandler) c1.getAnnotation(RouteHandler.class);
                RouteHandler routeHandler2 = (RouteHandler) c2.getAnnotation(RouteHandler.class);
                return Integer.compare(routeHandler2.order(), routeHandler1.order());
            };
            List<Class<?>> sortedHandlers = (List) handlers.stream().sorted(comparator).collect(Collectors.toList());
            Iterator var7 = sortedHandlers.iterator();
            while (var7.hasNext()) {
                Class handler = (Class) var7.next();
                try {
                    this.registerNewHandler(router, handler);
                } catch (Exception var10) {
                    LOGGER.error("Error register {}", handler);
                }
            }
        } catch (Exception var11) {
            LOGGER.error("Manually Register Handler Fail，Error details：" + var11.getMessage());
        }
        return router;
    }

    private void registerNewHandler(Router router, Class<?> handler) throws Exception {
        String root = this.gatewayPrefix;
        if (!root.startsWith("/")) {
            root = "/" + root;
        }
        if (!root.endsWith("/")) {
            root = root + "/";
        }
        if (handler.isAnnotationPresent(RouteHandler.class)) {
            RouteHandler routeHandler = (RouteHandler) handler.getAnnotation(RouteHandler.class);
            root = root + routeHandler.value();
        }
        Object instance = handler.newInstance();
        Method[] methods = handler.getMethods();
        Comparator<Method> comparator = (m1, m2) -> {
            RouteMapping mapping1 = (RouteMapping) m1.getAnnotation(RouteMapping.class);
            RouteMapping mapping2 = (RouteMapping) m2.getAnnotation(RouteMapping.class);
            return Integer.compare(mapping2.order(), mapping1.order());
        };
        List<Method> methodList = (List) Stream.of(methods).filter((methodx) -> {
            return methodx.isAnnotationPresent(RouteMapping.class);
        }).sorted(comparator).collect(Collectors.toList());
        Iterator var8 = methodList.iterator();
        while (var8.hasNext()) {
            Method method = (Method) var8.next();
            if (method.isAnnotationPresent(RouteMapping.class)) {
                RouteMapping mapping = (RouteMapping) method.getAnnotation(RouteMapping.class);
                RouteMethod routeMethod = mapping.method();
                String routeUrl;
                if (mapping.value().startsWith("/:")) {
                    routeUrl = method.getName() + mapping.value();
                } else {
                    routeUrl = mapping.value().endsWith(method.getName()) ? mapping.value() : (mapping.isCover() ?
                            mapping.value() : mapping.value() + method.getName());
                    if (routeUrl.startsWith("/")) {
                        routeUrl = routeUrl.substring(1);
                    }
                }
                String url;
                if (!root.endsWith("/")) {
                    url = root.concat("/" + routeUrl);
                } else {
                    url = root.concat(routeUrl);
                }
                Handler<RoutingContext> methodHandler = (Handler) method.invoke(instance);
                LOGGER.debug("Register New Handler -> {}:{}", routeMethod, url);
                switch (routeMethod) {
                    case POST:
                        router.post(url).handler(methodHandler);
                        break;
                    case PUT:
                        router.put(url).handler(methodHandler);
                        break;
                    case DELETE:
                        router.delete(url).handler(methodHandler);
                        break;
                    case ROUTE:
                        router.route(url).handler(methodHandler);
                        break;
                    case GET:
                    default:
                        router.get(url).handler(methodHandler);
                }
            }
        }
    }
}
