
package client1;

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
@WebServiceClient(name = "BookMagazineService", targetNamespace = "http://services/", wsdlLocation = "http://localhost:8086/Magazine?wsdl")
public class BookMagazineService
    extends Service
{

    private final static URL BOOKMAGAZINESERVICE_WSDL_LOCATION;
    private final static WebServiceException BOOKMAGAZINESERVICE_EXCEPTION;
    private final static QName BOOKMAGAZINESERVICE_QNAME = new QName("http://services/", "BookMagazineService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8086/Magazine?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BOOKMAGAZINESERVICE_WSDL_LOCATION = url;
        BOOKMAGAZINESERVICE_EXCEPTION = e;
    }

    public BookMagazineService() {
        super(__getWsdlLocation(), BOOKMAGAZINESERVICE_QNAME);
    }

    public BookMagazineService(WebServiceFeature... features) {
        super(__getWsdlLocation(), BOOKMAGAZINESERVICE_QNAME, features);
    }

    public BookMagazineService(URL wsdlLocation) {
        super(wsdlLocation, BOOKMAGAZINESERVICE_QNAME);
    }

    public BookMagazineService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BOOKMAGAZINESERVICE_QNAME, features);
    }

    public BookMagazineService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BookMagazineService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns BooksMagazineService
     */
    @WebEndpoint(name = "BookMagazinePort")
    public BooksMagazineService getBookMagazinePort() {
        return super.getPort(new QName("http://services/", "BookMagazinePort"), BooksMagazineService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BooksMagazineService
     */
    @WebEndpoint(name = "BookMagazinePort")
    public BooksMagazineService getBookMagazinePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://services/", "BookMagazinePort"), BooksMagazineService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BOOKMAGAZINESERVICE_EXCEPTION!= null) {
            throw BOOKMAGAZINESERVICE_EXCEPTION;
        }
        return BOOKMAGAZINESERVICE_WSDL_LOCATION;
    }

}
