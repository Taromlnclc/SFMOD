import java.text.SimpleDateFormat;
import java.util.Date;

public class Profesional extends Usuario {
    private String titulo;
    private Date fechaIngreso;

    public Profesional(String nombre, String fechaNacimiento, int rut, String titulo, Date fechaIngreso) {
        super(nombre, fechaNacimiento, rut);
       setTitulo(titulo);
       setFechaIngreso(fechaIngreso);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().length() < 10 || titulo.trim().length() > 50) {
            throw new IllegalArgumentException("Titulo debe tener al menos 10 caracteres y máximo 50 caracteres");
        }
        this.titulo = titulo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        if (fechaIngreso == null) {
            throw new IllegalArgumentException("La fecha de ingreso es obligatoria");
        }
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaIngresoFormateada() {
        SimpleDateFormat fechaFormato = new SimpleDateFormat("dd/MM/yyyy");
        return fechaFormato.format(fechaIngreso);
    }
}
