
package client2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client2 package. 
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

    private final static QName _GetBook_QNAME = new QName("http://services/", "GetBook");
    private final static QName _ReserveBookResponse_QNAME = new QName("http://services/", "ReserveBookResponse");
    private final static QName _ShippingBookResponse_QNAME = new QName("http://services/", "ShippingBookResponse");
    private final static QName _GetBookResponse_QNAME = new QName("http://services/", "GetBookResponse");
    private final static QName _ShippingBook_QNAME = new QName("http://services/", "ShippingBook");
    private final static QName _ReserveBook_QNAME = new QName("http://services/", "ReserveBook");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetBookResponse }
     * 
     */
    public GetBookResponse createGetBookResponse() {
        return new GetBookResponse();
    }

    /**
     * Create an instance of {@link ShippingBook }
     * 
     */
    public ShippingBook createShippingBook() {
        return new ShippingBook();
    }

    /**
     * Create an instance of {@link ReserveBook }
     * 
     */
    public ReserveBook createReserveBook() {
        return new ReserveBook();
    }

    /**
     * Create an instance of {@link GetBook }
     * 
     */
    public GetBook createGetBook() {
        return new GetBook();
    }

    /**
     * Create an instance of {@link ShippingBookResponse }
     * 
     */
    public ShippingBookResponse createShippingBookResponse() {
        return new ShippingBookResponse();
    }

    /**
     * Create an instance of {@link ReserveBookResponse }
     * 
     */
    public ReserveBookResponse createReserveBookResponse() {
        return new ReserveBookResponse();
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "GetBook")
    public JAXBElement<GetBook> createGetBook(GetBook value) {
        return new JAXBElement<GetBook>(_GetBook_QNAME, GetBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserveBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "ReserveBookResponse")
    public JAXBElement<ReserveBookResponse> createReserveBookResponse(ReserveBookResponse value) {
        return new JAXBElement<ReserveBookResponse>(_ReserveBookResponse_QNAME, ReserveBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShippingBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "ShippingBookResponse")
    public JAXBElement<ShippingBookResponse> createShippingBookResponse(ShippingBookResponse value) {
        return new JAXBElement<ShippingBookResponse>(_ShippingBookResponse_QNAME, ShippingBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "GetBookResponse")
    public JAXBElement<GetBookResponse> createGetBookResponse(GetBookResponse value) {
        return new JAXBElement<GetBookResponse>(_GetBookResponse_QNAME, GetBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShippingBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "ShippingBook")
    public JAXBElement<ShippingBook> createShippingBook(ShippingBook value) {
        return new JAXBElement<ShippingBook>(_ShippingBook_QNAME, ShippingBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserveBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "ReserveBook")
    public JAXBElement<ReserveBook> createReserveBook(ReserveBook value) {
        return new JAXBElement<ReserveBook>(_ReserveBook_QNAME, ReserveBook.class, null, value);
    }

}
