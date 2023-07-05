import java.util.Locale;

public class Capacitacion {
    private int identificador;
    private int rutCliente;
    private String dia;
    private String hora;
    private String lugar;
    private String duracion;
    private int cantidadAsistentes;

    public Capacitacion(){
    }
    public Capacitacion(int identificador, int rutCliente, String dia, String hora, String lugar, String duracion, int cantidadAsistentes) throws IllegalArgumentException {
        setIdentificador(identificador);
        setRutCliente(rutCliente);
        setDia(dia);
        setHora(hora);
        setLugar(lugar);
        setDuracion(duracion);
        setCantidadAsistentes(cantidadAsistentes);
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        if (identificador <= 0) {
            throw new IllegalArgumentException("El identificador debe ser mayor que 0");
        }
        this.identificador = identificador;
    }

    public int getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(int rutCliente) {
        if (rutCliente <= 0 || rutCliente >= 100000000) {
            throw new IllegalArgumentException("El RUT debe ser un número entre 1 y 99.999.999");
        }
        this.rutCliente = rutCliente;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        dia = dia.toLowerCase();
        if (!dia.equals("lunes") && !dia.equals("martes") && !dia.equals("miercoles") && !dia.equals("jueves") && !dia.equals("viernes") && !dia.equals("sábado") && !dia.equals("domingo")) {
            throw new IllegalArgumentException("El día debe ser un valor permitido entre \"lunes\" y \"domingo\"");
        }
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        if (!hora.matches("^([01]\\d|2[0-3]):([0-5]\\d)$")) {
            throw new IllegalArgumentException("La hora debe estar en formato HH:MM y ser una hora válida del día");
        }
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        if (lugar == null || lugar.isEmpty() || lugar.length() < 10 || lugar.length() > 50) {
            throw new IllegalArgumentException("El lugar es obligatorio y debe tener entre 10 y 50 caracteres");
        }
        this.lugar = lugar;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        if (duracion != null && duracion.length() > 70) {
            throw new IllegalArgumentException("La duración no puede tener más de 70 caracteres");
        }
        this.duracion = duracion;
    }

    public int getCantidadAsistentes() {
        return cantidadAsistentes;
    }

    public void setCantidadAsistentes(int cantidadAsistentes) {
        if (cantidadAsistentes <= 0 || cantidadAsistentes >= 1000) {
            throw new IllegalArgumentException("La cantidad de asistentes debe ser un número entero mayor que 0 y menor que 1000");
        }
        this.cantidadAsistentes = cantidadAsistentes;
    }
}