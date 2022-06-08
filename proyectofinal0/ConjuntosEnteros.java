
import java.util.Scanner;

public class ConjuntosEnteros {
/*clase de la funcion principal llamando a los metodos y funciones de la clase Metodos*/
    public static void main(String[] args) {
        Metodos met = new Metodos();
        met.menu();
    }

}

class Metodos {
	
	

    int[] A, B, C;
    int tamA, tamB, x = 0;
    Scanner entrada = new Scanner(System.in);
    
    /*funcion para llenar el conjunto A*/

    public void llenarA() {
        System.out.println("\n---------------------------------------------\n"
                + "-   *****   Ingrese el tamanio de A  *****   -\n"
                + "---------------------------------------------");
        tamA = entrada.nextInt();
        A = new int[tamA];

        System.out.println("\n-------------------------\n"
                + "-       llenando A      -\n"
                + "-------------------------");
        for (int i = 0; i < tamA; i++) {
            System.out.println("Ingrese un numero -> ");
            A[i] = entrada.nextInt();
        }
    }
    
    /* funcion para llenar conjunto B*/

    public void llenarB() {
        System.out.println("\n---------------------------------------------\n"
                + "-   *****   Ingrese el tamanio de B  *****   -\n"
                + "---------------------------------------------");
        tamB = entrada.nextInt();
        B = new int[tamB];

        System.out.println("\n-------------------------\n"
                + "-       llenando B      -\n"
                + "-------------------------");
        for (int i = 0; i < tamB; i++) {
            System.out.println("Ingrese un numero -> ");
            B[i] = entrada.nextInt();
        }
    }
    /*funcion para procesar los connjuntos y calcular sus elementos en comun, es decir, interseccion*/
    
    public void Interseccion() {
        int s = 0;
        C = new int[100];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    C[s] = A[i];
                    s++;
                }
            }
        }

        System.out.println("\n-------------------------------\n"
                + "-       A INTERSECCION B      -\n"
                + "-------------------------------");
        for (int i = 0; i < s; i++) {
            System.out.print(C[i] + " - ");
        }
    }
    
    /*funcion para procesar los connjuntos y calcular sus elementos no comunes de A con los elementos de B, es decir, diferencia A-B*/
    public void Diferencia() {
        C = new int[100];
        int k = 0, cont;

        for (int i = 0; i < A.length; i++) {
            cont = 0;
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    cont++;
                }
            }

            if (cont == 0) {
                C[k] = A[i];
                k++;
            }

        }

        System.out.println("\n---------------------------\n"
                + "-           A - B         -\n"
                + "---------------------------");
        for (int i = 0; i < k; i++) {
            System.out.print(C[i] + " - ");
        }
    }

    
   /*funcion del menu para redirigir la opcion a la funcion deseada en las operaciones de conjuntos*/

    public void menu() {
        int opc;
        System.out.println("\n\n------------------------------------------\n"
                + "-        OPERACIONES CON CONJUNTOS       -\n"
                + "------------------------------------------\n"
                + "-    1. Interseccion A y B               -\n"
                + "-    2. Diferencia A - B                 -\n"
                + "-    3. Salir                            -\n"
                + "------------------------------------------");
        System.out.println("-   Digite su opcion                     -\n"
                + "------------------------------------------\n");

        opc = entrada.nextInt();
        switch (opc) {
            case 1:
                llenarA();
                llenarB();
                Interseccion();
                menu();
                break;
            case 2:
                llenarA();
                llenarB();
                Diferencia();
                menu();
                break;
            case 3:
                System.out.println("\n-------------------------------------------------\n"
                        + "+               Sesion culminada                -\n"
                        + "-------------------------------------------------");
                break;
            default:
                menu();
                break;
        }
    }
}
