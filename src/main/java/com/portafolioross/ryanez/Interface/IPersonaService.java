package com.portafolioross.ryanez.Interface;

import com.portafolioross.ryanez.Entity.Persona;
import java.util.List;

/**
 * @author ryanez
 */
public interface IPersonaService {
    //Traer una lista de personas
    public List <Persona> getPersona ();
    
    //Guardar un objeto de tipo Persona
    public void savePersona (Persona persona);
    
    //Eliminar un objeto o usuario y buscamos por Id
    public void deletePersona (Long id);
    
    //Buscar una persona por Id
    public Persona findPersona(Long id);
}
