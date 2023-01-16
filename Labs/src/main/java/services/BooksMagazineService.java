package services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.List;

/**
 * Сервис обычного книжного магазина, принимает заказы и решает заказывать новые книги или нет
 */
@WebService(serviceName = "BookMagazineService", portName = "BookMagazinePort")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class BooksMagazineService {

    static List<Book> bookslist = new ArrayList<>();

    static {
        bookslist.add(new Book("Book#1", "Battle", 800));
        bookslist.add(new Book("Book#2", "Drama", 1500));
        bookslist.add(new Book("Book#3", "Detective", 300));
        bookslist.add(new Book("Book#4", "Fantastic", 400));
        bookslist.add(new Book("Book#5", "Other", 20));
    }

    @WebMethod(operationName = "OrderBooks")
    public String OrderBooksPrototype(String name, int quantity) {
        System.out.println("Hello! Welcome to our book store");

        Book book = GetBookList(name);
        assert book != null;
        if(book.getQuantity() < quantity) return "NO";

        return "YES";
    }

    private Book GetBookList(String name) {
        for(Book book : bookslist) {
            if(book.getName().equals(name)) return book;
        }
        return null;
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8086/Magazine", new BooksMagazineService());
    }
}
