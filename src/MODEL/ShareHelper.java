/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author MyPC
 */
public class ShareHelper {
     public static boolean saveLogo(File file){
        File dir=new File("logos");
        
        if(!dir.exists()){
            dir.mkdir();
        }
        File newFile=new File(dir, file.getName());
        try {
            Path source=Paths.get(file.getAbsolutePath());
            Path destination=Paths.get(newFile.getAbsolutePath());
            Files.copy(source, destination,StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception ex) {
            return false;
        }
        
    }
    public static ImageIcon readLogo(String fileName){
        File path=new File("logos", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }
}
