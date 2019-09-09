// https://www.developer.com/java/data/how-to-code-java-clipboard-functionality.html
// problema en macosx https://langui.sh/2010/11/14/pbpaste-pbcopy-in-mac-os-x-or-terminal-clipboard-fun/

package cbm;

import cliente.*;
import java.awt.Toolkit;
import java.awt.datatransfer.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.*;


/**
 *
 * @author alfonso
 */
public class ECB implements ClipboardOwner, FlavorListener{
    
    Clipboard cb;
    
    ArrayList<SimpleCliente> asc;
    ArrayList<ConexionCliente> acc;
    ArrayList<MemoriaC>almem;
    
    /**
     * 
     * @param acc
     * @param almem 
     */
    public ECB(ArrayList<ConexionCliente> acc,ArrayList<MemoriaC>almem){
        
        this.acc=acc;
        this.almem = almem;
        
        asc = new ArrayList<>();
        
        this.creaClientes();
        
        cb=Toolkit.getDefaultToolkit().getSystemClipboard();
        cb.addFlavorListener(this);
        
       
    }

    /**
     * 
     * @param e 
     */
    @Override
    public void flavorsChanged(FlavorEvent e) {
        Logger.getLogger(ECB.class.getName()).log(Level.INFO, null, e);
        System.out.println(Arrays.toString(((Clipboard)e.getSource()).getAvailableDataFlavors()));
        this.recuperaObjetoCB();
    }
    
    /**
     * 
     */
    private void creaClientes(){
        for(var cc: acc){
            String surl = "http://"+cc.sip+":"+cc.puerto+"/in";
            var aux = new SimpleCliente(surl);
            asc.add(aux);
        }
    }
    
    /**
     * 
     */
    private void recuperaObjetoCB(){
        
    }

    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        Logger.getLogger(ECB.class.getName()).log(Level.INFO, null, clipboard);
        System.out.println("Se perdio la propiedad del CB");
    }
}
