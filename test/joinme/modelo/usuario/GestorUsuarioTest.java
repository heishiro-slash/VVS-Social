/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joinme.modelo.usuario;

import exceptions.EmptyStringException;
import exceptions.InvalidSolicitudException;
import exceptions.InvalidUserException;
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
    }
    
    @After
    public void tearDown() {
        
        gestorUsuario.deleteUsers();
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
        try {
            controlador.creacionDatos ("Eduardo");
            System.out.println("getUsuarios");
            List<Usuario> expResult = new ArrayList();
            expResult.add(gestorUsuario.getUsuario("Eduardo"));
            expResult.add(gestorUsuario.getUsuario("Aba"));
            expResult.add(gestorUsuario.getUsuario("Victor"));
            expResult.add(gestorUsuario.getUsuario("Tino"));
            expResult.add(gestorUsuario.getUsuario("Jose"));
            List<Usuario> result = gestorUsuario.getUsuarios();
            assertEquals(expResult, result);
        } catch (InvalidUserException | EmptyStringException e) {
        }
    }
    
    /**
     * Test of altaUsuario method, of class GestorUsuario.
     * @throws exceptions.EmptyStringException
     */
    @Test (expected = EmptyStringException.class)
    public void testAltaUsuarioEmpty() throws EmptyStringException {
        try {
            controlador.creacionDatos ("Eduardo");
            System.out.println("altaUsuario");
            String nombre = "Jose";
            String apellido1 = "Ape1";
            String apellido2 = "Ape2";
            String alias = "";
            String fechaNac = "17021988";
            String contraseña = "";
            gestorUsuario.altaUsuario(nombre, apellido1, apellido2, alias, fechaNac, contraseña);
        } catch (InvalidUserException e) {
        }
    }   

    /**
     * Test of getUsuario method, of class GestorUsuario.
     * @throws exceptions.EmptyStringException
     */
    @Test (expected = EmptyStringException.class)
    public void testGetUsuario() throws EmptyStringException {
        try {
            controlador.creacionDatos ("Eduardo");
            System.out.println("getUsuario");
            String Alias = "";
            Usuario expResult = null;
            Usuario result = gestorUsuario.getUsuario(Alias);
            assertEquals(expResult, result);
        } catch (InvalidUserException e) {
        }
    }

    /**
     * Test of existeUsuario method, of class GestorUsuario.
     */
    @Test
    public void testExisteUsuario() {
        try {
            controlador.creacionDatos ("Eduardo");
            System.out.println("existeUsuario");
            String alias = "Eduardo";
            boolean result = gestorUsuario.existeUsuario(alias);
            assertTrue(result);
            alias = "Pepito";
            result = gestorUsuario.existeUsuario(alias);
            assertFalse(result);
        } catch (InvalidUserException | EmptyStringException e) {
        }
    }  

    /**
     * Test of buscarUsuario method, of class GestorUsuario.
     * Caso de prueba: PR-UN-011
     * @throws exceptions.EmptyStringException
     */
    @Test (expected = EmptyStringException.class)
    public void testBuscarUsuarioEmpty() throws EmptyStringException {
        try {
            controlador.creacionDatos ("Eduardo");
            System.out.println("buscarUsuario");
            String nombre = "";
            String ap1 = "";
            String ap2 = "";
            gestorUsuario.buscarUsuario(nombre, ap1, ap2);
        } catch (InvalidUserException e) {
        }
    }
    
    @Test
    public void testBuscarUsuario() {
        try {
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
        } catch (InvalidUserException | EmptyStringException e) {
        }
    }
    
    /**
     * Test of buscarUsuario method, of class GestorUsuario.
     * Caso de prueba: PR-UN-012
     */
    @Test
    public void testBuscarUsuarioNoExistente() {
        try {
            controlador.creacionDatos ("Eduardo");
            System.out.println("buscarUsuarioNoExistente");
            String nombre = "Pepito";
            String ap1 = "Gomezin";
            String ap2 = "Gomezin";
            List<Usuario> expResult= new ArrayList();
            List<Usuario> result = gestorUsuario.buscarUsuario(nombre, ap1, ap2);
            assertEquals(expResult, result);
        } catch (InvalidUserException | EmptyStringException e) {
        }
    }

    /**
     * Test of aceptarSolicitud method, of class GestorUsuario.
     * Caso de prueba: PR-UN-013
     * @throws exceptions.InvalidSolicitudException
     */
    @Test(expected = InvalidSolicitudException.class)
    public void testAceptarSolicitud() throws InvalidSolicitudException {
        try {
            controlador.creacionDatos ("Eduardo");
            System.out.println("aceptarSolicitud");
            Solicitud s = null;
            gestorUsuario.aceptarSolicitud(s);
        } catch (InvalidUserException | EmptyStringException e) {
        }
    }

    /**
     * Test of rechazarSolicitud method, of class GestorUsuario.
     * Caso de prueba: PR-UN-014
     * @throws exceptions.InvalidSolicitudException
     */
    @Test(expected = InvalidSolicitudException.class)
    public void testRechazarSolicitud() throws InvalidSolicitudException {
        try{
            controlador.creacionDatos ("Eduardo");
            System.out.println("rechazarSolicitud");
            Solicitud s = null;
            gestorUsuario.rechazarSolicitud(s);
        } catch (InvalidUserException | EmptyStringException e) {
        }
    }
    
    /**
     * Test of verAmigos method, of class GestorUsuario.
     * Caso de prueba: PR-UN-015
     * @throws exceptions.InvalidUserException
     */
    @Test(expected = InvalidUserException.class)
    public void testVerAmigosInvalidUser() throws InvalidUserException {
        try {
            controlador.creacionDatos ("Eduardo");
            System.out.println("verAmigos");
            Usuario usuario = null;
            gestorUsuario.verAmigos(usuario);
        } catch (EmptyStringException e) {
        }            
    }

    /**
     * Test of verAmigos method, of class GestorUsuario.
     * Caso de prueba: PR-UN-016
     * @throws exceptions.InvalidUserException
     */
    @Test
    public void testVerAmigos() throws InvalidUserException {
        try {
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
        } catch (EmptyStringException e) {
        }
    }
    
    /**
     * Test of verAmigos method, of class GestorUsuario.
     * Caso de prueba: PR-UN-017
     * @throws exceptions.InvalidUserException
     */
    @Test
    public void testVerAmigosSinAmigos() throws InvalidUserException {
        try {
            controlador.creacionDatos ("Eduardo");
            System.out.println("verAmigos");
            Usuario usuario = gestorUsuario.getUsuario("Eduardo");
            List<Usuario> expResult = new ArrayList();
            List<Usuario> result = gestorUsuario.verAmigos(usuario);
            assertEquals(expResult, result);
        } catch (EmptyStringException e) {
        }
    }

    /**
     * Test of anadirAmigo method, of class GestorUsuario.
     * Caso de prueba: PR-UN-018
     * @throws exceptions.InvalidUserException
     */
    @Test(expected = InvalidUserException.class)
    public void testAnadirAmigoUsuarioInvalido() throws InvalidUserException {
        try {
            controlador.creacionDatos ("Eduardo");
            System.out.println("anadirAmigo");
            Usuario usuario = null;
            String alias = "";
            gestorUsuario.anadirAmigo(usuario, alias);
        } catch (EmptyStringException e) {
        }
    }
    
    /**
     * Test of anadirAmigo method, of class GestorUsuario.
     * Caso de prueba: PR-UN-019
     * @throws exceptions.EmptyStringException
     */
    @Test(expected = EmptyStringException.class)
    public void testAnadirAmigoAliasInvalido() throws EmptyStringException {
        try {
            controlador.creacionDatos ("Eduardo");
            System.out.println("anadirAmigo");
            Usuario usuario = gestorUsuario.getUsuario("Eduardo");
            String alias = "";
            gestorUsuario.anadirAmigo(usuario, alias);
        } catch (InvalidUserException e) {
        }
    }
    
}
