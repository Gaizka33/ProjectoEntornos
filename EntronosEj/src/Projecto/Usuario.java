package Projecto;

import java.util.ArrayList;
import java.util.List;

class Usuario {
	private String numeroTelefono;
	private String nombre;
	private TipoUsuario tipoUsuario;
	private List<Mensaje> mensajesRecibidos;

	public Usuario(String numeroTelefono, String nombre, TipoUsuario tipoUsuario) {
		this.numeroTelefono = numeroTelefono;
		this.nombre = nombre;
		this.tipoUsuario = tipoUsuario;
		this.mensajesRecibidos = new ArrayList<>();
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public String getNombre() {
		return nombre;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void recibirMensaje(Mensaje mensaje) {
		mensajesRecibidos.add(mensaje);
	}

	public void enviarMensaje(Usuario destinatario, Mensaje mensaje) {
		destinatario.recibirMensaje(mensaje);
	}

	// Método para obtener los mensajes visibles para este usuario
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

	public List<Mensaje> getMensajesRecibidos() {
		return mensajesRecibidos;
	}

}