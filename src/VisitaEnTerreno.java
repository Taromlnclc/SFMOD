import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
public class VisitaEnTerreno {
    private int idVisita;
    private int rutCliente;
    private String fecha;
    private String hora;
    private String lugar;
    private String comentarios;
    private ArrayList<Revision> revisiones;

    public VisitaEnTerreno(int idVisita, int rutCliente, String fecha, String hora, String lugar, String comentarios, ArrayList<Revision> revisiones) {
        this.idVisita = idVisita;
        this.rutCliente = rutCliente;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.comentarios = comentarios;
        this.revisiones = revisiones;
    }

    // Getters y setters
    public int getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }

    public int getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(int rutCliente) {
        validarRutCliente(rutCliente);
        this.rutCliente = rutCliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        validarLugar(lugar);
        this.lugar = lugar;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        validarComentarios(comentarios);
        this.comentarios = comentarios;
    }

    /*
    // Método para obtener la fecha en formato DD/MM/AAAA
    public String getFechaFormateada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fecha.format(formatter);
    }

    // Método para obtener la hora en formato HH:MM
    public String getHoraFormateada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return hora.format(formatter);
    }
*/
    // Método para validar el RUT del cliente
    private void validarRutCliente(int rut) throws IllegalArgumentException {
        if (rut <= 0 || rut >= 100000000) {
            throw new IllegalArgumentException("El RUT debe ser un número entre 1 y 99.999.999");
        }
    }

    // Método para validar el lugar de la visita
    private void validarLugar(String lugar) throws IllegalArgumentException {
        if (lugar == null || lugar.isEmpty()) {
            throw new IllegalArgumentException("El lugar de la visita es obligatorio.");
        }
        if (lugar.length() < 10 || lugar.length() > 50) {
            throw new IllegalArgumentException("El lugar de la visita debe tener entre 10 y 50 caracteres.");
        }
    }

    // Método para validar los comentarios
    private void validarComentarios(String comentarios) throws IllegalArgumentException {
        if (comentarios != null && comentarios.length() > 100) {
            throw new IllegalArgumentException("Los comentarios no pueden tener más de 100 caracteres.");
        }
    }
}
