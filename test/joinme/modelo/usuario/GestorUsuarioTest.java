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
    private GestorUsuario gestorUsuario;
    
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
        gestorUsuario = GestorUsuario.getInstance();
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
        GestorUsuario expResult = gestorUsuario;
        GestorUsuario result = GestorUsuario.getInstance();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsuarios method, of class GestorUsuario.
     */
    @Test
    public void testGetUsuariosEmpty() {
        System.out.println("getUsuarios");
        List<Usuario> expResult = new ArrayList <>();
        List<Usuario> result = gestorUsuario.getUsuarios();
        assertEquals(expResult, result);
       
    }

    @Test
    public void testGetUsuarios() {
        controlador.creacionDatos ("Eduardo");
        System.out.println("getUsuarios");
        List<Usuario> expResult = new ArrayList();
        expResult.add(gestorUsuario.getUsuario("Eduardo"));
        expResult.add(gestorUsuario.getUsuario("Aba"));
        expResult.add(gestorUsuario.getUsuario("Tino"));
        expResult.add(gestorUsuario.getUsuario("Jose"));
        List<Usuario> result = gestorUsuario.getUsuarios();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of altaUsuario method, of class GestorUsuario.
     */
    @Test (expected = EmptyStringException.class)
    public void testAltaUsuarioEmpty() {
        controlador.creacionDatos ("Eduardo");
        System.out.println("altaUsuario");
        String nombre = "";
        String apellido1 = "";
        String apellido2 = "";
        String alias = "";
        String fechaNac = "";
        String contraseña = "";
        gestorUsuario.altaUsuario(nombre, apellido1, apellido2, alias, fechaNac, contraseña);
       
    }   

    /**
     * Test of getUsuario method, of class GestorUsuario.
     */
    @Test (expected = EmptyStringException.class)
    public void testGetUsuario() {
        controlador.creacionDatos ("Eduardo");
        System.out.println("getUsuario");
        String Alias = "";
        Usuario expResult = null;
        Usuario result = gestorUsuario.getUsuario(Alias);
        assertEquals(expResult, result);
    }

    /**
     * Test of existeUsuario method, of class GestorUsuario.
     */
    @Test
    public void testExisteUsuario() {
        controlador.creacionDatos ("Eduardo");
        System.out.println("existeUsuario");
        String alias = "Eduardo";
        boolean result = gestorUsuario.existeUsuario(alias);
        assertTrue(result);
        alias = "Pepito";
        result = gestorUsuario.existeUsuario(alias);
        assertFalse(result);
    }  

    /**
     * Test of buscarUsuario method, of class GestorUsuario.
     * Caso de prueba: PR-UN-011
     */
    @Test
    public void testBuscarUsuario() {
        controlador.creacionDatos ("Eduardo");
        System.out.println("buscarUsuario");
        String nombre = "Eduardo";
        String ap1 = "Gomez";
        String ap2 = "Gomez";
        Usuario user = gestorUsuario.getUsuario("Eduardo");
        List<Usuario> expResult= new ArrayList();
        expResult.add(user);
        List<Usuario> result = gestorUsuario.buscarUsuario(nombre, ap1, ap2);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of buscarUsuario method, of class GestorUsuario.
     * Caso de prueba: PR-UN-012
     */
    @Test
    public void testBuscarUsuarioNoExistente() {
        controlador.creacionDatos ("Eduardo");
        System.out.println("buscarUsuarioNoExistente");
        String nombre = "Pepito";
        String ap1 = "Gomez";
        String ap2 = "Gomez";
        List<Usuario> expResult= new ArrayList();
        List<Usuario> result = gestorUsuario.buscarUsuario(nombre, ap1, ap2);
        assertEquals(expResult, result);
    }

    /**
     * Test of aceptarSolicitud method, of class GestorUsuario.
     * Caso de prueba: PR-UN-013
     */
    @Test(expected = InvalidSolicitudException.class)
    public void testAceptarSolicitud() {
        controlador.creacionDatos ("Eduardo");
        System.out.println("aceptarSolicitud");
        Solicitud s = null;
        gestorUsuario.aceptarSolicitud(s);
    }

    /**
     * Test of rechazarSolicitud method, of class GestorUsuario.
     * Caso de prueba: PR-UN-014
     */
    @Test(expected = InvalidSolicitudException.class)
    public void testRechazarSolicitud() {
        controlador.creacionDatos ("Eduardo");
        System.out.println("rechazarSolicitud");
        Solicitud s = null;
        gestorUsuario.rechazarSolicitud(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of verAmigos method, of class GestorUsuario.
     * Caso de prueba: PR-UN-015
     */
    @Test(expected = InvalidUserException.class)
    public void testVerAmigosInvalidUser() {
        controlador.creacionDatos ("Eduardo");
        System.out.println("verAmigos");
        Usuario usuario = null;
        gestorUsuario.verAmigos(usuario);
    }

    /**
     * Test of verAmigos method, of class GestorUsuario.
     * Caso de prueba: PR-UN-016
     */
    @Test
    public void testVerAmigos() {
        controlador.creacionDatos ("Eduardo");
        System.out.println("verAmigos");
        Usuario usuario = gestorUsuario.getUsuario("Victor");
        Usuario amigo1 = gestorUsuario.getUsuario("Tino");
        Usuario amigo2 = gestorUsuario.getUsuario("Aba");
        List<Usuario> expResult = new ArrayList();
        expResult.add(amigo1);
        expResult.add(amigo2);
        List<Usuario> result = gestorUsuario.verAmigos(usuario);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of verAmigos method, of class GestorUsuario.
     * Caso de prueba: PR-UN-017
     */
    @Test
    public void testVerAmigosSinAmigos() {
        controlador.creacionDatos ("Eduardo");
        System.out.println("verAmigos");
        Usuario usuario = gestorUsuario.getUsuario("Eduardo");
        List<Usuario> expResult = new ArrayList();
        List<Usuario> result = gestorUsuario.verAmigos(usuario);
        assertEquals(expResult, result);
    }

    /**
     * Test of anadirAmigo method, of class GestorUsuario.
     * Caso de prueba: PR-UN-018
     */
    @Test(expected = InvalidUserException.class)
    public void testAnadirAmigoUsuarioInvalido() {
        controlador.creacionDatos ("Eduardo");
        System.out.println("anadirAmigo");
        Usuario usuario = null;
        String alias = "";
        gestorUsuario.anadirAmigo(usuario, alias);
    }
    
    /**
     * Test of anadirAmigo method, of class GestorUsuario.
     * Caso de prueba: PR-UN-019
     */
    @Test(expected = EmptyStringException.class)
    public void testAnadirAmigoAliasInvalido() {
        controlador.creacionDatos ("Eduardo");
        System.out.println("anadirAmigo");
        Usuario usuario = null;
        String alias = "";
        gestorUsuario.anadirAmigo(usuario, alias);
    }
    
}
