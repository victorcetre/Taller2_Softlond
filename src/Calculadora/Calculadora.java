package Calculadora;

import java.util.Scanner;

public class Calculadora {
    
    private Scanner scanner;
    
    public Calculadora() {
        scanner = new Scanner(System.in);
    }
    
    public void iniciarCalculadora() {
        boolean continuar = true;
        
        while (continuar) {
            // Mostrar el menú de opciones
            System.out.println("¿Qué operación deseas realizar?");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            
            int opcion = scanner.nextInt();
            
            System.out.print("Ingrese el primer número: ");
            double num1 = scanner.nextDouble();
            
            System.out.print("Ingrese el segundo número: ");
            double num2 = scanner.nextDouble();
            
            double resultado = realizarOperacion(opcion, num1, num2);
            
            System.out.println("El resultado es: " + resultado);
            
            System.out.print("¿Deseas realizar otra operación? (s/n): ");
            String respuesta = scanner.next();
            if (!respuesta.equalsIgnoreCase("s")) {
                continuar = false;
                System.out.println("¡Nos vemos!");
            }
        }
        
        scanner.close();
    }
    //Realiza la operación seleccionada por el usuario
    public double realizarOperacion(int opcion, double num1, double num2) {
        switch (opcion) {
            case 1:
                return num1 + num2;
            case 2:
                return num1 - num2;
            case 3:
                return num1 * num2;
            case 4:
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    System.out.println("No se puede dividir entre cero");
                    return Double.NaN;
                }
            default:
                System.out.println("Opción inválida");
                return Double.NaN;
        }
    }
}
