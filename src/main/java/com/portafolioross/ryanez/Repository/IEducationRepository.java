package com.portafolioross.ryanez.Repository;

import com.portafolioross.ryanez.Entity.Education;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ryanez
 */
@Repository
public interface IEducationRepository extends JpaRepository <Education, Integer>{
    public Optional <Education> findByTitulo(String titulo);
    public boolean existsByTitulo(String titulo);
    
}
