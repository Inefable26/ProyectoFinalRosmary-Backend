package com.portafolioross.ryanez.Dto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author ryanez
 */
public class dtoExperience {
    @NotBlank
    private String puesto;
    @NotBlank
    private String organizacion;
    @NotBlank
    private String ano;
    private String url_logo;
    
    
    //Constructores

    public dtoExperience() {
    }

    public dtoExperience(String puesto, String organizacion, String ano, String url_logo) {
        this.puesto = puesto;
        this.organizacion = organizacion;
        this.ano = ano;
        this.url_logo = url_logo;
    }
    
    //Gets and Sets

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getUrl_logo() {
        return url_logo;
    }

    public void setUrl_logo(String url_logo) {
        this.url_logo = url_logo;
    }
    
    
}
