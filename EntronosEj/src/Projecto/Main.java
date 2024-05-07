package Projecto;

public class Main {
	public static void main(String[] args) {
        Usuario usuario1 = new Usuario("123456789", "Usuario1", TipoUsuario.NORMAL);
        Usuario usuario2 = new Usuario("987654321", "Usuario2", TipoUsuario.ADMINISTRADOR);
        MensajeTexto mensajeTexto = new MensajeTexto(usuario1, usuario2, "Hola, ¿cómo estás?");
        MensajeMultimedia mensajeMultimedia = new MensajeMultimedia(usuario2, usuario1, "imagen.jpg", 1024);

        usuario2.recibirMensaje(mensajeTexto);
        usuario1.recibirMensaje(mensajeMultimedia);

        System.out.println("Mensajes visibles para " + usuario1.getNombre() + ":");
        for (Mensaje mensaje : usuario1.getMensajesVisibles()) {
            System.out.println("De: " + mensaje.getRemitente().getNombre() + ", Contenido: " + mensaje.getContenido());
        }

        System.out.println("\nMensajes visibles para " + usuario2.getNombre() + ":");
        for (Mensaje mensaje : usuario2.getMensajesVisibles()) {
            System.out.println("De: " + mensaje.getRemitente().getNombre() + ", Contenido: " + mensaje.getContenido());
        }
    }
}
   