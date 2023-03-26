package com.portafolioross.ryanez.Controller;

import com.portafolioross.ryanez.Dto.dtoNetwork;
import com.portafolioross.ryanez.Entity.Network;
import com.portafolioross.ryanez.Security.Controller.Mensaje;
import com.portafolioross.ryanez.Service.ImpNetService;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ryanez
 */
@RestController
@RequestMapping("network")
@CrossOrigin (origins = "http://proyectofinalrosmary-backend-production.up.railway.app")
public class NetworkController {
    @Autowired
    ImpNetService impNetService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Network>> list(){
        List<Network> list = impNetService.list();
        return new ResponseEntity (list , HttpStatus.OK);
    }
    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoNetwork dtonet){
        if (StringUtils.isBlank(dtonet.getCuenta()))
            return new ResponseEntity(new Mensaje("Es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if (impNetService.existsByCuenta(dtonet.getCuenta()))
           return new ResponseEntity(new Mensaje("Ya existe"), HttpStatus.BAD_REQUEST);
        
        Network network = new Network( dtonet.getCuenta(), dtonet.getUrl_icono_red());
        impNetService.save(network);
        
        return new ResponseEntity(new Mensaje("Agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable("id") int id, @RequestBody dtoNetwork dtonet){
        
        //Existe el id?
        if (!impNetService.existsById(id)) 
            return new ResponseEntity(new Mensaje ("No existe id"), HttpStatus.BAD_REQUEST);
        
        //Compara nombres
        if(impNetService.existsByCuenta(dtonet.getCuenta()) && impNetService.getByCuenta(dtonet.getCuenta()).get().getId() !=id)
           return new ResponseEntity(new Mensaje ("Ya existe"), HttpStatus.BAD_REQUEST);
          
        //No dejes vacio, es oblig
         if (StringUtils.isBlank(dtonet.getCuenta()))
             return new ResponseEntity (new Mensaje ("Es obligatorio"), HttpStatus.BAD_REQUEST);
         
         Network network = impNetService.getOne(id).get();
         network.setCuenta((dtonet.getCuenta()));
         network.setUrl_icono_red(dtonet.getUrl_icono_red());
         
         
         impNetService.save(network);
         return new ResponseEntity(new Mensaje("Net actualizada"), HttpStatus.OK);
         

     }
    
    //Borrar
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //Existe el id?
        if (!impNetService.existsById(id)) {
            return new ResponseEntity(new Mensaje ("No existe id"), HttpStatus.BAD_REQUEST);
        
        }
        impNetService.delete(id);
        
        return new ResponseEntity(new Mensaje ("Network eliminada"), HttpStatus.OK);
    }
    
    
}