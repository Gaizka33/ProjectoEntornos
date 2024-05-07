package Projecto;

class MensajeMultimedia extends Mensaje {
	private String nombreArchivo;
	private int tamaño;

	public MensajeMultimedia(Usuario remitente, Usuario destinatario, String nombreArchivo, int tamaño) {
		super(remitente, destinatario);
		this.nombreArchivo = nombreArchivo;
		this.tamaño = tamaño;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public int getTamaño() {
		return tamaño;
	}

	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}

	@Override
	public String getContenido() {
		return "Archivo: " + nombreArchivo + ", Tamaño: " + tamaño + "KB";
	}
}