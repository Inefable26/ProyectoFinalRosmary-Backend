package com.portafolioross.ryanez.Dto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author ryanez
 */

public class dtoNetwork  {
   @NotBlank
   private String cuenta;
   private String url_icono_red;
    
    
    //Constructores

    public dtoNetwork() {
    }

    public dtoNetwork( String cuenta,String url_icono_red) {
        this.cuenta = cuenta;
        this.url_icono_red = url_icono_red;
       
    }
    
    //Gets and Sets

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