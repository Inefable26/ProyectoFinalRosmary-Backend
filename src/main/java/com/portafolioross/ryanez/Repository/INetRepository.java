package com.portafolioross.ryanez.Repository;

import com.portafolioross.ryanez.Entity.Network;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ryanez
 */
@Repository
public interface INetRepository extends JpaRepository <Network, Integer>{
    public Optional<Network> findByCuenta(String cuenta);
    public boolean existsByCuenta(String cuenta);
    
}


