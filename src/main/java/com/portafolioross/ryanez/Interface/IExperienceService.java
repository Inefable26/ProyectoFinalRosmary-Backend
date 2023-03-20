/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolioross.ryanez.Interface;


import com.portafolioross.ryanez.Entity.Experience;
import java.util.List;

/**
 *
 * @author ryanez
 */
public interface IExperienceService {
  
    //Traer una lista 
    public List <Experience> getExperience ();
    
    //Guardar un objeto 
    public void saveExperience (Experience experience);
    
    //Eliminar un objeto o usuario y buscamos por Id
    public void deleteExperience (Long id);
    
    //Buscar  por Id
    public Experience findExperience(Long id);
}
