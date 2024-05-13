package Projecto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InterfazUsuario extends JFrame {
    private JTextArea areaMensajes;
    private JTextField campoMensaje;
    private JButton botonEnviar;

    public InterfazUsuario(Usuario usuario) {
        setTitle("Interfaz de Usuario - " + usuario.getNombre());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        areaMensajes = new JTextArea();
        areaMensajes.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(areaMensajes);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        campoMensaje = new JTextField();
        botonEnviar = new JButton("Enviar");
        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String contenidoMensaje = campoMensaje.getText();
                if (!contenidoMensaje.isEmpty()) {
                    MensajeTexto nuevoMensaje = new MensajeTexto(usuario, null, contenidoMensaje);
                    usuario.enviarMensaje(usuario, nuevoMensaje);
                    mostrarMensajes(usuario.getMensajesVisibles());
                    campoMensaje.setText("");
                }
            }
        });

        JPanel panelEnviar = new JPanel(new BorderLayout());
        panelEnviar.add(campoMensaje, BorderLayout.CENTER);
        panelEnviar.add(botonEnviar, BorderLayout.EAST);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(panelEnviar, BorderLayout.SOUTH);
    }

    public void mostrarMensajes(List<Mensaje> mensajes) {
        areaMensajes.setText(""); // Limpiar el área de mensajes antes de mostrar nuevos mensajes
        for (Mensaje mensaje : mensajes) {
            areaMensajes.append("De: " + mensaje.getRemitente().getNombre() + ", Contenido: " + mensaje.getContenido() + "\n");
        }
    }


    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("123456789", "Usuario1", TipoUsuario.NORMAL);
        Usuario usuario2 = new Usuario("987654321", "Usuario2", TipoUsuario.ADMINISTRADOR);

        MensajeTexto mensaje1 = new MensajeTexto(usuario1, usuario2, "¡Hola, Usuario2!");
        MensajeTexto mensaje2 = new MensajeTexto(usuario2, usuario1, "¡Hola, Usuario1!");

        usuario1.recibirMensaje(mensaje2);
        usuario2.recibirMensaje(mensaje1);

        InterfazUsuario interfazUsuario1 = new InterfazUsuario(usuario1);
        interfazUsuario1.setVisible(true);

        InterfazUsuario interfazUsuario2 = new InterfazUsuario(usuario2);
        interfazUsuario2.setVisible(true);

        // Mostrar mensajes recibidos para cada usuario
        interfazUsuario1.mostrarMensajes(usuario1.getMensajesVisibles());
        interfazUsuario2.mostrarMensajes(usuario2.getMensajesVisibles());
    }
}

