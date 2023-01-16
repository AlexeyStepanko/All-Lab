package client1;

import org.camunda.bpm.client.ExternalTaskClient;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BookMagazineServiceClient {
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

    public void processURL(URL url) {

        ExternalTaskClient client = ExternalTaskClient.create()
                .baseUrl("http://localhost:8080/engine-rest")
                .asyncResponseTimeout(10000) // long polling timeout
                .build();

        client.subscribe("MagazineTopic")
                .lockDuration(1000) // the default lock duration is 20 seconds, but you can override this
                .handler((externalTask, externalTaskService) -> {
                    Map<String, Object> resultmap =  new HashMap<>();
                    BookMagazineService service = new BookMagazineService(url);
                    BooksMagazineService serviceInterface = service.getBookMagazinePort();

                    String name = "Book#2";
                    int quantity = 100000;

                    System.out.println("Welcome. Please, wait one minute ...");

                    String result = serviceInterface.orderBooks(name, quantity);
                    if(result.equals("NO")) {
                        System.out.println("Sorry, we dont have this quantity. We try to get this from store or vendor");
                        resultmap.put("name", name);
                        resultmap.put("quantity", quantity);
                    } else {
                        System.out.println("Getting books");
                    }
                    // Complete the task
                    externalTaskService.complete(externalTask, resultmap);
                })
                .open();
    }

    public static void main(String[] args) {
        URL url = getWSDLURL("http://localhost:8086/Magazine?wsdl");
        BookMagazineServiceClient client = new BookMagazineServiceClient();
        client.processURL(url);
    }
}
