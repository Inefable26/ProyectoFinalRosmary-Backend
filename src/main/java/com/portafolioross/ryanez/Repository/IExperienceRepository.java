package com.portafolioross.ryanez.Repository;

import com.portafolioross.ryanez.Entity.Experience;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ryanez
 */
@Repository
public interface IExperienceRepository extends JpaRepository <Experience, Integer>{
    public Optional <Experience> findByPuesto(String puesto);
    public boolean existsByPuesto(String puesto);
    
}
