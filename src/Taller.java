import java.util.Scanner;
import java.util.Random;

public class Taller {
    private static Scanner sc = new Scanner(System.in);
    private static Random rand = new Random();
    private static int[][] matriz = null;


    public static void main(String[] args) {
        // TODO: Implementar la lógica inicial y llamada a los métodos necesarios.
        menu();
        sc.close();
        System.out.println("Terminado ");
    }

    public static void menu() {
        int opcion;
        do {
            mostrarOpciones();
            opcion = obtenerOpcion(0);
            if (opcion != -1) {
                ejecutarOpcion(opcion);
            }
        } while (opcion != 4);
    }

    public static void mostrarOpciones() {
        System.out.println("\n=============================");
        System.out.println("            Taller            ");
        System.out.println("      Opciones      ");
        System.out.println("============================= ");
        System.out.println("    [1] Crear Matriz mxn aleatoria      ");
        System.out.println("    [2] Mostrar fila deseada de Matriz      ");
        System.out.println("    [3] Verificar si es Matriz tipo cero      ");
        System.out.println("    [4] Salir       ");


        System.out.println("============================= ");
        System.out.print("      Opcion: ");
    }

    public static int obtenerOpcion(int opcion) {
        try {
            opcion = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un numero valido");
            return -1; // Devolver un valor inválido para que no ejecute ninguna opción
        }
        return opcion;
    }

    public static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> {
                matriz = crearMatriz();
                llenarMatriz(matriz);
            }
            case 2 -> leerFila(matriz);
            case 3 -> matrizCero(matriz);
            case 4 -> System.out.println("Hasta luego...");
            default -> System.out.println("Opción inválida...");
        }
    }

    public static void matrizCero(int[][]matriz) {
        if (!existeMatriz()) return;
        int ceros = 0;
        int totalElementos = matriz.length * matriz[0].length;

        for (int[] fila : matriz) {
            for (int val : fila) {
                if (val == 0) {
                    ceros++;
                }
            }
        }

        if (ceros > totalElementos / 2) {
            System.out.println("La matriz ES de tipo cero (más de la mitad de los elementos son ceros).");
        } else {
            System.out.println("La matriz NO es de tipo cero.");
        }
    }


    public static int[] validarDimensiones() {
        int filas = 0;
        int cols = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print("Introduce el número de filas: ");
                filas = Integer.parseInt(sc.nextLine());

                System.out.print("Introduce el número de columnas: ");
                cols = Integer.parseInt(sc.nextLine());

                if (filas > 0 && cols > 0) {
                    valido = true;
                } else {
                    System.out.println("Las dimensiones deben ser mayores que cero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error, ingrese números enteros válidos.");
            }
        }
        return new int[]{filas, cols};
    }


    public static int[][] crearMatriz() {
        int[] dimensiones = validarDimensiones();
        int filas = dimensiones[0];
        int cols = dimensiones[1];

        int[][] matriz = new int[filas][cols];
        return matriz;
    }

    private static int[][] llenarMatriz(int[][] matriz) {
        int filas = matriz.length;
        int cols = matriz[0].length;
        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < cols; j++) {
                matriz[i][j] = rand.nextInt(10);
            }
        }
        leerMatriz(matriz);
        return matriz;
    }

    public static void leerMatriz(int[][] resultado) {
        System.out.println("\nMatriz Resultante:");
        for (int[] fila : resultado) {
            for (int val : fila) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void leerFila(int[][]matriz) {
        if (!existeMatriz()) return;

        int fila = -1;
        while (true) {
            try {
                System.out.print("Ingrese el número de la fila a ver (desde 0): ");
                fila = Integer.parseInt(sc.nextLine());
                if (fila >= 0 && fila < matriz.length) {
                    break;
                } else {
                    System.out.println("Número de fila fuera de rango.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
            }
        }

        System.out.print("Fila " + fila + ": ");
        for (int valor : matriz[fila]) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }

    public static boolean existeMatriz() {
        if (matriz == null) {
            System.out.println("Primero debes crear una matriz (opción 1).");
            return false;
        }
        return true;
    }

}