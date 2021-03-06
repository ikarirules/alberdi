/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import modelos.Envase;
import modelos.Tapa;
import utilidades.Validador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author caro_
 */
public class ValidadorTest {
    
    public ValidadorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of validarTapa method, of class Validador.
     */
    @Test
    public void testValidarTapa() {
        System.out.println("validarTapa");
        String nombre = "";
        String descripcion = "";
        Tapa tapa = new Tapa(nombre,descripcion);
        Validador instance = new Validador();
        boolean expResult = false;
        boolean result = instance.validarTapa(tapa);
        assertEquals(expResult, result);
    }

    /**
     * Test of validarEnvase method, of class Validador.
     */
    @Test
    public void testValidarEnvase() {
        System.out.println("validarEnvase");
        String nombre = "";
        String tipo = "";
        String descripcion = "";
        int volumen = 1;
        Envase envase = new Envase(nombre, tipo, volumen,descripcion);
        Validador instance = new Validador();
        boolean expResult = false;
        boolean result = instance.validarEnvase(envase);
        assertEquals(expResult, result);
    }
    @Test
    public void testtValidarMovimietno(){
        Validador f = new Validador();
        boolean resultado = f.validarMovimiento("4", 5, null);
        assertFalse(resultado);
    }
}
