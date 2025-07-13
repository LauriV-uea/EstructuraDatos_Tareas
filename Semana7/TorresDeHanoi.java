//Resolución del problema de las Torres de Hanoi
//Desarrolle un algoritmo que resuelva el problema de las Torres de Hanoi utilizando pilas. 
//El programa debe mostrar paso a paso cómo se mueven los discos entre las torres.


import  java.util.Scanner;
import java.util.Stack;

// clase que representa el juego de las Torres de Hanoi
public class TorresDeHanoi {

    // pila para cada torre 
    private Stack<Integer> torreA = new Stack<>();
    private Stack<Integer> torreB = new Stack<>();
    private Stack<Integer> torreC = new Stack<>();


    // constructor que inicializa la torre A con los discos
    public TorresDeHanoi (int numDiscos) {
        for (int i = numDiscos; i >= 1; i--) {
            torreA.push(i);   // agrega los discos en orden descendente
        }
    }

    //método para empezar a resolver el juego
    public void resolver() {
        mostrarTorres();   // muestra el estado inicial
        moverDiscos(torreA, torreC, torreB, torreA.size());     // esto llama al algoritmo recursivo
    }

    //método recursivo para mover los discos
    private void moverDiscos (Stack<Integer> origen, Stack<Integer> destino, Stack<Integer> auxiliar, int n) {
        if (n == 1) {

            int disco = origen.pop();   // caso base: mover un solo disco
            destino.push(disco);         //quita el disco del origen
            System.out.println ("Mover disco"  + disco);    // muestra el estado actual
            mostrarTorres();
        } else {

            moverDiscos (origen, auxiliar, destino, n - 1);   //paso 1: mover n-1 discos al auxiliar
            moverDiscos (origen, destino, auxiliar, 1);    //paso 2: mover el disco más grande al destino
            moverDiscos (auxiliar, destino, origen, n - 1);  // paso 3: mover los n-1 discos del auxiliar al destino
        }
    }

    // método que muestra visualmente el contenido de cada torre
    private void mostrarTorres()  {
        System.out.println("\n Estado actual de las Torres: ");
        System.out.println("A: " +torreA);
        System.out.println("B: " + torreB);
        System.out.println("C: " + torreC);
        System.out.println();
    }


    //método principal que ejecuta el programa
    public static void main (String[] args) { 

        System.out.println(" TORRES DE HANOI ");
        System.out.println(" Mueve todos los discos de la torre A a la C paso  a paso \n");

        Scanner scanner = new Scanner (System.in);
        System.out.print(" Ingrese el número de discos:");
        int n = scanner.nextInt();

        TorresDeHanoi juego = new TorresDeHanoi(n);
        juego.resolver();
    }
}






