
package client2;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "BookStoreService", targetNamespace = "http://services/", wsdlLocation = "http://localhost:8085/Store?wsdl")
public class BookStoreService_Service
    extends Service
{

    private final static URL BOOKSTORESERVICE_WSDL_LOCATION;
    private final static WebServiceException BOOKSTORESERVICE_EXCEPTION;
    private final static QName BOOKSTORESERVICE_QNAME = new QName("http://services/", "BookStoreService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8085/Store?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BOOKSTORESERVICE_WSDL_LOCATION = url;
        BOOKSTORESERVICE_EXCEPTION = e;
    }

    public BookStoreService_Service() {
        super(__getWsdlLocation(), BOOKSTORESERVICE_QNAME);
    }

    public BookStoreService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), BOOKSTORESERVICE_QNAME, features);
    }

    public BookStoreService_Service(URL wsdlLocation) {
        super(wsdlLocation, BOOKSTORESERVICE_QNAME);
    }

    public BookStoreService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BOOKSTORESERVICE_QNAME, features);
    }

    public BookStoreService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BookStoreService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns BookStoreService
     */
    @WebEndpoint(name = "BookStorePort")
    public BookStoreService getBookStorePort() {
        return super.getPort(new QName("http://services/", "BookStorePort"), BookStoreService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BookStoreService
     */
    @WebEndpoint(name = "BookStorePort")
    public BookStoreService getBookStorePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://services/", "BookStorePort"), BookStoreService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BOOKSTORESERVICE_EXCEPTION!= null) {
            throw BOOKSTORESERVICE_EXCEPTION;
        }
        return BOOKSTORESERVICE_WSDL_LOCATION;
    }

}