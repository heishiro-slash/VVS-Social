/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joinme.modelo.usuario;

import java.util.ArrayList;
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
     * Caso de prueba: PR-UN-011
     */
    @Test
    public void testBuscarUsuario() {
        System.out.println("buscarUsuario");
        GestorUsuario gu = GestorUsuario.getInstance();
        String nombre = "Eduardo";
        String ap1 = "Gomez";
        String ap2 = "Gomez";
        Usuario user = gu.getUsuario("Eduardo");
        List<Usuario> expResult= new ArrayList();
        expResult.add(user);
        List<Usuario> result = gu.buscarUsuario(nombre, ap1, ap2);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of buscarUsuario method, of class GestorUsuario.
     * Caso de prueba: PR-UN-012
     */
    @Test
    public void testBuscarUsuarioNoExistente() {
        System.out.println("buscarUsuarioNoExistente");
        GestorUsuario gu = GestorUsuario.getInstance();
        String nombre = "Pepito";
        String ap1 = "Gomez";
        String ap2 = "Gomez";
        List<Usuario> expResult= new ArrayList();
        List<Usuario> result = gu.buscarUsuario(nombre, ap1, ap2);
        assertEquals(expResult, result);
    }

    /**
     * Test of aceptarSolicitud method, of class GestorUsuario.
     * Caso de prueba: PR-UN-013
     */
    @Test(expected = InvalidSolicitudException.class)
    public void testAceptarSolicitud() {
        System.out.println("aceptarSolicitud");
        GestorUsuario gu = GestorUsuario.getInstance();
        Solicitud s = null;
        gu.aceptarSolicitud(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rechazarSolicitud method, of class GestorUsuario.
     * Caso de prueba: PR-UN-014
     */
    @Test(expected = InvalidSolicitudException.class)
    public void testRechazarSolicitud() {
        System.out.println("rechazarSolicitud");
        Solicitud s = null;
        GestorUsuario gu = GestorUsuario.getInstance();
        gu.rechazarSolicitud(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of verAmigos method, of class GestorUsuario.
     * Caso de prueba: PR-UN-015
     */
    @Test(expected = InvalidUserException.class)
    public void testVerAmigosInvalidUser() {
        System.out.println("verAmigos");
        GestorUsuario gu = GestorUsuario.getInstance();
        Usuario usuario = null;
        gu.verAmigos(usuario);
    }

    /**
     * Test of verAmigos method, of class GestorUsuario.
     * Caso de prueba: PR-UN-016
     */
    @Test
    public void testVerAmigos() {
        System.out.println("verAmigos");
        GestorUsuario gu = GestorUsuario.getInstance();
        Usuario usuario = gu.getUsuario("Victor");
        Usuario amigo1 = gu.getUsuario("Tino");
        Usuario amigo2 = gu.getUsuario("Aba");
        List<Usuario> expResult = new ArrayList();
        expResult.add(amigo1);
        expResult.add(amigo2);
        List<Usuario> result = gu.verAmigos(usuario);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of verAmigos method, of class GestorUsuario.
     * Caso de prueba: PR-UN-017
     */
    @Test
    public void testVerAmigosSinAmigos() {
        System.out.println("verAmigos");
        GestorUsuario gu = GestorUsuario.getInstance();
        Usuario usuario = gu.getUsuario("Eduardo");
        List<Usuario> expResult = new ArrayList();
        List<Usuario> result = gu.verAmigos(usuario);
        assertEquals(expResult, result);
    }

    /**
     * Test of anadirAmigo method, of class GestorUsuario.
     * Caso de prueba: PR-UN-018
     */
    @Test(expected = InvalidUserException.class)
    public void testAnadirAmigoUsuarioInvalido() {
        System.out.println("anadirAmigo");
        GestorUsuario gu = GestorUsuario.getInstance();
        Usuario usuario = null;
        String alias = "";
        gu.anadirAmigo(usuario, alias);
    }
    
    /**
     * Test of anadirAmigo method, of class GestorUsuario.
     * Caso de prueba: PR-UN-019
     */
    @Test(expected = InvalidUserException.class)
    public void testAnadirAmigoAliasInvalido() {
        System.out.println("anadirAmigo");
        GestorUsuario gu = GestorUsuario.getInstance();
        Usuario usuario = null;
        String alias = "";
        gu.anadirAmigo(usuario, alias);
    }
    
}
