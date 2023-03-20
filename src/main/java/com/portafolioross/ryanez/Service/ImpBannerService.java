package com.portafolioross.ryanez.Service;

import com.portafolioross.ryanez.Entity.Banner;
import com.portafolioross.ryanez.Repository.IBannerRepository;
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
public class ImpBannerService {
    @Autowired //Relación con el repositorio
    IBannerRepository iBannerRepository ;
    public List<Banner> list() {
        return iBannerRepository .findAll();
    }
    
    public Optional <Banner> getOne(int id) {
        return iBannerRepository .findById(id);
    }
    
    public Optional <Banner> getByImg(String img) {
        return iBannerRepository .findByImg (img);
    }
    
    public void save (Banner banner){
        iBannerRepository .save(banner);
    }
    
    public void delete (int id){
        iBannerRepository .deleteById(id);
    }
    
    public boolean existsById (int id) {
        return iBannerRepository .existsById(id);
    }
    
    public boolean existsByImg (String img) {
        return iBannerRepository .existsByImg(img);
    }
}
