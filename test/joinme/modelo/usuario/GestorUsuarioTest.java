/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joinme.modelo.usuario;

import java.util.List;
import joinme.controlador.ControladorLogin;
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
public class GestorUsuarioTest {
    
    private ControladorLogin controlador;
    
    public GestorUsuarioTest() {
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
     * Test of getInstance method, of class GestorUsuario.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        GestorUsuario expResult = null;
        GestorUsuario result = GestorUsuario.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuarios method, of class GestorUsuario.
     */
    @Test
    public void testGetUsuarios() {
        System.out.println("getUsuarios");
        GestorUsuario instance = null;
        List<Usuario> expResult = null;
        List<Usuario> result = instance.getUsuarios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of altaUsuario method, of class GestorUsuario.
     */
    @Test
    public void testAltaUsuario() {
        System.out.println("altaUsuario");
        String nombre = "";
        String apellido1 = "";
        String apellido2 = "";
        String alias = "";
        String fechaNac = "";
        String contraseña = "";
        GestorUsuario instance = null;
        Usuario expResult = null;
        Usuario result = instance.altaUsuario(nombre, apellido1, apellido2, alias, fechaNac, contraseña);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuario method, of class GestorUsuario.
     */
    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        String Alias = "";
        GestorUsuario instance = null;
        Usuario expResult = null;
        Usuario result = instance.getUsuario(Alias);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existeUsuario method, of class GestorUsuario.
     */
    @Test
    public void testExisteUsuario() {
        System.out.println("existeUsuario");
        String alias = "";
        GestorUsuario instance = null;
        boolean expResult = false;
        boolean result = instance.existeUsuario(alias);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarUsuario method, of class GestorUsuario.
     */
    @Test
    public void testBuscarUsuario() {
        System.out.println("buscarUsuario");
        String nombre = "";
        String ap1 = "";
        String ap2 = "";
        GestorUsuario instance = null;
        List<Usuario> expResult = null;
        List<Usuario> result = instance.buscarUsuario(nombre, ap1, ap2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aceptarSolicitud method, of class GestorUsuario.
     */
    @Test
    public void testAceptarSolicitud() {
        System.out.println("aceptarSolicitud");
        Solicitud s = null;
        GestorUsuario instance = null;
        instance.aceptarSolicitud(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rechazarSolicitud method, of class GestorUsuario.
     */
    @Test
    public void testRechazarSolicitud() {
        System.out.println("rechazarSolicitud");
        Solicitud s = null;
        GestorUsuario instance = null;
        instance.rechazarSolicitud(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verAmigos method, of class GestorUsuario.
     */
    @Test
    public void testVerAmigos() {
        System.out.println("verAmigos");
        Usuario usuario = null;
        GestorUsuario instance = null;
        List<Usuario> expResult = null;
        List<Usuario> result = instance.verAmigos(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of anadirAmigo method, of class GestorUsuario.
     */
    @Test
    public void testAnadirAmigo() {
        System.out.println("anadirAmigo");
        Usuario usuario = null;
        String alias = "";
        GestorUsuario instance = null;
        instance.anadirAmigo(usuario, alias);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
