/**
 * Este es un Servidor de HTTP que resuelve las solicitudes
 */
package servidor;

import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;

/**
 *
 * @author alfonso
 */
public class SimpleServidor {

    HttpServer server;

    public SimpleServidor(int puerto) {
        try {
            server = HttpServer.create(new InetSocketAddress(puerto), 0);
            server.createContext("/envio", new EnvioHandler());
            server.setExecutor(null);
            server.start();
        } catch (IOException ioex) {

        }
    }
}
