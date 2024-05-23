package Projecto;

/**
 * La clase Mensaje representa un mensaje básico entre usuarios.
 */
class Mensaje {
    private Usuario remitente;
    private Usuario destinatario;
    private String contenido;

    /**
     * Constructor de la clase Mensaje.
     *
     * @param remitente    el usuario remitente del mensaje
     * @param destinatario el usuario destinatario del mensaje
     * @param contenido    el contenido del mensaje
     */
    public Mensaje(Usuario remitente, Usuario destinatario, String contenido) {
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.contenido = contenido;
    }

    /**
     * Obtiene el remitente del mensaje.
     *
     * @return el remitente del mensaje
     */
    public Usuario getRemitente() {
        return remitente;
    }

    /**
     * Obtiene el destinatario del mensaje.
     *
     * @return el destinatario del mensaje
     */
    public Usuario getDestinatario() {
        return destinatario;
    }

    /**
     * Obtiene el contenido del mensaje.
     *
     * @return el contenido del mensaje
     */
    public String getContenido() {
        return contenido;
    }
}
