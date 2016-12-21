/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joinme.modelo.muro;

import exceptions.EmptyStringException;
import exceptions.InvalidUserException;
import joinme.controlador.ControladorLogin;
import joinme.modelo.usuario.GestorUsuario;
import joinme.modelo.usuario.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/**
 *
 * @author Admin
 */
@RunWith(org.jcheck.runners.JCheckRunner.class)
public class GestorMuroTest {

    private ControladorLogin controlador;
    private GestorMuro gestorMuro;
    private GestorUsuario gestorUsuario;
    private Usuario usuario;

    public GestorMuroTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws InvalidUserException, EmptyStringException {
        controlador = new ControladorLogin();
        controlador.creacionDatos("Eduardo");
        gestorMuro = GestorMuro.getInstance();
        gestorUsuario = GestorUsuario.getInstance();
        usuario = gestorUsuario.getUsuario("Eduardo");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        GestorMuro expResult = gestorMuro;
        GestorMuro result = GestorMuro.getInstance();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMuro method, of class GestorMuro.
     * @throws exceptions.InvalidUserException
     */
    @Test(expected = InvalidUserException.class)
    public void testGetMuro() throws InvalidUserException {
        System.out.println("getMuro");
        Usuario usuarioEmpty = null;
        gestorMuro.getMuro(usuarioEmpty);
    }

    /**
     * Test of publicarEntrada method, of class GestorMuro.
     * @throws exceptions.InvalidUserException
     * @throws exceptions.EmptyStringException
     */
    @Test(expected = EmptyStringException.class)
    public void testPublicarEntrada_Usuario_String() throws InvalidUserException, EmptyStringException {
        System.out.println("publicarEntrada");
        String mensaje = "";
        gestorMuro.publicarEntrada(usuario, mensaje);
    }

    /**
     * Test of publicarEntrada method, of class GestorMuro.
     * @throws exceptions.InvalidUserException
     * @throws exceptions.EmptyStringException
     */
    @Test(expected = EmptyStringException.class)
    public void testPublicarEntrada_5args() throws InvalidUserException, EmptyStringException {
        System.out.println("publicarEntrada");
        String mensaje = "";
        String media = "";
        String categoria = "";
        String visibilidad = "";
        gestorMuro.publicarEntrada(usuario, mensaje, media, categoria, visibilidad);

    }
    
}
