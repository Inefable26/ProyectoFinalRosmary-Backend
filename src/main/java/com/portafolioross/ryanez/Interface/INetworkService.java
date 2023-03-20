/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolioross.ryanez.Interface;

import com.portafolioross.ryanez.Entity.Network;
import java.util.List;

/**
 *
 * @author ryanez
 */
public interface INetworkService {
  
    //Traer una lista 
    public List <Network> getNetwork ();
    
    //Guardar un objeto 
    public void saveNetwork (Network network);
    
    //Eliminar un objeto o usuario y buscamos por Id
    public void deleteNetwork (Long id);
    
    //Buscar  por Id
    public Network findNetwork(Long id);
}