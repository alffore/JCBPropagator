
package cliente;

import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.*;

/**
 *
 * @author alfonso
 * @see https://openjdk.java.net/groups/net/httpclient/intro.html
 * @see https://github.com/ralscha/blog2019/tree/master/java11httpclient
 * @see https://dzone.com/articles/java-11-standardized-http-client-api
 */
public class SimpleCliente {
 
    //private int ultimo_ide; 
    
    HttpClient cliente;

    String surl;
    
    
    /**
     * 
     * @param surl 
     */
    public SimpleCliente(String surl){
        this.surl=surl;
        cliente = HttpClient.newHttpClient();
    }
    
    /**
     * Método para enviar mensaje en forma asincrona a los clientes conectados 
     */
    public void eviaMensaje(){
        
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(surl))
        .build();

        cliente.sendAsync(request, BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();

    }
    
}
