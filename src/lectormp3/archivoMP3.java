package lectormp3;

import javazoom.jl.player.Player;
import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;

/**
 * 
 * @author Javier Montes
 */
public class archivoMP3 {
    
    private String archivo;
    private File RutaParent;
    private File archivoMP3;
    private Player iniciar;
    
    public archivoMP3 (){
        
    }
    
    public void setRutaParent(String rutaP){
        this.RutaParent = new File(rutaP);
    }
    
    public File getRutaParent(){
        return this.RutaParent;
    }
    
    
    public void setArchivoMP3 (File Parent, String ruta){
        this.archivoMP3 = new File(Parent, ruta);
    }
    
    public File getArchivoMP3 (){
        return this.archivoMP3;
    }
    
    public String ListarFicheros (){
        
        String [] FicherosMP3;
        String NombreFicheros = "";
        
        FicherosMP3 = getRutaParent().list();
        
        for(int i = 0; i<FicherosMP3.length;i++){
            
            NombreFicheros = FicherosMP3[i];
               
        }
        
        return NombreFicheros;
    }
    
    
    
   
    public void play () throws FileNotFoundException, JavaLayerException{
        
        try{
        FileInputStream FileInput = new FileInputStream(getArchivoMP3());
        BufferedInputStream bis = new BufferedInputStream(FileInput);
        iniciar = new Player(bis);
        
        }catch(FileNotFoundException | JavaLayerException e){
            
            JOptionPane.showMessageDialog(null,"Error al leer el archivo: " + e);
            
        }
        
        new Thread(){
            
            @Override
            public void run(){
                try{
                    iniciar.play();
                }catch(JavaLayerException e){
                    JOptionPane.showMessageDialog(null,e);
                }
            }
        
        }.start();
    

    }
    
    
     
    
    public void stop (){
        
        if (iniciar != null){
            iniciar.close();
        }
        
    }

}