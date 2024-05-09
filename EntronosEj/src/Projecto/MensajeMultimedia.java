package Projecto;

class MensajeMultimedia extends Mensaje {
    private String archivo;
    private int tamaño;

    public MensajeMultimedia(Usuario remitente, Usuario destinatario, String archivo, int tamaño) {
        super(remitente, destinatario, "Archivo multimedia: " + archivo);
        this.archivo = archivo;
        this.tamaño = tamaño;
    }

    public String getArchivo() {
        return archivo;
    }

    public int getTamaño() {
        return tamaño;
    }

	
}