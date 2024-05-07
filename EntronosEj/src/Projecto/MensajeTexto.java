package Projecto;

class MensajeTexto extends Mensaje {
    private String texto;

    public MensajeTexto(Usuario remitente, Usuario destinatario, String texto) {
        super(remitente, destinatario);
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    @Override
    public String getContenido() {
        return texto;
    }
}