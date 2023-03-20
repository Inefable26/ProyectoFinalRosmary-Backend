package com.portafolioross.ryanez.Dto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author ryanez
 */
public class dtoSkills {
    @NotBlank
    private String habilidad;
    @NotBlank
    private int porcentaje;
    @NotBlank
    private String subtitle;
    @NotBlank
    private String tipo;
    
    
    //Constructores

    public dtoSkills() {
    }

    public dtoSkills(String habilidad, int porcentaje, String subtitle, String tipo) {
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
        this.subtitle = subtitle;
        this.tipo = tipo;
    }
    
    //Gets and Sets

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setAno(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
