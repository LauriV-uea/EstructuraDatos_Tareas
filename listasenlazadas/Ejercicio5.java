//Crear un programa que maneje dos listas enlazadas de elementos que manejen datos de tipo entero.
//La primera se deben almacenar sólo números primos y se agregan por el final.
//La segunda sólo deben contener números Armstrong, se agregan por el inicio de la fila.
//Al final mostrar: a) el número de datos insertados en cada lista, b)mostrar un mensaje indicando la lista
// que contiene más elementos, c)mostrar todos los datos insertados en la lista

package listasenlazadas;

import java.util.Scanner;


//clase principal
public class Ejercicio5 {

    //clase interna nodo que representa un elemento de la lista enlazada
    static class Nodo {
        int valor;          //dato que almacena el nodo
        Nodo siguiente;          //siguiente nodo


        //constructor que inicializa el nodo con un valor
        Nodo(int valor) {
            this.valor = valor;
        }
    }
    



    // método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Nodo primos = null;             //puntero al inicio de la lista números primos
        Nodo primosUltimo = null;         // puntero al último nodo de la lista números primos
        Nodo armstrong = null;          // puntero al inicio de la lista números Armstrong


        // Solicita al usuario que ingrese números
        System.out.print("Ingrese números enteros positivos o (0 para terminar):");
        while (true) {
            System.out.print("Número: ");
            int n = scanner.nextInt();
            if (n == 0) break;    // finaliza la entrada si se ingresa 0


            // Si el número es primo se agrega al final de la lista
            if ( esPrimo(n)) {
                Nodo nuevo = new Nodo(n);
                if (primos == null)  {
                    primos = nuevo;    // primer nodo de la lista
                    primosUltimo = nuevo;
                } else {    
                    primosUltimo.siguiente = nuevo;   // enlaza al final 
                    primosUltimo = nuevo;
                }
            }

            // si el número es Armstrong se agrega al inicio de la lista
            if (esArmstrong(n))  {
                Nodo nuevo = new Nodo(n);
                nuevo.siguiente = armstrong;
                armstrong = nuevo;
            }

        }


        // cuenta la cantidad de nodos en cada lista
        int cantidadPrimos = contarNodos(primos);
        int cantidadArmstrong = contarNodos(armstrong);


        // muestra la cantidad de elementos en cada lista
        System.out.println("\n Cantidad de primos: " + cantidadPrimos);
        System.out.println(" Cantidad de números Armstrong: " + cantidadArmstrong);


        //compara cuál lista tiene más elementos 
        if (cantidadPrimos  > cantidadArmstrong)  {
            System.out.println("La lista de números primos contiene más elementos.");
        } else if (cantidadArmstrong > cantidadPrimos) {
            System.out.println("La lista de Armstrong contiene más elementos");
        } else {
            System.out.println("Ambas listas tienen la misma cantidad de elementos.");
        }

        //muestra el contenido de la lista de primos 
        System.out.println("\n Lista de números primos. ");
        mostrarLista(primos);


        //muestra el contenido de la lista de Armstrong
         System.out.println("\n Lista de números Armstrong: ");
        mostrarLista(armstrong);
    }


    //método que verifica si un número es primo 
    static boolean esPrimo(int n)  {
        if (n < 2) return false;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if (n% i== 0) return false;
        }
        return true;
    }


     //método que verifica si un número es Armstrong
    static boolean esArmstrong(int n){
        int original = n, suma = 0;
        int digitos = String.valueOf(n).length();    //cantidad de digítos
        while(n > 0) {
            int d = n %10;
            suma += Math.pow(d, digitos);     //eleva cada digíto a la potencia del número de digítos 
            n /= 10;
        }
        return suma == original;   // verifica si la suma coincide con el número original
    }


    //método que cuenta cuantos nodos tiene una lista enlazada
    static int contarNodos(Nodo cabeza) {
        int count = 0;
        while (cabeza != null)  {
            count++;
            cabeza = cabeza.siguiente;
        }
        return count;
    }


    //método que muestra los valores almacenados en una lista enlazada
    static void mostrarLista(Nodo cabeza)  {
        if (cabeza == null)   {
            System.out.println("(lista vacía)");
            return;
        }

        Nodo actual = cabeza;
        while (actual != null)  {
            System.out.println(actual.valor + "");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}
