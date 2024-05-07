package Projecto;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String numeroTelefono;
	private String nombre;
	private TipoUsuario tipoUsuario;
	private List<Mensaje> mensajesRecibidos;

	public Usuario(String numeroTelefono, TipoUsuario tipoUsuario) {
		this.numeroTelefono = numeroTelefono;
		this.tipoUsuario = tipoUsuario;
		this.mensajesRecibidos = new ArrayList<>();
	}

	public Usuario(String numeroTelefono, String nombre, TipoUsuario tipoUsuario) {
		this.numeroTelefono = numeroTelefono;
		this.nombre = nombre;
		this.tipoUsuario = tipoUsuario;
		this.mensajesRecibidos = new ArrayList<>();
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public void recibirMensaje(Mensaje mensaje) {
		mensajesRecibidos.add(mensaje);
	}

	public List<Mensaje> getMensajesVisibles() {
		List<Mensaje> mensajesVisibles = new ArrayList<>();
		for (Mensaje mensaje : mensajesRecibidos) {
			if (tipoUsuario == TipoUsuario.ADMINISTRADOR || mensaje.getDestinatario() == this) {
				mensajesVisibles.add(mensaje);
			}
		}
		return mensajesVisibles;
	}
}