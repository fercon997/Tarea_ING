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
public class Cliente {
   private String nombre; 
   private String apellido;
   private long cedula;
   private Date fechaUltima;
   private int id;

    public Cliente(String nombre, String apellido, long cedula, Date fechaUltima, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaUltima = fechaUltima;
        this.id = id;
    }

    public Cliente() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public Date getFechaUltima() {
        return fechaUltima;
    }

    public void setFechaUltima(Date fechaUltima) {
        this.fechaUltima = fechaUltima;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
    
   
   
}
