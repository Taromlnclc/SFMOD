import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Usuario implements IAsesoria{
    private String nombre;
    private String fechaNacimiento;
    private int rut;

    public Usuario() {
    }
    public Usuario(String nombre, String fechaNacimiento, int rut) {
        setNombre(nombre);
        setFechaNacimiento(fechaNacimiento);
        setRut(rut);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.length() < 10 || nombre.length() > 50) {
            throw new IllegalArgumentException("El nombre debe tener entre 10 y 50 caracteres");
        }
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return getFechaNacimientoFormateada();
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        if (fechaNacimiento == null) {
            throw new IllegalArgumentException("La fecha de nacimiento es obligatoria");
        }
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        if (rut <= 0 || rut >= 100000000) {
            throw new IllegalArgumentException("El RUN debe ser un número entre 1 y 99.999.999");
        }
        this.rut = rut;
    }

    public String getFechaNacimientoFormateada() {
        SimpleDateFormat fechaFormato = new SimpleDateFormat("dd/MM/yyyy");
        return fechaFormato.format(fechaNacimiento);
    }

    public void mostrarEdad() {
        Calendar fechaActual = Calendar.getInstance();
        int anioActual = fechaActual.get(Calendar.YEAR);
        int anioNacimiento = Integer.parseInt(fechaNacimiento.substring(6));
        int edad = anioActual - anioNacimiento;
        System.out.println("Año nac. " + anioNacimiento + " a hoy tiene " + edad + " años.");
    }


    @Override
    public void analizarUsuario() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Rut: " + rut);
    }



    @Override
    public String toString() {
        return "Usuario" + "\n" +
                "Nombre: " + nombre + "\n" +
                "Fecha de Nacimiento: " + fechaNacimiento + "\n" +
                "Rut: " + rut;
    }
}