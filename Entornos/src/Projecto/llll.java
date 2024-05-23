package Projecto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

/**
 * La clase llll contiene pruebas unitarias para la clase Usuario.
 */
public class llll {
    private Usuario usuarioNormal;
    private Usuario usuarioAdministrador;
    private Mensaje mensaje1;
    private Mensaje mensaje2;
    private Mensaje mensaje3;

    /**
     * Configura el entorno de pruebas antes de cada prueba.
     */
    @Before
    public void setUp() {
        usuarioNormal = new Usuario("123456789", "Usuario Normal", TipoUsuario.NORMAL);
        usuarioAdministrador = new Usuario("987654321", "Usuario Administrador", TipoUsuario.ADMINISTRADOR);
        mensaje1 = new Mensaje(usuarioNormal, usuarioAdministrador, "Mensaje de prueba 1");
        mensaje2 = new Mensaje(usuarioAdministrador, usuarioNormal, "Mensaje de prueba 2");
        mensaje3 = new Mensaje(usuarioNormal, usuarioAdministrador, "Mensaje de prueba 3");
    }

    /**
     * Prueba el método getNumeroTelefono.
     */
    @Test
    public void testGetNumeroTelefono() {
        assertEquals("123456789", usuarioNormal.getNumeroTelefono());
        assertEquals("987654321", usuarioAdministrador.getNumeroTelefono());
    }

    /**
     * Prueba el método getNombre.
     */
    @Test
    public void testGetNombre() {
        assertEquals("Usuario Normal", usuarioNormal.getNombre());
        assertEquals("Usuario Administrador", usuarioAdministrador.getNombre());
    }

    /**
     * Prueba el método getTipoUsuario.
     */
    @Test
    public void testGetTipoUsuario() {
        assertEquals(TipoUsuario.NORMAL, usuarioNormal.getTipoUsuario());
        assertEquals(TipoUsuario.ADMINISTRADOR, usuarioAdministrador.getTipoUsuario());
    }

    /**
     * Prueba el método recibirMensaje.
     */
    @Test
    public void testRecibirMensaje() {
        usuarioNormal.recibirMensaje(mensaje1);
        usuarioNormal.recibirMensaje(mensaje2);
        usuarioAdministrador.recibirMensaje(mensaje3);

        assertEquals(2, usuarioNormal.getMensajesRecibidos().size());
        assertEquals(1, usuarioAdministrador.getMensajesRecibidos().size());
    }

    /**
     * Prueba el método enviarMensaje.
     */
    @Test
    public void testEnviarMensaje() {
        usuarioNormal.enviarMensaje(usuarioAdministrador, mensaje1);
        usuarioAdministrador.enviarMensaje(usuarioNormal, mensaje2);

        assertEquals(1, usuarioNormal.getMensajesRecibidos().size());
        assertEquals(1, usuarioAdministrador.getMensajesRecibidos().size());
    }

    /**
     * Prueba el método getMensajesVisibles para un usuario normal.
     */
    @Test
    public void testGetMensajesVisiblesNormal() {
        usuarioNormal.recibirMensaje(mensaje1);
        usuarioNormal.recibirMensaje(mensaje2);
        usuarioAdministrador.recibirMensaje(mensaje3);

        assertEquals(2, usuarioNormal.getMensajesVisibles().size());
        assertTrue(usuarioNormal.getMensajesVisibles().contains(mensaje1));
        assertTrue(usuarioNormal.getMensajesVisibles().contains(mensaje2));
        assertFalse(usuarioNormal.getMensajesVisibles().contains(mensaje3));
    }

    /**
     * Prueba el método getMensajesVisibles para un usuario administrador.
     */
    @Test
    public void testGetMensajesVisiblesAdministrador() {
        usuarioNormal.recibirMensaje(mensaje1);
        usuarioNormal.recibirMensaje(mensaje2);
        usuarioAdministrador.recibirMensaje(mensaje3);

        assertEquals(3, usuarioAdministrador.getMensajesVisibles().size());
        assertTrue(usuarioAdministrador.getMensajesVisibles().contains(mensaje1));
        assertTrue(usuarioAdministrador.getMensajesVisibles().contains(mensaje2));
        assertTrue(usuarioAdministrador.getMensajesVisibles().contains(mensaje3));
    }
}
