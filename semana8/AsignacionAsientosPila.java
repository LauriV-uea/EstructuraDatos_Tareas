// sistema de asignación de 30 asientos en orden de llegada, una vez que todos los asientos son vendidos

package semana8;
import java.util.Scanner;
import  java.util.Stack;

// clase Nodo que representa una persona
class  Nodo {
    String nombre;
    Nodo siguiente;

    Nodo (String nombre)  {
        this.nombre = nombre;
        this.siguiente = null;
    }
}


public class AsignacionAsientosPila {
    private static final int LIMITE_ASIENTOS = 30;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Nodo> pilaAsientos = new Stack<>();
        int opcion;

        do {
            System.out.println("\n=== Menú de asignación de asientos ===");
            System.out.println("1. Ingresar persona ");
            System.out.println("2. Mostrar personas en la pila");
            System.out.println("3. Asiganr asientos ");
            System.out.println("4.  Salir");
            System.out.print(" Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();


            switch (opcion) {
                case 1:
                    if (pilaAsientos.size() < LIMITE_ASIENTOS) {
                       System.out.print(" Ingrese el nombre de la persona: ");
                       String nombre = scanner.nextLine();
                       Nodo persona = new Nodo(nombre);
                       pilaAsientos.push(persona);
                       System.out.println("+++" + nombre + " fue agregado a la pila. ");
                    } else {
                        System.out.println("-- Todos los asientos han sido asignados. ");
                    }
                    break;

                case 2:
                    if (pilaAsientos.isEmpty()) {
                        System.out.println("-- La  pila está vacía.");
                    } else {
                        System.out.println(" Personas actualmente en la pila: ");
                        int  i = pilaAsientos.size();
                        for (Nodo persona : pilaAsientos)  {
                            System.out.println(" Posición" +  i-- + ":" + persona.nombre);
                        }
                    }
                    break;

                case 3:
                    if (pilaAsientos.isEmpty())  {
                        System.out.println(" No hay personas para asignar asientos.");
                    } else {
                        System.out.println(" Asignando asientos :");
                        int numAsiento = 1;
                        while (!pilaAsientos.isEmpty()) {
                            Nodo persona = pilaAsientos.pop(); 
                            System.out.println(" Asiento" + numAsiento + ":" + persona.nombre);
                            numAsiento++;
                        }
                    }   
                    break;

                case 4:
                    System.out.println(" Saliendo del sistema........");
                    break;

                default:
                    System.out.println(" Opción no disponible. Intente de nuevo.");
            }
        }while (opcion != 4);

        scanner.close();
    }
}



            