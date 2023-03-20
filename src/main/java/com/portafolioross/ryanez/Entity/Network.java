package com.portafolioross.ryanez.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author ryanez
 */
@Entity
public class Network {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cuenta ;
    private String url_icono_red;
    
    //Constructores

    public Network() {
    }

    public Network( String cuenta,String url_icono_red) {
        this.cuenta = cuenta;
        this.url_icono_red = url_icono_red;
        
   
    }
    
    //Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getUrl_icono_red() {
        return url_icono_red;
    }

    public void setUrl_icono_red(String url_icono_red) {
        this.url_icono_red = url_icono_red;
    }
}