//https://stackoverflow.com/questions/7216074/java-swing-ownership-of-the-system-clipboard
package jcbpropagator;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;

/**
 *
 * @author alffo
 */
public class MainAWT extends Frame implements ActionListener, ClipboardOwner, FlavorListener {

    Clipboard cb;
    ClipboardOwner owner;
    Transferable contents;

    public MainAWT() {
        Button b = new Button("click me");
        b.setBounds(30, 100, 80, 30);// setting button position  
        add(b);//adding button into frame  
        setSize(300, 300);//frame size 300 width and 300 height  
        setLayout(null);//no layout manager  
        setVisible(true);//now frame will be visible, by default not visible 

        cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        cb.addFlavorListener(this);

    }

    public static void main(String[] args) {
        new MainAWT();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        StringSelection data = new StringSelection("This is copied to the clipboard");

        cb.setContents(data, this);
    }

    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        System.out.println("se perdio dueño");
    }

    @Override
    public void flavorsChanged(FlavorEvent e) {

        System.out.println("Se cambio el sabor");
    }

}
