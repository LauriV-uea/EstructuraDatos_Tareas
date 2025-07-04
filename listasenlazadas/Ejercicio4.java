
//ejercicio 4.
//Crear una lista enlazada con 50 números enteros, del 1 al 999 generados aleatoriamente.
//Una vez creada la lista, se deben eliminar los nodos que estén fuera de un rango de valores leídos 
//desde el teclado.


package listasenlazadas;
import java.util.Random;
import java.util.Scanner;


public class Ejercicio4 {
    //clase interna estática nodo, el cual representa cada elemento de la lista enlazada
    static class Nodo { 
        int valor;          //guarda el número entero
        Nodo siguiente;    // siguiente nodo de la lista


        //constructor del nodo que recibe el valor de un número entero
        Nodo(int valor) {
            this.valor = valor;    // asigna el valor recibido
            this.siguiente = null;    //no apunta a ningún nodo
        }
    }
    


    // método principal donde inicia el programa
    public static void main(String[] args) {
        Random random = new Random();      //objeto random para generar números aleatorios
        Scanner scanner = new Scanner(System.in);     //objeto escaner para leer desde el teclado

        Nodo cabeza = null;    //apuntador al primer nodo de la lista(lista vacía del inicio)
        Nodo actual = null;       //apuntador al último nodo agregado 



        //crear lista enlazada con 50 números aleatorios
        for (int i = 0; i < 50; i++) {
            int num = random.nextInt(999) + 1;   //genera números entre 1 y 999
            Nodo nuevo = new Nodo(num);         // crea un nodo con ese número
            if (cabeza == null)  {             // si la lista esta vacía, el nuevo nodo serála cabeza
                cabeza = nuevo;   
                actual = nuevo;
            } else {                // si hay elementos, encadena el nuevo nodo al final
                actual.siguiente = nuevo;
                actual = nuevo;         // mueve el puntero actual al último modo
            }
        }


        //mostrar lista generada inicialmente
        System.out.println("Lista Generada: ");
        mostrarLista(cabeza);


        //pedir al usuario que ingrese el rango mínimo y máximo
        System.out.print("Ingrese límite inferior del rango: ");
        int min = scanner.nextInt();
        System.out.print("Ingrese límite superior del rango: ");
        int max = scanner.nextInt();


        //llamar método para eliminar nodos fuera de rango
        cabeza = eliminarFueraRango(cabeza, min, max);


        System.out.println("\n Lista después de eliminar valores fuera del rango: ");
        mostrarLista(cabeza);

    }

    
    // método que elimina cuyo nodo esten fuera del rango minímo y máximo
    static Nodo eliminarFueraRango(Nodo cabeza, int min, int max)   {

        while (cabeza != null && (cabeza.valor < min || cabeza.valor > max))  {
            cabeza = cabeza.siguiente;   //  avanza la cabeza al siguiente 
            
        }

        Nodo actual = cabeza;
        // recorrer el resto de la lista
        while (actual != null && actual.siguiente != null) {
            if (actual.siguiente.valor < min || actual.siguiente.valor > max )  {
                actual.siguiente = actual.siguiente.siguiente;
            } else {
                actual  = actual.siguiente;  //si está dentro del rango avanza al siguiente

            }
        }

        return cabeza;   // retorna la cabeza de la lista filtrada
    }

    //método que recorre y muestra todos los valores de la lista 
    static void mostrarLista(Nodo cabeza) {
        Nodo actual = cabeza;        // apuntador para recorrer la lista
        while (actual != null) {
            System.out.print(actual.valor + " ");   // imprime el valor del nodo
            actual = actual.siguiente;            // avanza al siguiente  nodo
        }
        System.out.println();
    }
}



 

        
    

