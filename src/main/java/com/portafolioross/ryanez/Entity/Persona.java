package com.portafolioross.ryanez.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ryanez
 */
@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size (min =1, max= 35, message="no cumple con la longitud")
    private String nombre;
    
    @NotNull
    @Size (min =1, max= 50, message="no cumple con la longitud")
    private String apellido;
    
    @NotNull
    @Size (min =1, max= 100, message="no cumple con la longitud")
    private String img;
    
    @NotNull
    @Size (min =1, max= 50, message="no cumple con la longitud")
    private String nombredescrip;
    
    @NotNull
    @Size (min =1, max= 150, message="no cumple con la longitud")
    private String descripcion;    
    
}
