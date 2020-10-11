
package com.tb.service.sjtb.wsdl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tb.service.sjtb.wsdl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Upload1And4CaseRelatedInfo_QNAME = new QName("http://services/", "upload1And4CaseRelatedInfo");
    private final static QName _UploadWeighPicInfoResponse_QNAME = new QName("http://services/", "uploadWeighPicInfoResponse");
    private final static QName _Upload1And4CaseInfo_QNAME = new QName("http://services/", "upload1And4CaseInfo");
    private final static QName _UploadWeighPicInfo_QNAME = new QName("http://services/", "uploadWeighPicInfo");
    private final static QName _UploadCaseCNInfo_QNAME = new QName("http://services/", "uploadCaseCNInfo");
    private final static QName _UploadWeighInfoResponse_QNAME = new QName("http://services/", "uploadWeighInfoResponse");
    private final static QName _UploadWeighInfo_QNAME = new QName("http://services/", "uploadWeighInfo");
    private final static QName _UploadRoadCaseInfo_QNAME = new QName("http://services/", "uploadRoadCaseInfo");
    private final static QName _UploadRoadCaseInfoResponse_QNAME = new QName("http://services/", "uploadRoadCaseInfoResponse");
    private final static QName _Upload1And4CaseRelatedInfoResponse_QNAME = new QName("http://services/", "upload1And4CaseRelatedInfoResponse");
    private final static QName _UploadCaseCNInfoResponse_QNAME = new QName("http://services/", "uploadCaseCNInfoResponse");
    private final static QName _Upload1And4CaseInfoResponse_QNAME = new QName("http://services/", "upload1And4CaseInfoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tb.service.sjtb.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UploadWeighInfo }
     * 
     */
    public UploadWeighInfo createUploadWeighInfo() {
        return new UploadWeighInfo();
    }

    /**
     * Create an instance of {@link UploadRoadCaseInfo }
     * 
     */
    public UploadRoadCaseInfo createUploadRoadCaseInfo() {
        return new UploadRoadCaseInfo();
    }

    /**
     * Create an instance of {@link UploadRoadCaseInfoResponse }
     * 
     */
    public UploadRoadCaseInfoResponse createUploadRoadCaseInfoResponse() {
        return new UploadRoadCaseInfoResponse();
    }

    /**
     * Create an instance of {@link UploadCaseCNInfoResponse }
     * 
     */
    public UploadCaseCNInfoResponse createUploadCaseCNInfoResponse() {
        return new UploadCaseCNInfoResponse();
    }

    /**
     * Create an instance of {@link Upload1And4CaseInfoResponse }
     * 
     */
    public Upload1And4CaseInfoResponse createUpload1And4CaseInfoResponse() {
        return new Upload1And4CaseInfoResponse();
    }

    /**
     * Create an instance of {@link Upload1And4CaseRelatedInfoResponse }
     * 
     */
    public Upload1And4CaseRelatedInfoResponse createUpload1And4CaseRelatedInfoResponse() {
        return new Upload1And4CaseRelatedInfoResponse();
    }

    /**
     * Create an instance of {@link Upload1And4CaseRelatedInfo }
     * 
     */
    public Upload1And4CaseRelatedInfo createUpload1And4CaseRelatedInfo() {
        return new Upload1And4CaseRelatedInfo();
    }

    /**
     * Create an instance of {@link UploadWeighPicInfoResponse }
     * 
     */
    public UploadWeighPicInfoResponse createUploadWeighPicInfoResponse() {
        return new UploadWeighPicInfoResponse();
    }

    /**
     * Create an instance of {@link Upload1And4CaseInfo }
     * 
     */
    public Upload1And4CaseInfo createUpload1And4CaseInfo() {
        return new Upload1And4CaseInfo();
    }

    /**
     * Create an instance of {@link UploadWeighPicInfo }
     * 
     */
    public UploadWeighPicInfo createUploadWeighPicInfo() {
        return new UploadWeighPicInfo();
    }

    /**
     * Create an instance of {@link UploadCaseCNInfo }
     * 
     */
    public UploadCaseCNInfo createUploadCaseCNInfo() {
        return new UploadCaseCNInfo();
    }

    /**
     * Create an instance of {@link UploadWeighInfoResponse }
     * 
     */
    public UploadWeighInfoResponse createUploadWeighInfoResponse() {
        return new UploadWeighInfoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Upload1And4CaseRelatedInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "upload1And4CaseRelatedInfo")
    public JAXBElement<Upload1And4CaseRelatedInfo> createUpload1And4CaseRelatedInfo(Upload1And4CaseRelatedInfo value) {
        return new JAXBElement<Upload1And4CaseRelatedInfo>(_Upload1And4CaseRelatedInfo_QNAME, Upload1And4CaseRelatedInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadWeighPicInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "uploadWeighPicInfoResponse")
    public JAXBElement<UploadWeighPicInfoResponse> createUploadWeighPicInfoResponse(UploadWeighPicInfoResponse value) {
        return new JAXBElement<UploadWeighPicInfoResponse>(_UploadWeighPicInfoResponse_QNAME, UploadWeighPicInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Upload1And4CaseInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "upload1And4CaseInfo")
    public JAXBElement<Upload1And4CaseInfo> createUpload1And4CaseInfo(Upload1And4CaseInfo value) {
        return new JAXBElement<Upload1And4CaseInfo>(_Upload1And4CaseInfo_QNAME, Upload1And4CaseInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadWeighPicInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "uploadWeighPicInfo")
    public JAXBElement<UploadWeighPicInfo> createUploadWeighPicInfo(UploadWeighPicInfo value) {
        return new JAXBElement<UploadWeighPicInfo>(_UploadWeighPicInfo_QNAME, UploadWeighPicInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadCaseCNInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "uploadCaseCNInfo")
    public JAXBElement<UploadCaseCNInfo> createUploadCaseCNInfo(UploadCaseCNInfo value) {
        return new JAXBElement<UploadCaseCNInfo>(_UploadCaseCNInfo_QNAME, UploadCaseCNInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadWeighInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "uploadWeighInfoResponse")
    public JAXBElement<UploadWeighInfoResponse> createUploadWeighInfoResponse(UploadWeighInfoResponse value) {
        return new JAXBElement<UploadWeighInfoResponse>(_UploadWeighInfoResponse_QNAME, UploadWeighInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadWeighInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "uploadWeighInfo")
    public JAXBElement<UploadWeighInfo> createUploadWeighInfo(UploadWeighInfo value) {
        return new JAXBElement<UploadWeighInfo>(_UploadWeighInfo_QNAME, UploadWeighInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadRoadCaseInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "uploadRoadCaseInfo")
    public JAXBElement<UploadRoadCaseInfo> createUploadRoadCaseInfo(UploadRoadCaseInfo value) {
        return new JAXBElement<UploadRoadCaseInfo>(_UploadRoadCaseInfo_QNAME, UploadRoadCaseInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadRoadCaseInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "uploadRoadCaseInfoResponse")
    public JAXBElement<UploadRoadCaseInfoResponse> createUploadRoadCaseInfoResponse(UploadRoadCaseInfoResponse value) {
        return new JAXBElement<UploadRoadCaseInfoResponse>(_UploadRoadCaseInfoResponse_QNAME, UploadRoadCaseInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Upload1And4CaseRelatedInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "upload1And4CaseRelatedInfoResponse")
    public JAXBElement<Upload1And4CaseRelatedInfoResponse> createUpload1And4CaseRelatedInfoResponse(Upload1And4CaseRelatedInfoResponse value) {
        return new JAXBElement<Upload1And4CaseRelatedInfoResponse>(_Upload1And4CaseRelatedInfoResponse_QNAME, Upload1And4CaseRelatedInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadCaseCNInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "uploadCaseCNInfoResponse")
    public JAXBElement<UploadCaseCNInfoResponse> createUploadCaseCNInfoResponse(UploadCaseCNInfoResponse value) {
        return new JAXBElement<UploadCaseCNInfoResponse>(_UploadCaseCNInfoResponse_QNAME, UploadCaseCNInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Upload1And4CaseInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "upload1And4CaseInfoResponse")
    public JAXBElement<Upload1And4CaseInfoResponse> createUpload1And4CaseInfoResponse(Upload1And4CaseInfoResponse value) {
        return new JAXBElement<Upload1And4CaseInfoResponse>(_Upload1And4CaseInfoResponse_QNAME, Upload1And4CaseInfoResponse.class, null, value);
    }

}
