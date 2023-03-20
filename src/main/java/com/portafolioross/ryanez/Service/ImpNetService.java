package com.portafolioross.ryanez.Service;

import com.portafolioross.ryanez.Entity.Network;
import com.portafolioross.ryanez.Repository.INetRepository;
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
public class ImpNetService  {
    @Autowired //Relación con el repositorio
    INetRepository iNetRepository;
    public List<Network> list() {
        return iNetRepository.findAll();
    }
    
    public Optional <Network> getOne(int id) {
        return iNetRepository.findById(id);
    }
    
    public Optional <Network> getByCuenta(String cuenta) {
        return iNetRepository.findByCuenta(cuenta);
    }
    
    public void save (Network network){
        iNetRepository.save(network);
    }
    
    public void delete (int id){
        iNetRepository.deleteById(id);
    }
    
    public boolean existsById (int id) {
        return iNetRepository.existsById(id);
    }
    
   public boolean existsByCuenta(String cuenta) {
        return iNetRepository.existsByCuenta(cuenta);
    }
}