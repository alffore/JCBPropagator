package servidor;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author alfonso
 */
public class EnvioHandler implements HttpHandler {

    int id;

    public EnvioHandler() {
        id = 0;
    }

    @Override
    public void handle(HttpExchange t) throws IOException {
        String response = "This is the response " + id;
        t.sendResponseHeaders(200, response.length());
        try (OutputStream os = t.getResponseBody()) {
            os.write(response.getBytes());
        }
        id++;
    }

}
