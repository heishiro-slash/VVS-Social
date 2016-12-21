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
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import joinme.controlador.ControladorLogin;
import org.jcheck.annotations.Configuration;
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
@Configuration(tests = 10, size = 10)
public class GestorUsuarioTest {

    private ControladorLogin controlador;
    private GestorUsuario gestorUsuario;
    private GestorPerfil gestorPerfil;

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
        controlador = new ControladorLogin();
        gestorUsuario = GestorUsuario.getInstance();
        gestorPerfil = GestorPerfil.getInstance();
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
        List<Usuario> expResult = new ArrayList<>();
        List<Usuario> result = gestorUsuario.getUsuarios();
        assertEquals(expResult, result);

    }

    @Test
    public void testGetUsuarios() {
        try {
            controlador.creacionDatos("Eduardo");
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
     *
     * @param n nombre
     * @param ap1 Apellido 1
     * @param ap2 Apellido 2
     * @param fn fecha nacimiento *String
     * @throws exceptions.EmptyStringException
     */
    @Test(expected = EmptyStringException.class)
    public void testAltaUsuarioEmpty(String n, String ap1, String ap2, String fn) throws EmptyStringException {
        try {
            controlador.creacionDatos("Eduardo");
            System.out.println("altaUsuario");
            gestorUsuario.altaUsuario(n, ap1, ap2, "", fn, "");
        } catch (InvalidUserException e) {
        }
    }

    /**
     * Test of getUsuario method, of class GestorUsuario.
     *
     * @throws exceptions.EmptyStringException
     */
    @Test(expected = EmptyStringException.class)
    public void testGetUsuario() throws EmptyStringException {
        try {
            controlador.creacionDatos("Eduardo");
            System.out.println("getUsuario");
            String Alias = "";
            Usuario expResult = null;
            Usuario result = gestorUsuario.getUsuario(Alias);
        } catch (InvalidUserException e) {
        }
    }

    /**
     * Test of getUsuario method, of class GestorUsuario.
     *
     * @param a Alias
     * @throws exceptions.EmptyStringException
     */
    public void testGetUsuario(String a) throws EmptyStringException {
        try {
            controlador.creacionDatos("Eduardo");
            System.out.println("getUsuario");
            Usuario expResult = null;
            Usuario result = gestorUsuario.getUsuario(a);
            assertEquals(expResult, result);
        } catch (InvalidUserException e) {
        }
    }

    /**
     * Test of existeUsuario method, of class GestorUsuario.
     *
     * @param a Alias
     */
    @Test
    public void testExisteUsuario(String a) {
        try {
            controlador.creacionDatos("Eduardo");
            System.out.println("existeUsuario");
            String alias = "Eduardo";
            boolean result = gestorUsuario.existeUsuario(alias);
            assertTrue(result);
            result = gestorUsuario.existeUsuario(a);
            assertFalse(result);
        } catch (InvalidUserException | EmptyStringException e) {
        }
    }

    /**
     * Test of buscarUsuario method, of class GestorUsuario. Caso de prueba:
     * PR-UN-011
     *
     * @throws exceptions.EmptyStringException
     */
    @Test(expected = EmptyStringException.class)
    public void testBuscarUsuarioEmpty() throws EmptyStringException {
        try {
            controlador.creacionDatos("Eduardo");
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
            controlador.creacionDatos("Eduardo");
            System.out.println("buscarUsuario");
            String nombre = "Eduardo";
            String ap1 = "Gomez";
            String ap2 = "Gomez";
            Usuario user = gestorUsuario.getUsuario("Eduardo");
            List<Usuario> expResult = new ArrayList();
            expResult.add(user);
            List<Usuario> result = gestorUsuario.buscarUsuario(nombre, ap1, ap2);
            assertEquals(expResult, result);
        } catch (InvalidUserException | EmptyStringException e) {
        }
    }

    /**
     * Test of buscarUsuario method, of class GestorUsuario. Caso de prueba:
     * PR-UN-012
     *
     * @param n nombre
     * @param ap1 apellido1
     * @param ap2 apellido2
     */
    @Test
    public void testBuscarUsuarioNoExistente(String n, String ap1, String ap2) {
        try {
            controlador.creacionDatos("Eduardo");
            System.out.println("buscarUsuarioNoExistente");
            List<Usuario> expResult = new ArrayList();
            List<Usuario> result = gestorUsuario.buscarUsuario("Eduarda", "Gomeza", "Gomeza");
            assertEquals(expResult, result);
        } catch (InvalidUserException | EmptyStringException e) {
        }
    }

    /**
     * Test of aceptarSolicitud method, of class GestorUsuario. Caso de prueba:
     * PR-UN-013
     *
     * @throws exceptions.InvalidSolicitudException
     */
    @Test(expected = InvalidSolicitudException.class)
    public void testErrorAceptarSolicitud() throws InvalidSolicitudException, InvalidSolicitudException, InvalidSolicitudException, InvalidUserException, InvalidUserException {
        try {
            controlador.creacionDatos("Eduardo");
            System.out.println("aceptarSolicitud");
            Solicitud s = null;
            gestorUsuario.aceptarSolicitud(s);
        } catch (InvalidUserException | EmptyStringException e) {
        }
    }

    /**
     * Test of rechazarSolicitud method, of class GestorUsuario. Caso de prueba:
     * PR-UN-014
     *
     * @throws exceptions.InvalidSolicitudException
     */
    @Test(expected = InvalidSolicitudException.class)
    public void testErrorRechazarSolicitud() throws InvalidSolicitudException {
        try {
            controlador.creacionDatos("Eduardo");
            System.out.println("rechazarSolicitud");
            Solicitud s = null;
            gestorUsuario.rechazarSolicitud(s);
        } catch (InvalidUserException | EmptyStringException e) {
        }
    }

    /**
     * Test of verAmigos method, of class GestorUsuario. Caso de prueba:
     * PR-UN-015
     *
     * @throws exceptions.InvalidUserException
     */
    @Test(expected = InvalidUserException.class)
    public void testVerAmigosInvalidUser() throws InvalidUserException {
        try {
            controlador.creacionDatos("Eduardo");
            System.out.println("verAmigos");
            Usuario usuario = null;
            gestorUsuario.verAmigos(usuario);
        } catch (EmptyStringException e) {
        }
    }

    /**
     * Test of verAmigos method, of class GestorUsuario. Caso de prueba:
     * PR-UN-016
     *
     * @throws exceptions.InvalidUserException
     */
    @Test
    public void testVerAmigos() throws InvalidUserException {
        try {
            controlador.creacionDatos("Eduardo");
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
     * Test of verAmigos method, of class GestorUsuario. Caso de prueba:
     * PR-UN-017
     *
     * @throws exceptions.InvalidUserException
     */
    @Test
    public void testVerAmigosSinAmigos() throws InvalidUserException {
        try {
            controlador.creacionDatos("Eduardo");
            System.out.println("verAmigos");
            Usuario usuario = gestorUsuario.getUsuario("Eduardo");
            List<Usuario> expResult = new ArrayList();
            List<Usuario> result = gestorUsuario.verAmigos(usuario);
            assertEquals(expResult, result);
        } catch (EmptyStringException e) {
        }
    }

    /**
     * Test of anadirAmigo method, of class GestorUsuario. Caso de prueba:
     * PR-UN-018
     *
     * @throws exceptions.InvalidUserException
     */
    @Test(expected = InvalidUserException.class)
    public void testAnadirAmigoUsuarioInvalido() throws InvalidUserException {
        try {
            controlador.creacionDatos("Eduardo");
            System.out.println("anadirAmigo");
            Usuario usuario = null;
            String alias = "";
            gestorUsuario.anadirAmigo(usuario, alias);
        } catch (EmptyStringException e) {
        }
    }

    /**
     * Test of anadirAmigo method, of class GestorUsuario. Caso de prueba:
     * PR-UN-019
     *
     * @throws exceptions.EmptyStringException
     */
    @Test(expected = EmptyStringException.class)
    public void testAnadirAmigoAliasInvalido() throws EmptyStringException {
        try {
            controlador.creacionDatos("Eduardo");
            System.out.println("anadirAmigo");
            Usuario usuario = gestorUsuario.getUsuario("Eduardo");
            String alias = "";
            gestorUsuario.anadirAmigo(usuario, alias);
        } catch (InvalidUserException e) {
        }
    }

    /**
     * Test of class User.
     *
     * @param n Nombre
     * @param ap1 Apellido 1
     * @param ap2 Apellido 2
     * @param al Alias
     * @param fn Fecha nac
     * @param c Contraseña
     * @throws exceptions.EmptyStringException
     */
    @Test
    public void testUser(String n, String ap1, String ap2, String al, String fn, String c) throws EmptyStringException {
        try {
            System.out.println("TestUser");
            controlador.creacionDatos("Eduardo");
            Usuario usuario = gestorUsuario.getUsuario("Eduardo");
            usuario.setNombre(n);
            assertEquals(usuario.getNombre(), n);
            usuario.setApellido1(ap1);
            assertEquals(usuario.getApellido1(), ap1);
            usuario.setApellido2(ap2);
            assertEquals(usuario.getApellido2(), ap2);
            usuario.setAlias(al);
            assertEquals(usuario.getAlias(), al);
            usuario.setFechaNac(fn);
            assertEquals(usuario.getFechaNac(), fn);
            usuario.setContraseña(c);
            assertEquals(usuario.getContraseña(), c);

        } catch (InvalidUserException e) {
        }
    }

    /**
     * Test of class Perfil.
     *
     * @param f foto
     * @param dis diseño
     * @throws exceptions.EmptyStringException
     */
    @Test
    public void testPerfil(String f, String dis) throws EmptyStringException {
        System.out.println("TestPerfil");
        Perfil perfil = new Perfil("Eduardo", "Eduardo");
        perfil.setFoto(f);
        assertEquals(perfil.getFoto(), f);
        perfil.setDiseño(dis);
        assertEquals(perfil.getDiseño(), dis);

    }
    
    /**
     * Test of class Solicitud.
     *
     * @param f fecha
     * @param e estado
     * @throws exceptions.EmptyStringException
     */
    @Test
    public void testSolicitud(String e, long f) throws EmptyStringException, InvalidUserException {
        System.out.println("TestSolicitud");
        controlador.creacionDatos("Eduardo");
        Usuario usuario = gestorUsuario.getUsuario("Eduardo");
        List<Solicitud> solicitudes = usuario.getSolicitudes();
        Solicitud solicitud = solicitudes.get(0);
        solicitud.setEstado(e);
        assertEquals(solicitud.getEstado(),e);
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(f);
        solicitud.setFechaSolicitud(c);
        assertEquals(solicitud.getFechaSolicitud(),c);
        solicitud.getSolicitado();
        solicitud.getSolicitante();

    }
      /**
     * Test of Aceptar Solicitud.
     *
     * @throws exceptions.EmptyStringException
     * @throws exceptions.InvalidSolicitudException
     * @throws exceptions.InvalidUserException
     */
    @Test
    public void testAceptarSolicitud() throws EmptyStringException, InvalidSolicitudException, InvalidUserException {
        System.out.println("TestAceptarSolicitud");
        controlador.creacionDatos("Eduardo");
        Usuario usuario = gestorUsuario.getUsuario("Eduardo");
        List<Solicitud> solicitudes = usuario.getSolicitudes();
        gestorUsuario.aceptarSolicitud(solicitudes.get(0));
    }
         /**
     * Test of Aceptar Solicitud.
     *
     * @throws exceptions.EmptyStringException
     * @throws exceptions.InvalidSolicitudException
     * @throws exceptions.InvalidUserException
     */
    @Test
    public void testRechazarSolicitud() throws EmptyStringException, InvalidSolicitudException, InvalidUserException {
        System.out.println("TestRechazarSolicitud");
        controlador.creacionDatos("Eduardo");
        Usuario usuario = gestorUsuario.getUsuario("Eduardo");
        List<Solicitud> solicitudes = usuario.getSolicitudes();
        gestorUsuario.rechazarSolicitud(solicitudes.get(0));
    }
    
          /**
     * Test of Amigos.
     *
     * @throws exceptions.EmptyStringException
     * @throws exceptions.InvalidSolicitudException
     * @throws exceptions.InvalidUserException
     */
    @Test
    public void testAmigos() throws EmptyStringException, InvalidSolicitudException, InvalidUserException {
        System.out.println("TestAmigos");
        controlador.creacionDatos("Eduardo");
        Usuario victor = gestorUsuario.getUsuario("Victor");
        Usuario tino = gestorUsuario.getUsuario("Tino");
        assertTrue(victor.esAmigo(tino));
        Usuario jose = gestorUsuario.getUsuario("Jose");
    }
    
             /**
     * Test of Solicitud Repetida.
     *
     * @throws exceptions.EmptyStringException
     * @throws exceptions.InvalidSolicitudException
     * @throws exceptions.InvalidUserException
     */
    @Test
    public void testSolicitudRepetida() throws EmptyStringException, InvalidSolicitudException, InvalidUserException {
        System.out.println("TestAmigos");
        controlador.creacionDatos("Eduardo");
        Usuario eduardo = gestorUsuario.getUsuario("Eduardo");
        Usuario victor = gestorUsuario.getUsuario("Victor");
        eduardo.addSolicitud(new Solicitud(victor, eduardo));
    }
    
                /**
     * Test of Añadir amigo.
     *
     * @throws exceptions.EmptyStringException
     * @throws exceptions.InvalidSolicitudException
     * @throws exceptions.InvalidUserException
     */
    @Test
    public void testAñadirAmigo() throws EmptyStringException, InvalidSolicitudException, InvalidUserException {
        System.out.println("TestAmigos");
        controlador.creacionDatos("Eduardo");
        Usuario eduardo = gestorUsuario.getUsuario("Eduardo");
        gestorUsuario.anadirAmigo(eduardo, "Victor");
    }
}
