/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioross.ryanez.Service;

import com.portafolioross.ryanez.Entity.Skills;
import com.portafolioross.ryanez.Repository.ISkillsRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ryanez
 */
@Service
@Transactional  //Mantiene la correlación con la base de datos
public class ImpSkillsService {
    @Autowired //Relación con el repositorio
    ISkillsRepository iSkillsRepository;
    
    public List<Skills> list() {
        return iSkillsRepository.findAll();
    }
    
    public Optional <Skills> getOne(int id) {
        return iSkillsRepository.findById(id);
    }
    
    public Optional <Skills> getByHabilidad(String habilidad) {
        return iSkillsRepository.findByHabilidad (habilidad);
    }
   
    
    public void save (Skills sk){
        iSkillsRepository.save(sk);
    }
    
    public void delete (int id){
        iSkillsRepository.deleteById(id);
    }
    
    public boolean existsById (int id) {
        return iSkillsRepository.existsById(id);
    }
    
    public boolean existsByHabilidad (String habilidad) {
        return iSkillsRepository.existsByHabilidad(habilidad);
    }
}

