package Projecto;

import static org.junit.Assert.*;
import org.junit.*;

public class UsuarioTest {

    private Usuario usuario;
    private MensajeTexto mensajeTexto;

    @Before
    public void setUp() {
        usuario = new Usuario("123456789", "Usuario1", TipoUsuario.NORMAL);
        mensajeTexto = new MensajeTexto(usuario, usuario, "Hola, ¿cómo estás?");
    }

    @Test
    public void testRecibirMensaje() {
        usuario.recibirMensaje(mensajeTexto);
        assertEquals(1, usuario.getMensajesVisibles().size());
        assertEquals(mensajeTexto, usuario.getMensajesVisibles().get(0));
    }
}
