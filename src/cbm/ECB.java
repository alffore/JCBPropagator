// https://www.developer.com/java/data/how-to-code-java-clipboard-functionality.html
package cbm;

import java.awt.Toolkit;
import java.awt.datatransfer.*;
import java.util.Arrays;
import java.util.logging.*;

import java.io.IOException;

/**
 *
 * @author alfonso
 */
public class ECB implements FlavorListener{
    
    Clipboard cb;
    
    public ECB(){
        cb=Toolkit.getDefaultToolkit().getSystemClipboard();
        cb.addFlavorListener(this);
    }

    @Override
    public void flavorsChanged(FlavorEvent e) {
        Logger.getLogger(ECB.class.getName()).log(Level.INFO, null, e);
        System.out.println(Arrays.toString(((Clipboard)e.getSource()).getAvailableDataFlavors()));
    }
    
}
