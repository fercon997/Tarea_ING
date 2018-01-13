/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Conper
 */
public class ClienteDaoJsonImpl implements ClienteDao {
    ArrayList<Cliente> clientes;
    
    public ClienteDaoJsonImpl(String file) throws java.text.ParseException {
        JSONParser parser = new JSONParser();
        this.clientes = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            
        try {
            Object obj = parser.parse(new FileReader(file));
            JSONArray clients = (JSONArray) obj;
            Iterator i = clients.iterator();
            while(i.hasNext()){
                JSONObject client = (JSONObject) i.next();
                String nombre = (String) client.get("nombre");
                String apellido = (String) client.get("apellido");
                long cedula = (long) client.get("cedula");
                int id = (int) (long) client.get("id");
                Date fechaUltima = df.parse( (String) client.get("fechaUltima"));
                Cliente nuevo = new Cliente(nombre, apellido, cedula, fechaUltima, id);
                this.clientes.add(nuevo);  
                 
            }
  
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public ArrayList<Cliente> getClientes(){
        return this.clientes;
    }
    
    @Override
    public Cliente buscarCliente(long cedula){         
           if (this.clientes != null)
            for (Cliente client : this.clientes){
                if (client.getCedula() == cedula)
                 return client;
            }
            
        return null;
    }
    
    public Cliente buscarCliente(int id){
        if (this.clientes != null)    
         for (Cliente client : this.clientes){
            if (client.getId() == id)
             return client;
            } 
            
        return null;
    }
    
    @Override
    public void agregarCliente(Cliente client, String file){
       DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

       clientes.add(client);
       JSONArray clients = new JSONArray();
       for(int i=0; i<clientes.size();i++){
           JSONObject cliente = new JSONObject();
           cliente.put("nombre", client.getNombre());
           cliente.put("apellido", client.getApellido());
           cliente.put("cedula", client.getCedula());
           cliente.put("fechaUltima",df.format(client.getFechaUltima()));
           cliente.put("id", client.getId());
           clients.add(cliente);
       }
        try (FileWriter archivo = new FileWriter(file)) {
            archivo.write(clients.toJSONString());
            archivo.flush();
            archivo.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    
    
}
