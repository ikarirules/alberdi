/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.nio.charset.Charset;

import org.junit.BeforeClass;
import org.junit.Test;
import principal.Configurar;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * @author lauta
 */
public class ModeloLoginTest {

    @BeforeClass
    public static void setUpClass() {
        /*Llamada al constructor configurar, encargado de levantar la base de datos*/
        new Configurar();
    }

    @Test
    /*Test que comprueba el funcionamiento del método comprobar existencia*/
    /*Envia un usuario que no existe en la base de datos, por ende espera un resultado false*/
    public void testExistenciaFalse() {
        Usuario user = new Usuario("leo", "2221");
        ModeloLogin instance = new ModeloLogin();
        boolean result = instance.comprobarExistencia(user);
        assertEquals(false, result);
    }

    @Test
    /*Test que comprueba el funcionamiento del método comprobar existencia*/
    /*Envia un usuario que existe en la base de datos, por ende espera un resultado true*/
    public void testExistenciaTrue() {
        Usuario user = new Usuario("marcelo", "123");
        ModeloLogin instance = new ModeloLogin();
        boolean result = instance.comprobarExistencia(user);
        assertEquals(true, result);
    }

    @Test
    /*Test que comprueba el funcionamiento de la excepción del método comprobar existencia*/
    /*ingresamos comillas y comas que alteran el ingreso de datos esperado*/
    /*esto proboca un error, ejecutando el catch y devolviendo false*/
    public void testExistenciaCatch() {
        Usuario user = new Usuario(",',", "");
        ModeloLogin instance = new ModeloLogin();
        boolean result = instance.comprobarExistencia(user);
        assertEquals(false, result);

    }

    @Test
    /*Test que comprueba el funcionamiento del metodo insertar usuarios*/
    /*genera aleatoriamente un usuario, y lo comprueba. Al ser aleatorio no se repite en la bd y cumple con UNIQUE*/
    /*devuelve un valor true*/
    public void testInsert() {
        byte[] array = new byte[7]; /* length is bounded by 7*/
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        Usuario user = new Usuario(generatedString, "123");
        ModeloLogin instance = new ModeloLogin();
        boolean result = instance.insertar(user);
        assertEquals(true, result);
    }

    @Test
    /*Comprueba el método insertar, pero al ingresar un usuario ya existente en la base de datos*/
    /*obtendremos un false debido a que se ejecuta la restricción de unique aplicada a usuario(solo a usuario no a password).*/
    public void testInsertRepetido() {
        Usuario user = new Usuario("lautaro", "12345");
        ModeloLogin instance = new ModeloLogin();
        boolean result = instance.insertar(user);
        assertEquals(false, result);
    }

    @Test
    /*Comprueba el método seleccionar, que selecciona un nombre usuario si este existe*/
    /*El metodo devolvera un String con el nombre del usuario si este existe*/
    public void testSeleccionar1() {
        Usuario user = new Usuario("marcelo", "123");
        ModeloLogin instance = new ModeloLogin();
        String result = instance.seleccionar(user);
        assertEquals("marcelo", result);
    }

    @Test
    public void testSeleccionar2() {
        Usuario user = new Usuario("carlos", "123456");
        ModeloLogin instance = new ModeloLogin();
        String result = instance.seleccionar(user);
        assertEquals("", result);
    }

    @Test
    /*Comprueba si el nombre del nuevo usuario que vamos a ingresar ya existe*/
    /*Se espera un resultado true*/
    public void testNombreDeUsuarioRepetido1() {
        Usuario user = new Usuario("lautaro", "12345");
        ModeloLogin instance = new ModeloLogin();
        boolean result = instance.nombreDeUsuarioRepetido(user);
        assertEquals(true, result);
    }

    @Test
    /*Comprueba si el nombre del nuevo usuario que vamos a ingresar ya existe*/
    /*Se espera un resultado false*/
    public void testNombreDeUsuarioRepetido2() {
        Usuario user = new Usuario("lautaros", "12345");
        ModeloLogin instance = new ModeloLogin();
        boolean result = instance.nombreDeUsuarioRepetido(user);
        assertEquals(false, result);
    }
}
