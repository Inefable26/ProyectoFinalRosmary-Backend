package com.portafolioross.ryanez.Controller;

import com.portafolioross.ryanez.Dto.dtoExperience;
import com.portafolioross.ryanez.Entity.Experience;
import com.portafolioross.ryanez.Security.Controller.Mensaje;
import com.portafolioross.ryanez.Service.ImpExperienceService;
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
@RequestMapping("experience")
@CrossOrigin (origins = "http://proyectofinalrosmary-backend-production.up.railway.app")
public class ExperienceController {
    @Autowired
    ImpExperienceService impExperienceService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Experience>> list(){
        List<Experience> list = impExperienceService.list();
        return new ResponseEntity (list , HttpStatus.OK);
    }
    
     @GetMapping("/detail/{id}")
    public ResponseEntity<Experience> getById(@PathVariable("id") int id){
        if(!impExperienceService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Experience experience = impExperienceService.getOne(id).get();
        return new ResponseEntity(experience, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperience dtoexp){
        if (StringUtils.isBlank(dtoexp.getPuesto()))
            return new ResponseEntity(new Mensaje("Es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if (impExperienceService.existsByPuesto(dtoexp.getPuesto()))
            return new ResponseEntity(new Mensaje("Ya existe"), HttpStatus.BAD_REQUEST);
        
        Experience experience = new Experience(dtoexp.getPuesto(), dtoexp.getOrganizacion(),dtoexp.getAno(), dtoexp.getUrl_logo());
        impExperienceService.save(experience);
        
        return new ResponseEntity(new Mensaje("Agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable("id") int id, @RequestBody dtoExperience dtoexp){
        
        //Existe el id?
        if (!impExperienceService.existsById(id)) 
            return new ResponseEntity(new Mensaje ("No existe id"), HttpStatus.BAD_REQUEST);
        
        //Compara nombre de las expe
        if(impExperienceService.existsByPuesto (dtoexp.getPuesto()) && impExperienceService.getByPuesto(dtoexp.getPuesto()).get().getId() !=id)
            return new ResponseEntity(new Mensaje ("Ya existe"), HttpStatus.BAD_REQUEST);
          
        //No dejes vacio, es oblig
         if (StringUtils.isBlank(dtoexp.getPuesto()))
             return new ResponseEntity (new Mensaje ("Es obligatorio"), HttpStatus.BAD_REQUEST);
         
         Experience experience = impExperienceService.getOne(id).get();
         experience.setPuesto(dtoexp.getPuesto());
         experience.setOrganizacion((dtoexp.getOrganizacion()));
         experience.setAno((dtoexp.getAno()));
         experience.setUrl_logo((dtoexp.getUrl_logo()));
         
         impExperienceService.save(experience);
         return new ResponseEntity(new Mensaje("Experience actualizada"), HttpStatus.OK);
         

     }
    
    //Borrar
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //Existe el id?
        if (!impExperienceService.existsById(id)){
            return new ResponseEntity(new Mensaje ("No existe id"), HttpStatus.BAD_REQUEST);
        
        }
        impExperienceService.delete(id);
        
        return new ResponseEntity(new Mensaje ("Experiencia eliminada"), HttpStatus.OK);
    }
    
   
}
