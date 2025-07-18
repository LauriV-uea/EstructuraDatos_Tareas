
// sistema de asignación de 30 asientos en orden de llegada, una vez que todos los asientos son vendidos

package Semana8;
import java.util.LinkedList;
import java.util.Queue;  
import java.util.Scanner;  


public class AsignacionAsientos {


    // se define una constante parea el número máximo de asientos disponibles.
    private static final int LIMITE_ASIENTOS = 30;


    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);   // se crea un objeto Scanner paara leer la entrada del usuario
        Queue<String> colaAsientos = new LinkedList<>();   // Se crea una cola vacía usando LinkedList
        int opcion;   // es una variable para controlar el menú


        // ciclo que representa el menú hasta que el usuario decida salir
        do {

            // mostrar opciones del menú
            System.out.println("\n *-*-*-* Menú de asignación de asientos *-*-*-*");
            System.out.println("1. Ingresar persona a la cola");
            System.out.println("2. Mostrar personas en la cola");
            System.out.println("3. Asignar asientos");
            System.out.println("4. Salir del sistema.");
            System.out.println(" Seleccione una opción porfavor: ");
            opcion = scanner.nextInt();   // leer opcion ingrsada
            scanner.nextLine();  // sirve para limpiar el buffer del scanner


            switch (opcion)  {
                case 1:

                    //verificar si aún hay asientos disponibles
                    if (colaAsientos.size() < LIMITE_ASIENTOS)  {
                        System.out.print("Ingrese el nombre de la persona: ");
                        String nombre = scanner.nextLine();   // leer el nombre
                        colaAsientos.add(nombre);        //agregar la persona a la cola 
                        System.out.println(">> "  + nombre + " fue agregado a la cola .");

                    } else   {

                        System.out.println(" -- Todos los asientos han sido asignados.");
                    }

                    break;

                case 2:
                    // mostrar actualmente las personas en la cola
                if (colaAsientos.isEmpty())  {
                    System.out.println(" -- La cola esta vacía");
                } else  {
                    System.out.println("-- Hay personas en la cola: ");

                    int i = 1;
                    for (String persona : colaAsientos)   {
                        System.out.println( i+++ "." + persona); // muestra cada persona con un número de orden 
                    }
                }
                break;

                case 3:

                // asignar los asientos en orden de llegada
                    if (colaAsientos.isEmpty())  {
                        System.out.println(" No hay personas en la cola.");
                    } else  {
                        System.out.println(" Asignando asientos:");
                        int numeroAsiento = 1;

                        // mientras la cola no este vacía, asignar asientos y eliminar de la cola
                        while (!colaAsientos.isEmpty())   {
                            System.out.println("Asiento" + numeroAsiento + ":" + colaAsientos.poll());
                            numeroAsiento++;
                        }
                    }
                    break;


                    case 4:
                        System.out.println("+++ Saliendo del sistema++");
                        break;


                    default:
                        System.out.println( "Opción no válida. Intente de nuevo.");

            }

        } while (opcion !=4);     // el ciclo se repite mientras el usuario no elija salir
        
        scanner.close();   // se cierra el objeto scanner para liberar recursos
    }
}


  

         