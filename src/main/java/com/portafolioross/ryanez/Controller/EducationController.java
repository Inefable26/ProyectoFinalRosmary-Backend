package com.portafolioross.ryanez.Controller;

import com.portafolioross.ryanez.Dto.dtoEducation;
import com.portafolioross.ryanez.Entity.Education;
import com.portafolioross.ryanez.Security.Controller.Mensaje;
import com.portafolioross.ryanez.Service.ImpEducationService;
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
@RequestMapping("education")
@CrossOrigin (origins = "https://portafolio-ryanez.web.app")
public class EducationController {
    @Autowired
    ImpEducationService impEducationService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Education>> list(){
        List<Education> list = impEducationService.list();
        return new ResponseEntity (list , HttpStatus.OK);
    }
    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducation dtoeduc){
        if (StringUtils.isBlank(dtoeduc.getTitulo()))
            return new ResponseEntity(new Mensaje("Es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if (impEducationService.existsByTitulo(dtoeduc.getTitulo()))
            return new ResponseEntity(new Mensaje("Ya existe"), HttpStatus.BAD_REQUEST);
        
        Education education = new Education(dtoeduc.getTitulo(), dtoeduc.getInstitucion(),dtoeduc.getAno(), dtoeduc.getUrl_logo());
        impEducationService.save(education);
        
        return new ResponseEntity(new Mensaje("Agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable("id") int id, @RequestBody dtoEducation dtoeduc){
        
        //Existe el id?
        if (!impEducationService.existsById(id)) 
            return new ResponseEntity(new Mensaje ("No existe id"), HttpStatus.BAD_REQUEST);
        
        //Compara nombres
        if(impEducationService.existsByTitulo (dtoeduc.getTitulo()) && impEducationService.getByTitulo(dtoeduc.getTitulo()).get().getId() !=id)
            return new ResponseEntity(new Mensaje ("Ya existe"), HttpStatus.BAD_REQUEST);
          
        //No dejes vacio, es oblig
         if (StringUtils.isBlank(dtoeduc.getTitulo()))
             return new ResponseEntity (new Mensaje ("Es obligatorio"), HttpStatus.BAD_REQUEST);
         
         Education education = impEducationService.getOne(id).get();
         education.setTitulo(dtoeduc.getTitulo());
         education.setInstitucion((dtoeduc.getInstitucion()));
         education.setAno((dtoeduc.getAno()));
         education.setUrl_logo((dtoeduc.getUrl_logo()));
         
         impEducationService.save(education);
         return new ResponseEntity(new Mensaje("Educación actualizada"), HttpStatus.OK);
         

     }
    
    //Borrar
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //Existe el id?
        if (!impEducationService.existsById(id)){ 
            return new ResponseEntity(new Mensaje ("No existe id"), HttpStatus.BAD_REQUEST);
        
    }
        impEducationService.delete(id);
        
        return new ResponseEntity(new Mensaje ("Educación eliminada"), HttpStatus.OK);
    }
    
    
}
