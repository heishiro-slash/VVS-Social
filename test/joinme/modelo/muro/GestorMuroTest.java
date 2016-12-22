/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joinme.modelo.muro;

import exceptions.EmptyStringException;
import exceptions.InvalidUserException;
import java.util.Calendar;
import joinme.controlador.ControladorLogin;
import joinme.modelo.usuario.GestorUsuario;
import joinme.modelo.usuario.Usuario;
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
@Configuration(tests=10, size=10)
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
     * @param m Media
     * @param c Categoria
     * @param v Visibilidad
     * @throws exceptions.InvalidUserException
     * @throws exceptions.EmptyStringException
     */
    @Test(expected = EmptyStringException.class)
    public void testPublicarEntrada_5args(String m, String c, String v) throws InvalidUserException, EmptyStringException {
        System.out.println("publicarEntrada");
        gestorMuro.publicarEntrada(usuario, "", m, c, v);
    }
    /**
     * Test of publicarEntrada method, of class GestorMuro.
     * @param men Mensaje
     * @param m Media
     * @param v Visibilidad
     * @throws exceptions.InvalidUserException
     * @throws exceptions.EmptyStringException
     */
    @Test(expected = EmptyStringException.class)
    public void testPublicarEntrada_5args2(String men, String m, String v) throws InvalidUserException, EmptyStringException {
        System.out.println("publicarEntrada");
        gestorMuro.publicarEntrada(usuario, men, m, "", v);
    }
    
    /**
     * Test of publicarEntrada method, of class GestorMuro.
     * @param men Mensaje
     * @param m Media
     * @param c Categoria
     * @throws exceptions.InvalidUserException
     * @throws exceptions.EmptyStringException
     */
    @Test(expected = EmptyStringException.class)
    public void testPublicarEntrada_5args3(String men, String m, String c) throws InvalidUserException, EmptyStringException {
        System.out.println("publicarEntrada");
        gestorMuro.publicarEntrada(usuario, men, m, c, "");
    }
    
    /**
     * Test of GetEventos method, of class GestorMuro.
     * @param i dias a añadir
     * @param add añadir al mensaje
     * @throws exceptions.InvalidUserException
     */
    @Test
    public void testEventos(int i, String add) throws InvalidUserException{
        System.out.println("Eventos");
        Muro muro = gestorMuro.getMuro(usuario);
        assertTrue(muro.getEventos() != null);
        Evento e = muro.getEventos().get(0);
        Calendar d = e.getFecha();
        d.add(Calendar.DAY_OF_MONTH, i);
        e.setFecha(d);
        assertTrue(e.getFecha().equals(d));
        String m = e.getMensaje();
        m += m+add;
        e.setMensaje(m);
        assertTrue(e.getMensaje().equals(m));
    }
    
    /**
     * Test of GetEventos method, of class GestorMuro.
     * @param men Mensaje
     * @param c Categoria
     * @param m Media
     * @param v Visibilidad
     * @throws exceptions.InvalidUserException
     */
    @Test
    public void testEntrada(String men, String c, String m, String v) throws InvalidUserException{
        System.out.println("Entrada");
        Entrada e = new Entrada(men);
        e.setCategoria(c);
        e.setMedia(m);
        e.setVisibilidad(v);
        assertTrue(c.equals(e.getCategoria()));
        assertTrue(m.equals(e.getMedia()));
        assertTrue(v.equals(e.getVisibilidad()));
    }
    
    /*Debido a falta de tiempo no ha sido posible implementar este test generado con GraphWalker
    $ gw3 offline -m Login.graphml "random(edge_coverage(100))"*/
    @Test
    public void TestGraphWalker(){/*
    {"currentElementName":"e_init"}
{"currentElementName":"v_UserNotInSession"}
{"currentElementName":"e_login"}
{"currentElementName":"v_LoginUser"}
{"currentElementName":"e_incorrectUser"}
{"currentElementName":"v_LoginUser"}
{"currentElementName":"e_validUser"}
{"currentElementName":"v_ClientInSession"}
{"currentElementName":"e_publish"}
{"currentElementName":"v_PublishState"}
{"currentElementName":"e_incorrectPublishData"}
{"currentElementName":"v_PublishState"}
{}
{"currentElementName":"v_UserNotInSession"}
{"currentElementName":"e_login"}
{"currentElementName":"v_LoginUser"}
{"currentElementName":"e_incorrectUser"}
{"currentElementName":"v_LoginUser"}
{"currentElementName":"e_register"}
{"currentElementName":"v_RegisterUser"}
{"currentElementName":"e_incorrectData"}
{"currentElementName":"v_RegisterUser"}
{"currentElementName":"e_correctData"}
{"currentElementName":"v_ClientInSession"}
{"currentElementName":"e_publish"}
{"currentElementName":"v_PublishState"}
{"currentElementName":"e_incorrectPublishData"}
{"currentElementName":"v_PublishState"}
{"currentElementName":"e_incorrectPublishData"}
{"currentElementName":"v_PublishState"}
{"currentElementName":"e_incorrectPublishData"}
{"currentElementName":"v_PublishState"}
{"currentElementName":"e_incorrectPublishData"}
{"currentElementName":"v_PublishState"}
{}
{"currentElementName":"v_UserNotInSession"}
{"currentElementName":"e_login"}
{"currentElementName":"v_LoginUser"}
{"currentElementName":"e_incorrectUser"}
{"currentElementName":"v_LoginUser"}
{"currentElementName":"e_register"}
{"currentElementName":"v_RegisterUser"}
{"currentElementName":"e_correctData"}
{"currentElementName":"v_ClientInSession"}
{"currentElementName":"e_publish"}
{"currentElementName":"v_PublishState"}
{"currentElementName":"e_incorrectPublishData"}
{"currentElementName":"v_PublishState"}
{"currentElementName":"e_incorrectPublishData"}
{"currentElementName":"v_PublishState"}
{"currentElementName":"e_incorrectPublishData"}
{"currentElementName":"v_PublishState"}
{}
{"currentElementName":"v_UserNotInSession"}
{"currentElementName":"e_login"}
{"currentElementName":"v_LoginUser"}
{"currentElementName":"e_validUser"}
{"currentElementName":"v_ClientInSession"}
{"currentElementName":"e_publish"}
{"currentElementName":"v_PublishState"}
{"currentElementName":"e_correctPublishData"}
{"currentElementName":"v_PublishState"}

     */}
    
 
    
}
