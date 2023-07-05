import java.util.ArrayList;
public class Cliente extends Usuario {
    private String apellidos;
    private String telefono;
    private String afp;
    private int sistemaSalud;
    private String direccion;
    private String comuna;
    private int edad;
    private ArrayList<Capacitacion> capacitaciones;
    private ArrayList<Accidente> accidentes;
    private ArrayList<VisitaEnTerreno> visitasEnTerreno;


    public Cliente(String nombre, String fechaNacimiento, int rut) {
        super(nombre, fechaNacimiento, rut);
    }

    public Cliente(String nombre, String fechaNacimiento, int rut, String apellidos, String telefono, String afp, int sistemaSalud, String direccion, String comuna, int edad) {
        super(nombre, fechaNacimiento, rut);
        setApellidos(apellidos);
        setTelefono(telefono);
        setAfp(afp);
        setSistemaSalud(sistemaSalud);
        setDireccion(direccion);
        setComuna(comuna);
        setEdad(edad);
    }

    // Métodos para agregar y obtener capacitaciones
    public void agregarCapacitacion(Capacitacion capacitacion) {
        this.capacitaciones.add(capacitacion);
    }

    public ArrayList<Capacitacion> obtenerCapacitaciones() {
        return this.capacitaciones;
    }

    // Métodos para agregar y obtener accidentes
    public void agregarAccidente(Accidente accidente) {
        this.accidentes.add(accidente);
    }

    public ArrayList<Accidente> obtenerAccidentes() {
        return this.accidentes;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        if (apellidos.length() >= 5 && apellidos.length() <= 30) {
            this.apellidos = apellidos;
        } else {
            System.out.println("Apellidos inválidos.");
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (!telefono.isEmpty()) {
            this.telefono = telefono;
        } else {
            System.out.println("Teléfono inválido.");
        }
    }

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        this.afp = afp;
    }

    public int getSistemaSalud() {
        return sistemaSalud;
    }

    public void setSistemaSalud(int sistemaSalud) {
        if (sistemaSalud == 1 || sistemaSalud == 2) {
            this.sistemaSalud = sistemaSalud;
        } else {
            System.out.println("Sistema de salud inválido.");
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion.length() <= 70) {
            this.direccion = direccion;
        } else {
            System.out.println("Dirección inválida.");
        }
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        if (comuna.length() <= 50) {
            this.comuna = comuna;
        } else {
            System.out.println("Comuna inválida.");
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad < 0 || edad >= 150) {
            throw new IllegalArgumentException("Edad debe ser mayor o igual a cero, y menor a 150");
        } else {
            this.edad = edad;
        }
    }
    public String obtenerNombre() {
        return getNombre() + " " + getApellidos();
    }

    public String obtenerSistemaSalud() {
        switch (getSistemaSalud()) {
            case 1:
                return "Salud Fonasa";
            case 2:
                return "Salud Isapre";
            default:
                return "Sistema de salud desconocido";
        }
    }

    public void analizarUsuario() {
        System.out.println("Nombre completo: " + obtenerNombre());
        System.out.println("Sistema de salud: " + obtenerSistemaSalud());
    }
}
