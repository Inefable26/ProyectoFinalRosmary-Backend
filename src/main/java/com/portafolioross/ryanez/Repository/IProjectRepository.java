package com.portafolioross.ryanez.Repository;

import com.portafolioross.ryanez.Entity.Project;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ryanez
 */
@Repository
public interface IProjectRepository extends JpaRepository <Project, Integer>{
    public Optional <Project> findByTitulo(String titulo);
    public boolean existsByTitulo(String titulo);
    
}
