package Projecto;

/**
 * La clase MensajeTexto representa un mensaje de texto.
 */
class MensajeTexto extends Mensaje {
    /**
     * Constructor de la clase MensajeTexto.
     *
     * @param remitente    el usuario remitente del mensaje
     * @param destinatario el usuario destinatario del mensaje
     * @param contenido    el contenido del mensaje de texto
     */
    public MensajeTexto(Usuario remitente, Usuario destinatario, String contenido) {
        super(remitente, destinatario, contenido);
    }
}
