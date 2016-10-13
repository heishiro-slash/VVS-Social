/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joinme.modelo.muro;

import joinme.controlador.ControladorLogin;
import joinme.modelo.usuario.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class GestorMuroTest {
    
    private ControladorLogin controlador;
    public GestorMuroTest() {
        
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        controlador  = new ControladorLogin();
        controlador.creacionDatos ("Eduardo");
    }

@After
        public void tearDown() {
    }

    /**
     * Test of getInstance method, of class GestorMuro.
     */
    @Test
        public void testGetInstance() {
        System.out.println("getInstance");
        GestorMuro expResult = null;
        GestorMuro result = GestorMuro.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMuro method, of class GestorMuro.
     */
    @Test
        public void testGetMuro() {
        System.out.println("getMuro");
        Usuario usuario = null;
        GestorMuro instance = null;
        Muro expResult = null;
        Muro result = instance.getMuro(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of publicarEntrada method, of class GestorMuro.
     */
    @Test
        public void testPublicarEntrada_Usuario_String() {
        System.out.println("publicarEntrada");
        Usuario usuario = null;
        String mensaje = "";
        GestorMuro instance = null;
        instance.publicarEntrada(usuario, mensaje);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of publicarEntrada method, of class GestorMuro.
     */
    @Test
        public void testPublicarEntrada_5args() {
        System.out.println("publicarEntrada");
        Usuario usuario = null;
        String mensaje = "";
        String media = "";
        String categoria = "";
        String visibilidad = "";
        GestorMuro instance = null;
        instance.publicarEntrada(usuario, mensaje, media, categoria, visibilidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
