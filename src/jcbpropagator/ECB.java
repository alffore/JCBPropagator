
package jcbpropagator;

import java.awt.Toolkit;
import java.awt.datatransfer.*;
import java.util.logging.*;

/**
 *
 * @author alfonso
 */
public class ECB implements FlavorListener{
    
    Clipboard cb;
    
    public ECB(){
        cb=Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    @Override
    public void flavorsChanged(FlavorEvent e) {
        Logger.getLogger(ECB.class.getName()).log(Level.INFO, null, e);
    }
    
}
