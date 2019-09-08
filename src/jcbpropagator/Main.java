package jcbpropagator;

//from   ww  w.ja v a  2 s .  c  om
import java.awt.Toolkit;
import java.awt.datatransfer.*;
import java.io.IOException;

public class Main implements ClipboardOwner {

    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    public Main() {
        // Implement Copy operation
        StringSelection contents = new StringSelection("data");
        clipboard.setContents(contents, this);
        FlavorListener lis = new FlavorListener() {
            @Override
            public void flavorsChanged(FlavorEvent e) {
                System.out.println(e);
            }
        };
        clipboard.addFlavorListener(lis);
        clipboard.removeFlavorListener(lis);
        // Implement Paste operation
        Transferable content = clipboard.getContents(this);
        String dstData;
        try {
            dstData = (String) content.getTransferData(DataFlavor.stringFlavor);
            System.out.println(dstData);
        } catch (UnsupportedFlavorException | IOException e) {

        }
    }

    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        System.out.println("Clipboard contents replaced");
    }

    public static void main(String[] args) {
         new Main();
    }
}
