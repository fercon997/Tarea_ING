/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fachada;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Conper
 */
public class ClienteFactoryTest {
    
    public ClienteFactoryTest() {
    }
    
    
    @Before
    public void setUp() {
        try (FileWriter archivo = new FileWriter(System.getProperty("user.dir")+"\\test\\Fachada\\test.json")) {
            JSONObject cliente = new JSONObject();
           cliente.put("nombre", "Juan");
           cliente.put("apellido", "Rodriguez");
           cliente.put("cedula", 28912345);
           cliente.put("fechaUltima", "08/09/97");
           cliente.put("id", 1);
            archivo.write("["+cliente.toJSONString()+"]");
            archivo.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAgregarClienteCorrecto() throws ParseException {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println("Agrega el cliente correctamente");
        String nombre = "Fernando";
        String apellido = "Consalvo";
        long cedula = 25964266;
        Date fechaUltima = df.parse("10/21/2017");
        String file = System.getProperty("user.dir")+"\\test\\Fachada\\test.json";
        ClienteFactory instance = new ClienteFactory(file);
        instance.agregarCliente(nombre, apellido, cedula, fechaUltima, file);
        ClienteFactory after = new ClienteFactory(file);
        try{
            assertEquals(cedula, after.buscarPorCedula(cedula).getCedula());  
        } catch(Exception e){
            fail("El usuario no se agrego correctamente");
        }
    }
    
    @Test
    public void testAgregarClienteWrong() throws ParseException {
         DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println("Si la cedula esta repetida el cliente no se agrega");
        String nombre = "Fernando";
        String apellido = "Consalvo";
        long cedula = 28912345;
        Date fechaUltima = df.parse("10/21/2017");
        String file = System.getProperty("user.dir")+"\\test\\Fachada\\test.json";
        ClienteFactory instance = new ClienteFactory(file);
        instance.agregarCliente(nombre, apellido, cedula, fechaUltima, file);
        ClienteFactory after = new ClienteFactory(file);
        try{
            assertEquals(null, after.buscarPorId(2));
        } catch(Exception e){
            fail("El usuario no se agrego correctamente");
        }
    }

    @Test
    public void testBuscarPorCedula() throws ParseException {
        System.out.println("Retorna el usauario si se encuentra");
        long cedula = 28912345;
        ClienteFactory instance = new ClienteFactory(System.getProperty("user.dir")+"\\test\\Fachada\\test.json");
        try{
            assertEquals(cedula, instance.buscarPorCedula(cedula).getCedula());
        } catch(Exception e){
            fail("El cliente no se encontro");
        }
        System.out.println("Retorna nulo si el usuario no se enceuntra");
        cedula = 22767267;
        try{
            assertEquals(null, instance.buscarPorCedula(cedula));
        } catch(Exception e)
            fail("La cedula esta registrada");
    }

    @Test
    public void testBuscarPorId() throws ParseException {
        System.out.println("Retorna el usauario si se encuentra");
        int id = 1;
        ClienteFactory instance = new ClienteFactory(System.getProperty("user.dir")+"\\test\\Fachada\\test.json");
        try{
            assertEquals("Juan", instance.buscarPorId(id).getNombre());
        } catch(Exception e){
            fail("El cliente no se encontro");
        }
        System.out.println("Retorna nulo si el usuario no se enceuntra");
        id = 7;
        try{
            assertEquals(null, instance.buscarPorId(id));
        } catch(Exception e)
            fail("La cedula esta registrada");
    }
    
}
