package com.portafolioross.ryanez.Service;

import com.portafolioross.ryanez.Entity.Project;
import com.portafolioross.ryanez.Repository.IProjectRepository;
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
public class ImpProjectService {
    @Autowired //Relación con el repositorio
    IProjectRepository iProjectRepository ;
    public List<Project> list() {
        return iProjectRepository .findAll();
    }
    
    public Optional <Project> getOne(int id) {
        return iProjectRepository .findById(id);
    }
    
    public Optional <Project> getByTitulo(String titulo) {
        return iProjectRepository .findByTitulo (titulo);
    }
    
    public void save (Project proj){
        iProjectRepository .save(proj);
    }
    
    public void delete (int id){
        iProjectRepository .deleteById(id);
    }
    
    public boolean existsById (int id) {
        return iProjectRepository .existsById(id);
    }
    
    public boolean existsByTitulo (String titulo) {
        return iProjectRepository .existsByTitulo(titulo);
    }
}
