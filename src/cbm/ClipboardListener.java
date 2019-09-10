// https://stackoverflow.com/questions/7072533/monitor-clipboard-in-mac-os?noredirect=1&lq=1
package cbm;

import java.awt.Toolkit;  
import java.awt.datatransfer.*;  
import java.io.IOException;  

public class ClipboardListener extends Thread implements ClipboardOwner {

    Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();  

    /**
     * 
     */
    @Override
    public void run(){  
        Transferable selection = systemClipboard.getContents(this);  
        gainOwnership(selection);  
        while (true) {}
    }  

    /**
     * 
     * @param t 
     */
    public void gainOwnership(Transferable t){ 
        try {ClipboardListener.sleep(100);} 
        catch (InterruptedException e) {}
        systemClipboard.setContents(t, this);  
    }  

    /**
     * 
     * @param clipboard
     * @param contents 
     */
    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        try {System.out.println((String) clipboard.getData(DataFlavor.stringFlavor));} 
        catch (UnsupportedFlavorException | IOException e) {}
        gainOwnership(contents);  
    }  
}