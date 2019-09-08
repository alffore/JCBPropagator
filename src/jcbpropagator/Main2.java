
package jcbpropagator;




import cbm.ECB;
import cbm.MemoriaC;
import cliente.ConexionCliente;
import cliente.SimpleCliente;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidor.SimpleServidor;

/**
 *
 * @author alfonso
 */
public class Main2 {
    
    Vector<MemoriaC> vmem ;
    
    Vector<ConexionCliente> vconex;
    
    /**
     * 
     */
    public Main2(){
        
        vmem = new Vector<MemoriaC>();
        vconex = new Vector<ConexionCliente>();
        
        this.recuperaConexiones();
        
        SimpleServidor ss = new SimpleServidor(8000);
        
        SimpleCliente sc = new SimpleCliente("http://127.0.0.1:8000/in");
        
        new ECB();
        
        
        for(int i=0; i<100;i++){
                                    
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
    
    
    private void recuperaConexiones(){
        
    }
}
