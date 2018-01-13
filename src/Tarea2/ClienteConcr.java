/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea2;

import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author Conper
 */
public class ClienteConcr implements ClienteF {
    BusinessLogic clientes;
    
    public ClienteConcr(String file) throws ParseException{
        this.clientes = new BusinessLogic(file);
    }
    
    @Override
    public void agregarCliente(String nombre, String apellido, long cedula, Date fechaUltima, String file){
        Cliente agregar = new Cliente(nombre, apellido, cedula, fechaUltima, 0);
        clientes.agregarCliente(agregar, file);
    }
    
    @Override
    public Cliente buscarCliente(long cedula){
        return clientes.buscarCliente(cedula);
    }
    
    public Cliente buscarCliente(int id){
        return clientes.buscarCliente(id);
    }
    
}
