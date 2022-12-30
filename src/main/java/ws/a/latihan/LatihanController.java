/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.a.latihan;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ASUS
 */

@Controller
@ResponseBody
public class LatihanController {

    Barang data = new Barang();
    BarangJpaController actrl = new BarangJpaController();
    //private static Map<String, Barang> actrl = new HashMap<>();
    
    
    @RequestMapping(value = "/getDataBarang")
    public List<Barang> getBarang(){
        
        return actrl.findBarangEntities();
        
        /*try{
            data = actrl.findBarang(Id);
            return data.getId()+ "  " + data.getNama()+ " = " + data.getJumlah();
        }
        catch(Exception error){
            return "Data Barang Tidak Ditemukan";     
        }*/
    }
     @RequestMapping(value = "/delete/{Id}")
     public String delNama(@PathVariable("Id") int Id){
         try{
             actrl.destroy(Id);
             return " Data " + Id +" Terhapus";
         }
         catch(Exception error){
             return "Data Sudah Terhapus";
         }
     }
    /*
    //Method GET
    @RequestMapping(value = "/Barang")
    public ResponseEntity<Object> getBarang(){
        return new ResponseEntity<>(actrl.values(), HttpStatus.OK);
    }
    */
}
