package com.portafolioross.ryanez.Dto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author ryanez
 */
public class dtoProject {
    @NotBlank
    private String titulo;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String ano;
    private String url_img_project;
    
    
    //Constructores

    public dtoProject() {
    }

    public dtoProject(String titulo, String descripcion, String ano, String url_img_project) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.ano = ano;
        this.url_img_project = url_img_project;
    }
    
    //Gets and Sets

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getUrl_img_project() {
        return url_img_project;
    }

    public void setUrl_img_project(String url_img_project) {
        this.url_img_project = url_img_project;
    }
    
    
}
