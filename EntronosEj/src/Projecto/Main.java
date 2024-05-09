package Projecto;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {

		List<Usuario> sda = new ArrayList<>();
		List<String> sdad = new ArrayList<>();

		Usuario usuario1 = new Usuario("123456789", "Usuario1", TipoUsuario.NORMAL);
		Usuario usuario2 = new Usuario("987654321", "Usuario2", TipoUsuario.ADMINISTRADOR);
		Usuario usuario3 = new Usuario("983464331", "Usuario3", TipoUsuario.NORMAL);

		MensajeTexto mensajeTexto1 = new MensajeTexto(usuario1, usuario2, "¡Hola, Usuario2!");
		usuario1.enviarMensaje(usuario2, mensajeTexto1);
		usuario1.enviarMensaje(usuario3, mensajeTexto1);

		MensajeMultimedia mensajeMultimedia1 = new MensajeMultimedia(usuario2, usuario1, "imagen.jpg", 1024);
		usuario2.enviarMensaje(usuario1, mensajeMultimedia1);

		MensajeMultimedia mensajeMultimedia2 = new MensajeMultimedia(usuario3, usuario1, "iman.jpg", 024);
		usuario3.enviarMensaje(usuario1, mensajeMultimedia2);

		System.out.println("Mensajes visibles para " + usuario1.getNombre() + ":");
		for (Mensaje mensaje : usuario1.getMensajesVisibles()) {
			System.out.println("De: " + mensaje.getRemitente().getNombre() + ", Contenido: " + mensaje.getContenido());
		}

		System.out.println("\nMensajes visibles para " + usuario2.getNombre() + ":");
		sda.add(usuario3);
		sda.add(usuario2);
		sda.add(usuario1);
		sdad.add("De: " + mensajeMultimedia2.getRemitente().getNombre() + ", Contenido: "
				+ mensajeMultimedia2.getContenido());
		sdad.add("De: " + mensajeMultimedia1.getRemitente().getNombre() + ", Contenido: "
				+ mensajeMultimedia1.getContenido());
		sdad.add("De: " + mensajeTexto1.getRemitente().getNombre() + ", Contenido: " + mensajeTexto1.getContenido());

		for (Usuario usuario : sda) {
			if (usuario.getTipoUsuario() == TipoUsuario.ADMINISTRADOR) {
				System.out.println(sdad);

			}

		}

		System.out.println("\nMensajes visibles para " + usuario3.getNombre() + ":");
		for (Mensaje mensaje : usuario3.getMensajesVisibles()) {
			System.out.println("De: " + mensaje.getRemitente().getNombre() + ", Contenido: " + mensaje.getContenido());
		}

	}
}