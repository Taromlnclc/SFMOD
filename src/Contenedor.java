import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Contenedor {
    private ArrayList<IAsesoria> asesorias;
    private ArrayList<Capacitacion> capacitaciones;
    Scanner entrada = new Scanner(System.in);
    public Contenedor() {
        asesorias = new ArrayList<>();
        capacitaciones = new ArrayList<>();
    }

    public void almacenarCliente(String nombre, String fechaNacimiento, int rut) {
        // Creamos un cliente
        System.out.println("Apellidos del cliente:");
        String apellidos = entrada.nextLine();
        System.out.println("Telefono cliente:");
        String telefono = entrada.nextLine();
        System.out.println("AFP cliente:");
        String afp = entrada.nextLine();
        System.out.println("Sistema de salud cliente:");
        int sistemaSalud = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Direccion cliente:");
        String direccion = entrada.nextLine();
        System.out.println("Comuna cliente:");
        String comuna = entrada.nextLine();
        System.out.println("Edad cliente:");
        int edad = entrada.nextInt();
        entrada.nextLine();

        Cliente cliente = new Cliente(nombre, fechaNacimiento, rut, apellidos,telefono, afp, sistemaSalud, direccion, comuna, edad);
        asesorias.add(cliente);
    }

    public void almacenarProfesional(String nombre, String fechaNacimiento, int rut) {
        System.out.println("Titulo:");
        String titulo = entrada.nextLine();
        System.out.println("Fecha de ingreso en formato dd/MM/yyyy:");
        String fechaString = entrada.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaIngreso = null;
        try {
            fechaIngreso = dateFormat.parse(fechaString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Profesional profesional = new Profesional(nombre, fechaNacimiento, rut, titulo, fechaIngreso);
        asesorias.add(profesional);
    }

    public void almacenarAdministrativo(String nombre, String fechaNacimiento, int rut) {
        System.out.println("Area de trabajo:");
        String area = entrada.nextLine();
        System.out.println("Experiencia previa:");
        String experienciaPrevia = entrada.nextLine();
        Administrativo administrativo = new Administrativo(nombre, fechaNacimiento, rut, area, experienciaPrevia);
        asesorias.add(administrativo);
    }

    public void almacenarCapacitacion() {
        //Capacitacion del cliente
        System.out.println("Capacitacion del cliente:");
        System.out.println("RUT:");
        int rutCliente = entrada.nextInt();
        entrada.nextLine();
        System.out.println("ID capacitacion:");
        int identificador = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Dia capacitacion(lunes-domingo):");
        String diaCapacitacion = entrada.nextLine();
        System.out.println("Hora capacitacion(HH:mm):");
        String hora = entrada.nextLine();
        System.out.println("Lugar capacitacion:");
        String lugar = entrada.nextLine();
        System.out.println("Duracion capacitacion:");
        String duracion = entrada.nextLine();
        System.out.println("Cantidad de asistentes cliente:");
        int cantidadAsistentes = entrada.nextInt();
        entrada.nextLine();

        Capacitacion capacitacion = new Capacitacion(identificador, rutCliente, diaCapacitacion, hora, lugar, duracion, cantidadAsistentes);
        capacitaciones.add(capacitacion);
    }


    public void eliminarUsuario(int rut) {
       for (IAsesoria asesoria : asesorias) {
            if (asesoria instanceof Usuario) {
                Usuario usuario = (Usuario) asesoria;
                if (rut == usuario.getRut()) {
                    System.out.println("Usuario eliminado: " + usuario.getRut() );
                    asesorias.remove(usuario);
                    break;
                }
            }
        }
    }

    public void listarUsuarios() {
            System.out.println("Usuarios registrados:");
            for (IAsesoria asesoria : asesorias) {
                if (asesoria instanceof Cliente) {
                    Cliente cliente = (Cliente) asesoria;
                    System.out.println("Cliente: " + cliente.obtenerNombre());
                } else if (asesoria instanceof Profesional) {
                    Profesional profesional = (Profesional) asesoria;
                    System.out.println("Profesional: " + profesional.getNombre() + " (Título: " + profesional.getTitulo() + ")");
                } else if (asesoria instanceof Administrativo) {
                    Administrativo administrativo = (Administrativo) asesoria;
                    System.out.println("Administrativo: " + administrativo.getNombre() + " (Área: " + administrativo.getArea() + ")");
                }
            }
        }



    public void listarUsuariosPorTipo() {
        System.out.println("Listar usuarios por tipo.");
        System.out.printf("Tipo de Usuario(Cliente, Profesional, Administrativo): ");
        String tipoUser = entrada.nextLine();
        System.out.println("Usuarios registrados por " + tipoUser + " :");
        try {
            for (IAsesoria asesoria : asesorias) {
                if(tipoUser.toLowerCase().equals("cliente")){
                    if (asesoria instanceof Cliente) {
                        Cliente cliente = (Cliente) asesoria;
                        System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellidos());
                    }
                }
                if(tipoUser.toLowerCase().equals("profesional")){
                    if (asesoria instanceof Profesional) {
                        Profesional profesional = (Profesional) asesoria;
                        System.out.println("Profesional: " + profesional.getNombre() + " (Título: " + profesional.getTitulo() + ")");
                    }
                }
                if(tipoUser.toLowerCase().equals("administrativo")){
                    if (asesoria instanceof Administrativo) {
                        Administrativo administrativo = (Administrativo) asesoria;
                        System.out.println("Administrativo: " + administrativo.getNombre() + " (Área: " + administrativo.getArea() + ")");
                    }
                }
            }
        } catch(Exception e){
            System.out.println("Error: " + e);
        }

    }

    public void listarCapacitaciones() {
        for (Capacitacion capacitacion : capacitaciones) {
            System.out.println(capacitacion + " - " + capacitacion.getRutCliente());
        }
    }
    public void edadUsuario(int rut) {
        for (IAsesoria asesoria : asesorias) {
            if (asesoria instanceof Usuario) {
                Usuario usuario = (Usuario) asesoria;
                if (rut == usuario.getRut()) {
                    System.out.println("Edad del Usuario:");
                    usuario.mostrarEdad();
                }
            }
        }
    }

    public void existeUsuario(int rut) {
        for (IAsesoria asesoria : asesorias) {
            if (asesoria instanceof Usuario) {
                Usuario usuario = (Usuario) asesoria;
                if (rut == usuario.getRut()) {
                    System.out.println("EXISTE");
                    usuario.analizarUsuario();
                }
            }
        }
    }

}
