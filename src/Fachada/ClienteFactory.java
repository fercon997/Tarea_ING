/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fachada;

import Tarea2.*;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author Conper
 */
public class ClienteFactory {
    ClienteF clientes;

    public ClienteFactory(String file) throws ParseException {
        clientes = new ClienteConcr(file);
    }

    
    public void agregarCliente(String nombre, String apellido, long cedula, Date fechaUltima, String file){
        clientes.agregarCliente(nombre, apellido, cedula, fechaUltima, file);
    }
    
    public Cliente buscarPorCedula(long cedula){
        return clientes.buscarCliente(cedula); 
    }
    
    public void buscarPorId(int id){
        clientes.buscarCliente(id);
    }
}
