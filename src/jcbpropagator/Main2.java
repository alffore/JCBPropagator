
package jcbpropagator;




import cliente.SimpleCliente;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidor.SimpleServidor;

/**
 *
 * @author alfonso
 */
public class Main2 {
    
    
    public Main2(){
        SimpleServidor ss = new SimpleServidor(8000);
        
        SimpleCliente sc = new SimpleCliente("http://127.0.0.1:8000/in");
        
        for(int i=0; i<100000;i++){
                                    
                sc.eviaMensaje();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public static void main(String[] args) {
        new Main2();
        
        
    }
    
    
}
