
package cliente;

import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.*;

/**
 *
 * @author alfonso
 */
public class SimpleCliente {
 
    //private int ultimo_ide; 
    
    HttpClient cliente;

    
    public SimpleCliente(){
        cliente = HttpClient.newHttpClient();
    }
    
    public void eviaMensaje(){
        
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("http://"))
        .build();

        cliente.sendAsync(request, BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();

    }
    
}
