// Verificación de paréntesis balanceados en una expresión matemática
// Implemente un programa que determine si los paréntesis,
// llaves y corchetes en una expresión matemática están correctamente balanceados.

import java.util.Scanner;
import java.util.Stack;


public class VerificacionParentesis {
    public static void main(String[] args) {
        System.out.println(" Verificación de parentesis balanceados. ");
        System.out.println("Ingrese una expresión matemática: ");   // solicita al usuario que ingrese la expresión

        Scanner scanner = new Scanner (System.in);  // crea el objeto escaner para leer datos desde el teclado
        String expresion = scanner.nextLine();
        scanner.close();

        if (estaBalanceada(expresion)) {
            System.out.println("Expresión matemática balanceada.");
        } else {
            System.out.println("La expresión NO está balanceada");
        }
    }

    public static boolean estaBalanceada(String expresion) {
        Stack<Character> pila = new Stack<>();    // crea una pila para almacenar los parentesis abiertos


        for (char c : expresion.toCharArray()) {   // recorre cada caracter de la expresión

            if (c == '(' || c == '{' || c == '[') {  // se agrega  a la pila si es un cararter de parentesis abierto
                pila.push(c);
            }

            else if (c == ')' || c == '}' || c == ']' )  {
                if (pila.isEmpty())  {
                    return false;
                }

                char abierto = pila.pop();

                if (!coincide(abierto, c)) {  // verifica si el carcter abierto coincide con el de cierre
                    return false;      // no coinciden por lo tanto no está balanceada 

                }
            }
        }
        return pila.isEmpty();  // si la pila está vacía todos los carcteres fueron cerrados correctamente

    }

    // método que verifica si coinciden los caracteres de apertura y cierre
    public static boolean coincide( char abierto, char cierre) {
        return (abierto == '(' && cierre == ')') ||
               (abierto == '{' && cierre == '}') ||
               (abierto == '[' && cierre == ']');
    }
}
            


    
    


