package services;

import org.camunda.bpm.client.ExternalTaskClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Path("/vendor")
public class VendorServiceRest {

    static List<Book> VendorList = new ArrayList<>();
    static {
        VendorList.add(new Book("Book#2", "Drama", 150000));
        VendorList.add(new Book("Book#3", "Detective", 15000));
        VendorList.add(new Book("Book#4", "Fantastic", 40000));
    }

    @POST
    @Path("/contactVendor/{name}/{quantity}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ContactVendor(@PathParam("name") String name, @PathParam("quantity") int quantity) {
        ExternalTaskClient client = ExternalTaskClient.create()
                .baseUrl("http://localhost:8080/engine-rest")
                .asyncResponseTimeout(10000) // long polling timeout
                .build();

        client.subscribe("VendorTopic")
                .lockDuration(1000) // the default lock duration is 20 seconds, but you can override this
                .handler((externalTask, externalTaskService) -> {
                    int id = 0;
                    for(Book book : VendorList) {
                        if (book.getName().equals(name)) {
                            if (book.getQuantity() < quantity) externalTaskService.complete(externalTask);
                            int items = book.getQuantity();
                            VendorList.get(id).setQuantity(items - quantity);
                            externalTaskService.complete(externalTask);
                        }
                        id++;
                    }
                    externalTaskService.complete(externalTask);
                })
                .open();

        return Response.ok().build();
    }
}
