package lectormp3;

import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;


/**
 *
 * @author Javier Montes
 */
public class LectorMP3 {

  
    public static void main(String[] args) throws FileNotFoundException, JavaLayerException {
        
        Vista run = new Vista();
        run.setVisible(true);
        
    }
    
}
