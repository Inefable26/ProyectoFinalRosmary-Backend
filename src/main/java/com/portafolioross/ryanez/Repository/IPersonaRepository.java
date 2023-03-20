package com.portafolioross.ryanez.Repository;

import com.portafolioross.ryanez.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ryanez
 */
@Repository
public interface IPersonaRepository extends JpaRepository <Persona,Long>{
    
}
