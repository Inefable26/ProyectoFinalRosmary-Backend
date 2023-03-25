/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioross.ryanez.Controller;

import com.portafolioross.ryanez.Dto.dtoSkills;
import com.portafolioross.ryanez.Entity.Skills;
import com.portafolioross.ryanez.Repository.ISkillsRepository;
import com.portafolioross.ryanez.Security.Controller.Mensaje;
import com.portafolioross.ryanez.Service.ImpSkillsService;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import java.util.Optional;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ryanez
 */
@RestController
@RequestMapping("skills")
@CrossOrigin (origins = "http://localhost:4200")
public class SkillsController {
    
   
    
    @Autowired
    ISkillsRepository skillsRepository;
    
    @GetMapping("/skillstipo")
    public Optional<Skills> buscarSkills(@RequestParam("tipo") String tipo) {
    return skillsRepository.findByTipo(tipo);
}

    
     @Autowired
    ImpSkillsService impSkillsService;
     
    @GetMapping("/list")
    public ResponseEntity<List<Skills>> list(){
        List<Skills> list = impSkillsService.list();
        return new ResponseEntity (list , HttpStatus.OK);
    }
    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtosk){
        if (StringUtils.isBlank(dtosk.getHabilidad()))
            return new ResponseEntity(new Mensaje("Es obligatorio el Skill"), HttpStatus.BAD_REQUEST);
        
        if (impSkillsService.existsByHabilidad(dtosk.getHabilidad()))
            return new ResponseEntity(new Mensaje("Ya existe skill"), HttpStatus.BAD_REQUEST);
        
        Skills skills = new Skills(dtosk.getHabilidad(), dtosk.getPorcentaje(),dtosk.getSubtitle(), dtosk.getTipo());
        impSkillsService.save(skills);
        
        return new ResponseEntity(new Mensaje("Agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable("id") int id, @RequestBody dtoSkills dtosk){
        
        //Existe el id?
        if (!impSkillsService.existsById(id)) 
            return new ResponseEntity(new Mensaje ("No existe id"), HttpStatus.BAD_REQUEST);
        
        //Compara nombres
        if(impSkillsService.existsByHabilidad (dtosk.getHabilidad()) && impSkillsService.getByHabilidad(dtosk.getHabilidad()).get().getId() !=id)
            return new ResponseEntity(new Mensaje ("Habilidad Ya existe"), HttpStatus.BAD_REQUEST);
          
        //No dejes vacio, es oblig
         if (StringUtils.isBlank(dtosk.getHabilidad()))
             return new ResponseEntity (new Mensaje ("Habilidad es obligatoria"), HttpStatus.BAD_REQUEST);
         
         Skills skills = impSkillsService.getOne(id).get();
         skills.setHabilidad(dtosk.getHabilidad());
         skills.setPorcentaje((dtosk.getPorcentaje()));
         skills.setSubtitle((dtosk.getSubtitle()));
         skills.setTipo((dtosk.getTipo()));
         
         impSkillsService.save(skills);
         return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
         

     }
    
    //Borrar
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //Existe el id?
        if (!impSkillsService.existsById(id)){ 
            return new ResponseEntity(new Mensaje ("No existe id"), HttpStatus.BAD_REQUEST);
        
    } 
        impSkillsService.delete(id);
        
        return new ResponseEntity(new Mensaje ("Skill eliminada"), HttpStatus.OK);
    }
    
    
}
