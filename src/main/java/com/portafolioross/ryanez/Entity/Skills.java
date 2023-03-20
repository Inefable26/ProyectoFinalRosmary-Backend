/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String habilidad;
    private int porcentaje;
    private String subtitle;
    
    private String tipo; //hard o soft
    
    //Constructores

    public Skills() {
    }

    public Skills(String habilidad, int porcentaje, String subtitle, String tipo) {
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
        this.subtitle = subtitle;
        this.tipo = tipo;
    }
    
    //Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public int getPorcentaje() { //El que mueve la barra del círculo
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    public String getSubtitle() { //El que indica al usuario el porcentaje o nivel
        return subtitle;
    }

    public void setSubtitle(String subtitle) { 
        this.subtitle = subtitle;
    }
   
     public String getTipo() { //Hard o Soft
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
