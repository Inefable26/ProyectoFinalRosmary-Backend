/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioross.ryanez.Controller;

import com.portafolioross.ryanez.Dto.dtoBanner;
import com.portafolioross.ryanez.Entity.Banner;
import com.portafolioross.ryanez.Security.Controller.Mensaje;
import com.portafolioross.ryanez.Service.ImpBannerService;
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
@RequestMapping("banner")
@CrossOrigin (origins = "https://portafolio-ryanez.web.app")
public class BannerController {
    @Autowired
    ImpBannerService impBannerService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Banner>> list(){
        List<Banner> list = impBannerService.list();
        return new ResponseEntity (list , HttpStatus.OK);
    }
    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoBanner dtobanner){
        if (StringUtils.isBlank(dtobanner.getImg()))
            return new ResponseEntity(new Mensaje("Es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if (impBannerService.existsByImg(dtobanner.getImg()))
            return new ResponseEntity(new Mensaje("Ya existe"), HttpStatus.BAD_REQUEST);
        
        Banner banner = new Banner(dtobanner.getImg());
        impBannerService.save(banner);
        
        return new ResponseEntity(new Mensaje("Agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable("id") int id, @RequestBody dtoBanner dtobanner){
        
        //Existe el id?
        if (!impBannerService.existsById(id)) 
            return new ResponseEntity(new Mensaje ("No existe id"), HttpStatus.BAD_REQUEST);
        
        //Compara nombres
        if(impBannerService.existsByImg (dtobanner.getImg()) && impBannerService.getByImg(dtobanner.getImg()).get().getId() !=id)
            return new ResponseEntity(new Mensaje ("Ya existe"), HttpStatus.BAD_REQUEST);
          
        //No dejes vacio, es oblig
         if (StringUtils.isBlank(dtobanner.getImg()))
             return new ResponseEntity (new Mensaje ("Es obligatorio"), HttpStatus.BAD_REQUEST);
         
         Banner banner = impBannerService.getOne(id).get();
         banner.setImg(dtobanner.getImg());
        
         
         impBannerService.save(banner);
         return new ResponseEntity(new Mensaje("Banner actualizado"), HttpStatus.OK);
         

     }
    
    //Borrar
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //Existe el id?
        if (!impBannerService.existsById(id)) {
            return new ResponseEntity(new Mensaje ("No existe id"), HttpStatus.BAD_REQUEST);
        
        }
        impBannerService.delete(id);
        
        return new ResponseEntity(new Mensaje ("Banner eliminado"), HttpStatus.OK);
    }
    
    
}
