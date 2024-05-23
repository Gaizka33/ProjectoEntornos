package Projecto;

/**
 * La clase MensajeMultimedia representa un mensaje multimedia.
 */
class MensajeMultimedia extends Mensaje {
    private String archivo;
    private int tamano;

    /**
     * Constructor de la clase MensajeMultimedia.
     *
     * @param remitente   el usuario remitente del mensaje
     * @param destinatario el usuario destinatario del mensaje
     * @param archivo     el nombre del archivo multimedia
     * @param tamano      el tamaño del archivo multimedia
     */
    public MensajeMultimedia(Usuario remitente, Usuario destinatario, String archivo, int tamano) {
        super(remitente, destinatario, "Archivo multimedia: " + archivo);
        this.archivo = archivo;
        this.tamano = tamano;
    }

    /**
     * Obtiene el nombre del archivo multimedia.
     *
     * @return el nombre del archivo multimedia
     */
    public String getArchivo() {
        return archivo;
    }

    /**
     * Obtiene el tamaño del archivo multimedia.
     *
     * @return el tamaño del archivo multimedia
     */
    public int getTamano() {
        return tamano;
    }
}
