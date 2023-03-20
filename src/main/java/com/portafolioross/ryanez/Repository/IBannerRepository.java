package com.portafolioross.ryanez.Repository;

import com.portafolioross.ryanez.Entity.Banner;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ryanez
 */
@Repository
public interface IBannerRepository extends JpaRepository <Banner, Integer>{
    public Optional <Banner> findByImg(String img);
    public boolean existsByImg(String img);
    
}