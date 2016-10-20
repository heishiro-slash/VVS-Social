/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joinme.modelo.muro;

import joinme.controlador.ControladorLogin;
import joinme.modelo.usuario.GestorUsuario;
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
    public void setUp() {
        controlador  = new ControladorLogin();
        controlador.creacionDatos ("Eduardo");
        gestorMuro = GestorMuro.getInstance();
        gestorUsuario = GestorUsuario.getInstance();
        usuario = gestorUsuario.getUsuario("Eduardo");
    }

    @After
    public void tearDown() {
    }


    /**
     * Test of getMuro method, of class GestorMuro.
     */
    @Test (expected = NonUserException.class)
        public void testGetMuro() {
        System.out.println("getMuro");
        Usuario usuario = null;
        Muro result = gestorMuro.getMuro(usuario);
    }

    /**
     * Test of publicarEntrada method, of class GestorMuro.
     */
    @Test  (expected = EmptyStringException.class)
        public void testPublicarEntrada_Usuario_String() {
        System.out.println("publicarEntrada");
        String mensaje = "";
        gestorMuro.publicarEntrada(usuario, mensaje);
    }

    /**
     * Test of publicarEntrada method, of class GestorMuro.
     */
    @Test  (expected = EmptyStringException.class)
        public void testPublicarEntrada_5args() {
        System.out.println("publicarEntrada");
        String mensaje = "";
        String media = "";
        String categoria = "";
        String visibilidad = "";
        gestorMuro.publicarEntrada(usuario, mensaje, media, categoria, visibilidad);
        
    }
    
}
