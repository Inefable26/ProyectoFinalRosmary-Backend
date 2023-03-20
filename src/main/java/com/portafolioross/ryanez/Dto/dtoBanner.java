/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioross.ryanez.Dto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author ryanez
 */
public class dtoBanner {
    @NotBlank
    private String img;
   
    
    //Constructores

    public dtoBanner() {
    }

    public dtoBanner(String img) {
        this.img = img;
       
    }
    
    //Gets and Sets

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    
    
}
