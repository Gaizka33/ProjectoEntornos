package Projecto;

abstract class Mensaje {
    private Usuario remitente;
    private Usuario destinatario;

    public Mensaje(Usuario remitente, Usuario destinatario) {
        this.remitente = remitente;
        this.destinatario = destinatario;
    }

    public Usuario getRemitente() {
        return remitente;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public abstract String getContenido();
}