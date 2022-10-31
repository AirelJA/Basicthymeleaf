/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.b.takehome1;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author T.U.F GAMING
 */
@Controller
public class controller {
    @RequestMapping(value="/insertData", method=RequestMethod.POST)
    public String insertData(@RequestParam (value="nama") String getNama,
                             @RequestParam (value="kalender")Date getTgl,
                             @RequestParam (value="gambar")MultipartFile getImg ,Model model)throws IOException{
                             //String tanggal = getTgl.toString();
       
                             byte[] sentImg = getImg.getBytes();
                             String base64Image = Base64.encodeBase64String(sentImg);
                             String linkImg = "data:image/png;base64,".concat(base64Image);
                             
        String dataName = "Nama       : " + getNama;
        String dataDate = "Tanggal    : " + getTgl;
        
        model.addAttribute("sentName", dataName);
        model.addAttribute("sentTgl", dataDate);
        model.addAttribute("sentImg", linkImg);
        
        return "main";
    }
    
}
