package jcbpropagator;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AAFR <alffore@gmail.com>
 */
public class JCBPropagator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JCBPropagator jcbp = new JCBPropagator();

        
        try {
            System.out.print(jcbp.readClipboard());
        } catch (UnsupportedFlavorException ex) {
            Logger.getLogger(JCBPropagator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JCBPropagator.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    public String readClipboard() throws UnsupportedFlavorException, IOException {
        return (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
    }

}
