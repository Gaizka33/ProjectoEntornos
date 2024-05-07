package Projecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class culicagao extends JFrame implements ActionListener {
    private JTextField campoTexto;
    private JButton botonEnviar;
    private JComboBox<String> listaContactos;
    private JTextArea areaMensajes;
    private Usuario usuario;
    private List<Usuario> contactos;

    public culicagao(Usuario usuario, List<Usuario> contactos) {
        this.usuario = usuario;
        this.contactos = contactos;

        setTitle("Enviar y Ver Mensajes - " + usuario.getNombre());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());

        JPanel panelEnviar = new JPanel();
        panelEnviar.setLayout(new GridLayout(3, 1));

        campoTexto = new JTextField();
        botonEnviar = new JButton("Enviar");
        botonEnviar.addActionListener(this);

        listaContactos = new JComboBox<>();
        for (Usuario contacto : contactos) {
            listaContactos.addItem(contacto.getNombre());
        }

        panelEnviar.add(listaContactos);
        panelEnviar.add(campoTexto);
        panelEnviar.add(botonEnviar);

        areaMensajes = new JTextArea();
        areaMensajes.setEditable(false);

        panelPrincipal.add(panelEnviar, BorderLayout.NORTH);
        panelPrincipal.add(new JScrollPane(areaMensajes), BorderLayout.CENTER);

        JButton botonReiniciar = new JButton("Reiniciar");
        botonReiniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reiniciarPrograma();
            }
        });
        panelPrincipal.add(botonReiniciar, BorderLayout.SOUTH);

        add(panelPrincipal);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String mensaje = campoTexto.getText();
        int indiceSeleccionado = listaContactos.getSelectedIndex();
        Usuario destinatario = contactos.get(indiceSeleccionado);
        MensajeTexto mensajeTexto = new MensajeTexto(usuario, destinatario, mensaje);
        destinatario.recibirMensaje(mensajeTexto);
        usuario.recibirMensaje(mensajeTexto); // El usuario también recibe una copia del mensaje
        mostrarMensajes();
        JOptionPane.showMessageDialog(this, "Mensaje enviado correctamente.");
    }

    private void mostrarMensajes() {
        areaMensajes.setText("Mensajes de " + usuario.getNombre() + ":\n");

        // Mostrar mensajes recibidos y enviados por el usuario actual
        for (Mensaje mensaje : usuario.getMensajesVisibles()) {
            areaMensajes.append("De: " + mensaje.getRemitente().getNombre() + ", Para: " + mensaje.getDestinatario().getNombre() + ", Contenido: " + mensaje.getContenido() + "\n");
        }
    }

    private void reiniciarPrograma() {
        dispose(); // Cerrar la ventana actual
        SwingUtilities.invokeLater(() -> { // Crear una nueva ventana en el hilo de despacho de eventos
            List<Usuario> contactos = new ArrayList<>();
            Usuario usuario1 = new Usuario("123456789", "Usuario1", TipoUsuario.NORMAL);
            Usuario usuario2 = new Usuario("987654321", "Usuario2", TipoUsuario.ADMINISTRADOR);
            contactos.add(usuario1);
            contactos.add(usuario2);
            new culicagao(usuario, contactos);
        });
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        List<Usuario> contactos = new ArrayList<>();
        Usuario usuario1 = new Usuario("123456789", "Usuario1", TipoUsuario.NORMAL);
        Usuario usuario2 = new Usuario("987654321", "Usuario2", TipoUsuario.ADMINISTRADOR);
        contactos.add(usuario1);
        contactos.add(usuario2);
        new culicagao(usuario1, contactos);
    }
}
