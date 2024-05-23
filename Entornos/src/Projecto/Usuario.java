package Projecto;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase Usuario representa un usuario del sistema de mensajería.
 */
class Usuario {
    private String numeroTelefono;
    private String nombre;
    private TipoUsuario tipoUsuario;
    private List<Mensaje> mensajesRecibidos;

    /**
     * Constructor de la clase Usuario.
     *
     * @param numeroTelefono el número de teléfono del usuario
     * @param nombre         el nombre del usuario
     * @param tipoUsuario    el tipo de usuario (NORMAL o ADMINISTRADOR)
     */
    public Usuario(String numeroTelefono, String nombre, TipoUsuario tipoUsuario) {
        this.numeroTelefono = numeroTelefono;
        this.nombre = nombre;
        this.tipoUsuario = tipoUsuario;
        this.mensajesRecibidos = new ArrayList<>();
    }

    /**
     * Obtiene el número de teléfono del usuario.
     *
     * @return el número de teléfono del usuario
     */
    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return el nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el tipo de usuario.
     *
     * @return el tipo de usuario
     */
    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * Recibe un mensaje y lo agrega a la lista de mensajes recibidos.
     *
     * @param mensaje el mensaje a recibir
     */
    public void recibirMensaje(Mensaje mensaje) {
        mensajesRecibidos.add(mensaje);
    }

    /**
     * Envía un mensaje a otro usuario.
     *
     * @param destinatario el usuario destinatario del mensaje
     * @param mensaje      el mensaje a enviar
     */
    public void enviarMensaje(Usuario destinatario, Mensaje mensaje) {
        destinatario.recibirMensaje(mensaje);
    }

    /**
     * Obtiene los mensajes visibles para este usuario.
     *
     * @return la lista de mensajes visibles
     */
    public List<Mensaje> getMensajesVisibles() {
        List<Mensaje> mensajesVisibles = new ArrayList<>();
        for (Mensaje mensaje : mensajesRecibidos) {
            if (tipoUsuario == TipoUsuario.NORMAL || mensaje.getDestinatario() == this) {
                mensajesVisibles.add(mensaje);
            }
            if (tipoUsuario == TipoUsuario.ADMINISTRADOR) {
                return mensajesRecibidos;
            }
        }
        return mensajesVisibles;
    }

    /**
     * Obtiene la lista de mensajes recibidos por este usuario.
     *
     * @return la lista de mensajes recibidos
     */
    public List<Mensaje> getMensajesRecibidos() {
        return mensajesRecibidos;
    }
}
