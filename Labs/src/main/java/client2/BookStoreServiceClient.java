package client2;

import org.camunda.bpm.client.ExternalTaskClient;

import javax.xml.ws.Response;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Склад с книгами, запускается для резервации книг при заказе
 */
public class BookStoreServiceClient {

    private static URL getWSDLURL(String urlStr) {
        URL url = null;
        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return url;
    }
    private void processURL(URL url) {

        ExternalTaskClient client = ExternalTaskClient.create()
                .baseUrl("http://localhost:8080/engine-rest")
                .asyncResponseTimeout(10000) // long polling timeout
                .build();

        client.subscribe("StoreTopic")
                .lockDuration(1000) // the default lock duration is 20 seconds, but you can override this
                .handler((externalTask, externalTaskService) -> {
                    BookStoreService_Service service = new BookStoreService_Service(url);
                    BookStoreService serviceInterface = service.getBookStorePort();

                    String name = externalTask.getVariable("name");
                    int quantity = externalTask.getVariable("quantity");

                    Response<ReserveBookResponse> response = serviceInterface.reserveBookAsync(name, quantity);
                    System.out.println("Reserving books ....");
                    while(!response.isDone()) {
                        System.out.println("Reserve again ...");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    System.out.println("Books was reserved by magazine admin");
                    externalTaskService.complete(externalTask);
                })
                .open();
    }

    public static void main(String[] args) {
        URL url = getWSDLURL("http://localhost:8085/Store?wsdl");
        BookStoreServiceClient client = new BookStoreServiceClient();
        client.processURL(url);
    }

}
