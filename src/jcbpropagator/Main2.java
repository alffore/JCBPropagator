
package jcbpropagator;




import cbm.ECB;
import cbm.MemoriaC;
import cliente.ConexionCliente;
import cliente.SimpleCliente;
import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonValue;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidor.SimpleServidor;

/**
 *
 * @author alfonso
 */
public class Main2 {
    
    private String[] args;
    
    ArrayList<MemoriaC> almem ;
    
    ArrayList<ConexionCliente> alconex;
    
    private int clientes;
    
    /**
     * 
     */
    public Main2(String[] args){
        
        this.args=args;
        clientes=0;
        
        
        almem = new ArrayList<>();
        alconex = new ArrayList<>();
        
        this.recuperaConexiones(args[0]);
        
        SimpleServidor ss = new SimpleServidor(8000);
        
        
        
        new ECB(alconex,almem);
        
        SimpleCliente sc = new SimpleCliente("http://127.0.0.1:8000/in");
        for(int i=0; i<10000;i++){
                                    
                sc.eviaMensaje();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public static void main(String[] args) {
        new Main2(args);
        
        
    }
    
    
    private void recuperaConexiones(String sarchivo){
        try {
            FileReader mifr = new FileReader(sarchivo);
            char[] buffer = new char[8096];
            int numberOfCharsRead = mifr.read(buffer);
            String sjson =String.valueOf(buffer, 0, numberOfCharsRead);
            System.out.println(numberOfCharsRead+":: "+sjson);
            
            JsonArray items = Json.parse(sjson).asArray();
            
            for(JsonValue item: items){
                ConexionCliente cc = new ConexionCliente();
                
                cc.cliente_id=clientes;
                
                cc.snombre=item.asObject().getString("nombre", "Indefinido");
                cc.sip=item.asObject().getString("ip","");
                cc.puerto=item.asObject().getInt("puerto", 8000);
                
                alconex.add(cc);
                
                clientes++;
            }
            
            mifr.close();
            
            for(var c: alconex){
                System.out.println(c);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
