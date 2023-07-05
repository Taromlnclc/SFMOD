import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static int eleccion;
    private static Scanner entrada = new Scanner(System.in);

   private static String nombres = null;
   private static String usuarioTipo = null;
   private static int rut = 0;
   private static String fechaNacimiento = null;

    public static void main(String[] args) {
        String siOno;
        float total=0;
        // Crear fecha actual
        Calendar calendario = Calendar.getInstance();
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH) + 1; // los meses empiezan en 0 (enero)
        int anio = calendario.get(Calendar.YEAR);

        Contenedor contenedor = new Contenedor(); // Crear instancia de la clase Contenedor

        System.out.println("*********************************************************************");
        System.out.println("Bienvenido a SPRINT FINAL.");
        System.out.println("*********************************************************************");
        do {
                // Mostrar las opciones del menú
                System.out.println("\nMENÚ PRINCIPAL");
                System.out.println("1. Almacenar cliente");
                System.out.println("2. Almacenar profesional");
                System.out.println("3. Almacenar administrativo");
                System.out.println("4. Almacenar capacitación");
                System.out.println("5. Eliminar usuario");
                System.out.println("6. Listar usuarios");
                System.out.println("7. Listar usuarios por tipo");
                System.out.println("8. Listar capacitaciones");
                System.out.println("9. Salir");
                System.out.println("-------------------------------------");
                System.out.println("10. Mostrar edad");
                System.out.println("11. Existe usuario");
                System.out.print("\nSeleccione una opción: ");
                eleccion = entrada.nextInt();
                ingUsuario(eleccion);
                switch (eleccion) {
                    case 1:
                        // Llamar al método para almacenar un nuevo cliente
                        contenedor.almacenarCliente(nombres, fechaNacimiento, rut);
                        break;
                    case 2:

                        // Llamar al método para almacenar un nuevo profesional
                        contenedor.almacenarProfesional(nombres, fechaNacimiento, rut);
                        break;
                    case 3:
                        // Llamar al método para almacenar un nuevo administrativo
                        contenedor.almacenarAdministrativo(nombres, fechaNacimiento, rut);
                        break;
                    case 4:
                        // Llamar al método para almacenar una nueva capacitación
                        contenedor.almacenarCapacitacion();
                        break;
                    case 5:
                        // Llamar al método para eliminar un usuario
                        System.out.println("Eliminar Cliente.");
                        System.out.printf("RUT cliente: ");
                        int rutElimina = entrada.nextInt();
                        contenedor.eliminarUsuario(rutElimina);
                        break;
                    case 6:
                        // Llamar al método para listar todos los usuarios
                        contenedor.listarUsuarios();
                        break;
                    case 7:
                        // Llamar al método para listar usuarios por tipo
                        contenedor.listarUsuariosPorTipo();
                        break;
                    case 8:
                        // Llamar al método para listar todas las capacitaciones
                        contenedor.listarCapacitaciones();
                        break;
                    case 9:
                        // Salir del programa
                        System.out.println("\nAdios xD saliendo de SPRINT FINAL!");
                        break;
                    case 10:
                        // Llamar al método para edad de un usuario
                        System.out.println("Mostrar edad de Usuario.");
                        System.out.printf("RUT: ");
                        int rutEdad = entrada.nextInt();
                        contenedor.edadUsuario(rutEdad);
                        break;
                    case 11:
                        // Llamar al método para listar un usuario
                        System.out.println("Existe el Usuario.");
                        System.out.printf("RUT: ");
                        int rutEdad2 = entrada.nextInt();
                        contenedor.existeUsuario(rutEdad2);
                        break;
                    default:
                        // Opción incorrecta, volver a solicitar una opción válida
                        System.out.println("\nOpción " + eleccion + " es incorrecta, seleccione una opción válida.");
                        break;
                }
            } while (eleccion != 9); // Repetir mientras la opción seleccionada no sea la de salir xD obvio
        }

        private static void ingUsuario(int eleccion){
            entrada.nextLine();
            if(eleccion >= 1 && eleccion <= 3){
                if (eleccion==1) {
                    usuarioTipo = "Cliente";
                }
                if (eleccion==2) {
                    usuarioTipo = "Profesional";
                }
                if (eleccion==3) {
                    usuarioTipo = "Administrativo";
                }

                System.out.println("*** Ingreso de " + usuarioTipo + ".");
                System.out.println("Nombres del " + usuarioTipo+":");
                nombres = entrada.nextLine();
                System.out.println("RUT:");
                rut = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Fecha nacimiento en formato dd/MM/yyyy:");
                fechaNacimiento = entrada.nextLine();

            }
        }
}

