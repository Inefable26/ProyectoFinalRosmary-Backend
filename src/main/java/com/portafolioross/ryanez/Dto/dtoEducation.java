package com.portafolioross.ryanez.Dto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author ryanez
 */
public class dtoEducation {
    @NotBlank
    private String titulo;
    @NotBlank
    private String institucion;
    @NotBlank
    private String ano;
    private String url_logo;
    
    
    //Constructores

    public dtoEducation() {
    }

    public dtoEducation(String titulo, String institucion, String ano, String url_logo) {
        this.titulo = titulo;
        this.institucion = institucion;
        this.ano = ano;
        this.url_logo = url_logo;
    }
    
    //Gets and Sets

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
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
