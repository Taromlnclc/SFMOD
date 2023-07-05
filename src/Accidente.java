
public class Accidente {
    private int identificador;
    private int rutCliente;
    private String fecha;
    private String hora;
    private String lugar;
    private String origen;
    private String consecuencias;

    public Accidente(){};
    public Accidente(int identificador, int rutCliente, String fecha, String hora, String lugar, String origen, String consecuencias) {
        setIdentificador(identificador);
        setRutCliente(rutCliente);
        setFecha(fecha);
        setHora(hora);
        setLugar(lugar);
        setOrigen(origen);
        setConsecuencias(consecuencias);
    }
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        if (identificador <=1 || identificador >= 1000000000) {
            throw new IllegalArgumentException("El identificador es obligatorio");
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha es obligatoria");
        }
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        if (hora == null) {
            throw new IllegalArgumentException("La hora es obligatoria");
        }
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        if (lugar == null || lugar.trim().isEmpty()) {
            throw new IllegalArgumentException("El lugar es obligatorio");
        }
        if (lugar.length() < 10 || lugar.length() > 50) {
            throw new IllegalArgumentException("El lugar debe tener entre 10 y 50 caracteres");
        }
        this.lugar = lugar;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        if (origen != null && origen.length() > 100) {
            throw new IllegalArgumentException("El origen no puede tener más de 100 caracteres");
        }
        this.origen = origen;
    }

    public String getConsecuencias() {
        return consecuencias;
    }

    public void setConsecuencias(String consecuencias) {
        if (consecuencias != null && consecuencias.length() > 100) {
            throw new IllegalArgumentException("Las consecuencias no pueden tener más de 100 caracteres");
        }
        this.consecuencias = consecuencias;
    }



    // Método para obtener la fecha en formato DD/MM/AAAA
   /* public String getFechaFormateada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fecha.format(formatter);
    }

    // Método para obtener la hora en formato HH:MM
    public String getHoraFormateada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return hora.format(formatter);
    }*/


}
