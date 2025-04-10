import java.util.Scanner;
import java.util.Random;

public class Taller {
    private static Scanner sc = new Scanner(System.in);
    private static Random rand = new Random();

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
        } while (opcion != 6);
    }

    public static void mostrarOpciones() {
        // TODO: Incluir los println con las opciones para el menú por consola.
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
        // TODO: Implementar la lógica correspondiente a cada opción.
        switch (opcion) {
            case 1 -> {
                int[][]matriz=crearMatriz();
                matriz=llenarMatriz(matriz);
            }
            case 2 -> leerFila();
            case 3 -> System.out.println(" 2 ");
            case 4 -> System.out.println("  Hasta luego...");
            default -> System.out.println(" Opcion invalida...");
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
        // TODO: Implementar impresión de cada elemento de la matriz.
        // Imprimir el resultado
        System.out.println("\nMatriz Resultante ");
        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[i].length; j++) {
                System.out.print(resultado[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void leerFila() {

    }
}