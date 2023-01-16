package services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.List;

/**
 * Сервис склада книг, можно добавлять и отгружать в качестве поставки в магазин
 */
@WebService(serviceName = "BookStoreService", portName = "BookStorePort")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class BookStoreService {

    static List<Book> StoreList = new ArrayList<>();

    static {
        StoreList.add(new Book("Book#1", "Battle", 800));
        StoreList.add(new Book("Book#2", "Drama", 1500));
        StoreList.add(new Book("Book#3", "Detective", 300));
        StoreList.add(new Book("Book#4", "Fantastic", 400));
        StoreList.add(new Book("Book#5", "Other", 20));
    }
    /**
     * Получить информацию о книге
     * @param name
     * @return
     */
    @WebMethod(operationName = "GetBook")
    public Book GetBookPrototype(String name) {
        for(Book book : StoreList) {
            if(book.getName().equals(name)) {
                return book;
            }
        }
        return null;
    }

    /**
     * Уменьшить количество книг
     * @param name
     * @param quantity
     * @return
     */
    @WebMethod(operationName = "ReserveBook")
    public int IncreaseBook(String name, int quantity) {
        int id = 0;
        int result = -1;
        System.out.println("Reserving " + name + " .....");
        try {
            Thread.sleep(1000 * 5);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        for(Book book : StoreList) {
            if(book.getName().equals(name)) {
                result = book.getQuantity();
                if(result < quantity)  return -1;
                System.out.println("Reserved book " + name);
                StoreList.get(id).setQuantity(result - quantity);
                return result;
            }
            id++;
        }
        return -1;
    }

    @WebMethod(operationName = "ShippingBook")
    public int AddBookPrototype(String name, int quantity) {
        int id = 0;
        int result = -1;
        for(Book book : StoreList) {
            if(book.getName().equals(name)) {
                result = book.getQuantity();
                if(result < quantity)  return -1;
                StoreList.get(id).setQuantity(result + quantity);
                return result;
            }
            id++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8085/Store", new BookStoreService());
    }
}
