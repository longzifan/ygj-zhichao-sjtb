package com.tb.service.sjtb.utils;

import io.vertx.core.json.JsonObject;
import jcifs.smb.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.MalformedURLException;
import java.util.Map;

public class SmbFileUtil {

    private static Logger log = LoggerFactory.getLogger(SmbFileUtil.class);

    private static String USER_DOMAIN = null;
    private static String USER_ACCOUNT = "administrator";
    private static String USER_PWS = "Zhichao@198123.com";
    private static String URL = "smb://10.228.30.198/SourcePicture/";

    /**
     * @Title listFiles
     * @Description 遍历指定目录下的文件
     * @date 2019-01-11 09:56
     */
    private static void listFiles(String shareDirectory) throws Exception {
        long startTime = System.currentTimeMillis();

        // 域服务器验证
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(USER_DOMAIN, USER_ACCOUNT,
                USER_PWS);
        SmbFile remoteFile = new SmbFile(shareDirectory, auth);
        log.info("远程共享目录访问耗时：【{}】", System.currentTimeMillis() - startTime);

        if (remoteFile.exists()) {
            SmbFile[] files = remoteFile.listFiles();
//            remoteFile.listFiles(shareDirectory);

            for (SmbFile f : files) {
                log.info(f.getName());
            }
        } else {
            log.info("文件不存在");
        }
    }

    public static Map<String, Object> smbGet(String shareUrl,Map<String, Object> entries) {
//        JsonObject entries = new JsonObject();
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(USER_DOMAIN, USER_ACCOUNT,
                USER_PWS);
        SmbFile remoteFile = null;
        try {
            remoteFile = new SmbFile(URL + shareUrl, auth);
            if (!remoteFile.exists()) {
                log.info("共享文件"+shareUrl+"不存在");
                return null;
            }
        } catch (MalformedURLException | SmbException e) {
            log.error(e.toString());
        }
        entries.put("dataContent", Base64Utils.getInstance().file2Base64(remoteFile));
        try {
            assert remoteFile != null;
            entries.put("dataLength", (int) remoteFile.length());
        } catch (SmbException e) {
            e.printStackTrace();
        }
        entries.put("fileName", shareUrl.substring(shareUrl.lastIndexOf("/")+1));
        return entries;
    }

    /**
     * @Title smbGet
     * @Param shareUrl 共享目录中的文件路径，如smb://132.20.2.33/CIMPublicTest/eg.txt
     * @Param localDirectory 本地目录，如tempStore/smb
     */
    public static void smbGet(String shareUrl, String localDirectory) throws Exception {
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(USER_DOMAIN, USER_ACCOUNT,
                USER_PWS);
        SmbFile remoteFile = new SmbFile(shareUrl, auth);
        if (!remoteFile.exists()) {
            log.info("共享文件不存在");
            return;
        }
        // 有文件的时候再初始化输入输出流
        InputStream in = null;
        OutputStream out = null;
        log.info("下载共享目录的文件 shareUrl 到 localDirectory");
        try {
            String fileName = remoteFile.getName();
            File localFile = new File(localDirectory + File.separator + fileName);
            File fileParent = localFile.getParentFile();
            if (null != fileParent && !fileParent.exists()) {
                fileParent.mkdirs();
            }
            in = new BufferedInputStream(new SmbFileInputStream(remoteFile));
            out = new BufferedOutputStream(new FileOutputStream(localFile));
            byte[] buffer = new byte[1024];
            while (in.read(buffer) != -1) {
                out.write(buffer);
                buffer = new byte[1024];
            }
            out.flush(); //刷新缓冲区输出流

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
            in.close();
        }
    }

    /**
     * @Title smbPut
     * @Description 向共享目录上传文件
     * @Param shareDirectory 共享目录
     * @Param localFilePath 本地目录中的文件路径
     * @date 2019-01-10 20:16
     */
    public static void smbPut(String shareDirectory, String localFilePath) {
        InputStream in = null;
        OutputStream out = null;
        try {
            File localFile = new File(localFilePath);

            String fileName = localFile.getName();
            SmbFile remoteFile = new SmbFile(shareDirectory + "/" + fileName);
            in = new BufferedInputStream(new FileInputStream(localFile));
            out = new BufferedOutputStream(new SmbFileOutputStream(remoteFile));
            byte[] buffer = new byte[1024];
            while (in.read(buffer) != -1) {
                out.write(buffer);
                buffer = new byte[1024];
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}