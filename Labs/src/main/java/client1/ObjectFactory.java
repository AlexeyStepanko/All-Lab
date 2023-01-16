
package client1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client1 package. 
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

    private final static QName _OrderBooksResponse_QNAME = new QName("http://services/", "OrderBooksResponse");
    private final static QName _OrderBooks_QNAME = new QName("http://services/", "OrderBooks");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OrderBooks }
     * 
     */
    public OrderBooks createOrderBooks() {
        return new OrderBooks();
    }

    /**
     * Create an instance of {@link OrderBooksResponse }
     * 
     */
    public OrderBooksResponse createOrderBooksResponse() {
        return new OrderBooksResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderBooksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "OrderBooksResponse")
    public JAXBElement<OrderBooksResponse> createOrderBooksResponse(OrderBooksResponse value) {
        return new JAXBElement<OrderBooksResponse>(_OrderBooksResponse_QNAME, OrderBooksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderBooks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "OrderBooks")
    public JAXBElement<OrderBooks> createOrderBooks(OrderBooks value) {
        return new JAXBElement<OrderBooks>(_OrderBooks_QNAME, OrderBooks.class, null, value);
    }

}
