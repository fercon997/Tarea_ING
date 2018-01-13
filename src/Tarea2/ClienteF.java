/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea2;

import java.util.Date;
/**
 *
 * @author Conper
 */
public interface ClienteF {
    public void agregarCliente(String nombre, String apellido, long cedula, Date fechaUltima, String file);
    public Cliente buscarCliente(long cedula);
}
