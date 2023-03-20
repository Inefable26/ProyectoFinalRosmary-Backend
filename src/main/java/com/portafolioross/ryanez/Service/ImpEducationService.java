package com.portafolioross.ryanez.Service;

import com.portafolioross.ryanez.Entity.Education;
import com.portafolioross.ryanez.Repository.IEducationRepository;
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
public class ImpEducationService {
    @Autowired //Relación con el repositorio
    IEducationRepository iEducationRepository;
    public List<Education> list() {
        return iEducationRepository.findAll();
    }
    
    public Optional <Education> getOne(int id) {
        return iEducationRepository.findById(id);
    }
    
    public Optional <Education> getByTitulo(String titulo) {
        return iEducationRepository.findByTitulo (titulo);
    }
    
    public void save (Education educ){
        iEducationRepository.save(educ);
    }
    
    public void delete (int id){
        iEducationRepository.deleteById(id);
    }
    
    public boolean existsById (int id) {
        return iEducationRepository.existsById(id);
    }
    
    public boolean existsByTitulo (String titulo) {
        return iEducationRepository.existsByTitulo(titulo);
    }
}
