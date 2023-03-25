package com.portafolioross.ryanez.Controller;

import com.portafolioross.ryanez.Dto.dtoProject;
import com.portafolioross.ryanez.Entity.Project;
import com.portafolioross.ryanez.Security.Controller.Mensaje;
import com.portafolioross.ryanez.Service.ImpProjectService;
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
@RequestMapping("project")
@CrossOrigin (origins = "http://localhost:4200")
public class ProjectController {
    @Autowired
    ImpProjectService impProjectService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Project>> list(){
        List<Project> list = impProjectService.list();
        return new ResponseEntity (list , HttpStatus.OK);
    }
    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProject dtoproj){
        if (StringUtils.isBlank(dtoproj.getTitulo()))
            return new ResponseEntity(new Mensaje("Es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if (impProjectService.existsByTitulo(dtoproj.getTitulo()))
            return new ResponseEntity(new Mensaje("Ya existe"), HttpStatus.BAD_REQUEST);
        
        Project project = new Project(dtoproj.getTitulo(), dtoproj.getDescripcion(),dtoproj.getAno(), dtoproj.getUrl_img_project());
        impProjectService.save(project);
        
        return new ResponseEntity(new Mensaje("Agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable("id") int id, @RequestBody dtoProject dtoproj){
        
        //Existe el id?
        if (!impProjectService.existsById(id)) 
            return new ResponseEntity(new Mensaje ("No existe id"), HttpStatus.BAD_REQUEST);
        
        //Compara nombres
        if(impProjectService.existsByTitulo (dtoproj.getTitulo()) && impProjectService.getByTitulo(dtoproj.getTitulo()).get().getId() !=id)
            return new ResponseEntity(new Mensaje ("Ya existe"), HttpStatus.BAD_REQUEST);
          
        //No dejes vacio, es oblig
         if (StringUtils.isBlank(dtoproj.getTitulo()))
             return new ResponseEntity (new Mensaje ("Es obligatorio"), HttpStatus.BAD_REQUEST);
         
         Project project = impProjectService.getOne(id).get();
         project.setTitulo(dtoproj.getTitulo());
         project.setDescripcion((dtoproj.getDescripcion()));
         project.setAno((dtoproj.getAno()));
         project.setUrl_img_project((dtoproj.getUrl_img_project()));
         
         impProjectService.save(project);
         return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
         

     }
    
    //Borrar
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //Existe el id?
        if (!impProjectService.existsById(id)) {
            return new ResponseEntity(new Mensaje ("No existe id"), HttpStatus.BAD_REQUEST);
        
        }
        impProjectService.delete(id);
        
        return new ResponseEntity(new Mensaje ("Proyecto eliminado"), HttpStatus.OK);
    }
    
    
}
