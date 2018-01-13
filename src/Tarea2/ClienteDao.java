/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Conper
 */
public interface ClienteDao {
    public ArrayList<Cliente> getClientes();
    public void agregarCliente(Cliente client, String file);
    public Cliente buscarCliente(long cedula);
}
