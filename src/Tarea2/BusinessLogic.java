/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea2;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Conper
 */
public class BusinessLogic extends ClienteDaoJsonImpl{

    public BusinessLogic(String file) throws ParseException {
        super(file);
    }
   
    
    @Override
    public void agregarCliente(Cliente client,String file){ 
        int id = 0;
        if (super.clientes!= null)
         while(id<= super.clientes.size())
          id++;
        client.setId(id);
        if ( (super.buscarCliente(client.getCedula()) == null) && (super.buscarCliente(client.getId()) == null) ){
            super.agregarCliente(client, file);
        }
    }
    
}
