
package com.portafolioross.ryanez.Service;

import com.portafolioross.ryanez.Entity.Experience;
import com.portafolioross.ryanez.Repository.IExperienceRepository;
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
public class ImpExperienceService {
    @Autowired //Relación con el repositorio
    IExperienceRepository iExperienceRepository;
    public List<Experience> list() {
        return iExperienceRepository.findAll();
    }
    
    public Optional <Experience> getOne(int id) {
        return iExperienceRepository.findById(id);
    }
    
    public Optional <Experience> getByPuesto(String puesto) {
        return iExperienceRepository.findByPuesto (puesto);
    }
    
    public void save (Experience exp){
        iExperienceRepository.save(exp);
    }
    
    public void delete (int id){
        iExperienceRepository.deleteById(id);
    }
    
    public boolean existsById (int id) {
        return iExperienceRepository.existsById(id);
    }
    
    public boolean existsByPuesto (String puesto) {
        return iExperienceRepository.existsByPuesto(puesto);
    }
}
