package ejercicio;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("Seleccione el tipo de dato a utilizar:");
        System.out.println("1. Integer");
        System.out.println("2. Double");
        int tipo = scanner.nextInt();

        if (tipo != 1 && tipo != 2) {
            System.out.println("Opción inválida. Cerrando el programa...");
            return;
        }

        if (tipo == 1) {
            OperacionesMat<Integer> operaciones = new OperacionesMat<>();

            while (continuar) {
                int opcion = mostrarMenu(scanner);

                if (opcion == 8) {
                    continuar = false;
                    break;
                }

                System.out.print("Ingrese el primer número entero: ");
                int num1 = scanner.nextInt();

                int num2 = 0;
                if (opcion != 6 && opcion != 7) { // Para raíces solo se usa un número
                    System.out.print("Ingrese el segundo número entero: ");
                    num2 = scanner.nextInt();
                }

                ejecutarOperacion(opcion, num1, num2, operaciones);
            }

        } else {
            OperacionesMat<Double> operaciones = new OperacionesMat<>();

            while (continuar) {
                int opcion = mostrarMenu(scanner);

                if (opcion == 8) {
                    continuar = false;
                    break;
                }

                System.out.print("Ingrese el primer número decimal: ");
                double num1 = scanner.nextDouble();

                double num2 = 0;
                if (opcion != 6 && opcion != 7) { // Para raíces solo se usa un número
                    System.out.print("Ingrese el segundo número decimal: ");
                    num2 = scanner.nextDouble();
                }

                ejecutarOperacion(opcion, num1, num2, operaciones);
            }
        }

        System.out.println("Programa finalizado.");
        scanner.close();
    }

    public static int mostrarMenu(Scanner scanner) {
        System.out.println("\nMenú de Operaciones Clases Genéricas:");
        System.out.println("1. Suma.");
        System.out.println("2. Resta.");
        System.out.println("3. Producto.");
        System.out.println("4. División.");
        System.out.println("5. Potencia.");
        System.out.println("6. Raíz Cuadrada.");
        System.out.println("7. Raíz Cúbica.");
        System.out.println("8. Salir.");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public static <T extends Number> void ejecutarOperacion(int opcion, T num1, T num2, OperacionesMat<T> operaciones) {
        switch (opcion) {
            case 1:
                System.out.println("Resultado: " + operaciones.suma(num1, num2));
                break;
            case 2:
                System.out.println("Resultado: " + operaciones.resta(num1, num2));
                break;
            case 3:
                System.out.println("Resultado: " + operaciones.producto(num1, num2));
                break;
            case 4:
                try {
                    System.out.println("Resultado: " + operaciones.division(num1, num2));
                } catch (ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            case 5:
                System.out.println("Resultado: " + operaciones.potencia(num1, num2));
                break;
            case 6:
                System.out.println("Resultado: " + operaciones.raizCuadrada(num1));
                break;
            case 7:
                System.out.println("Resultado: " + operaciones.raizCubica(num1));
                break;
            default:
                System.out.println("Opción inválida. Intente de nuevo.");
        }
    }
}


