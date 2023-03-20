/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolioross.ryanez.Repository;

import com.portafolioross.ryanez.Entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ryanez
 */
@Repository
public interface ISkillsRepository extends JpaRepository <Skills, Integer>{
    public Optional <Skills> findByTipo(String tipo);
    public boolean existsByTipo(String tipo);

    public Optional<Skills> findByHabilidad(String habilidad);
    public boolean existsByHabilidad(String habilidad);
    
}


