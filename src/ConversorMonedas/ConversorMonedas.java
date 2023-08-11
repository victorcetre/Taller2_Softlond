package ConversorMonedas;

import java.util.Scanner;

public class ConversorMonedas {
     private Scanner scanner;

    public ConversorMonedas() {
        scanner = new Scanner(System.in);
    }
    // Iniciar el conversor de monedas y muestra las opciones de conversión disponibles.
    public void iniciarConversor() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("¿Qué tipo de conversión deseas realizar?");
            System.out.println("1. Dólares a Euros");
            System.out.println("2. Euros a Dólares");
            System.out.println("3. Dólares a Pesos Colombianos");
            System.out.println("4. Pesos Colombianos a Dólares");
            System.out.println("5. Dólares a Libras Esterlinas");
            System.out.println("6. Libras Esterlinas a Dólares");

            int opcion = scanner.nextInt();

            System.out.print("Ingrese la cantidad a convertir: ");
            double cantidad = scanner.nextDouble();

            double resultado = realizarConversion(opcion, cantidad);

            System.out.println("El resultado es: $ " + resultado);

            System.out.print("¿Deseas realizar otra conversión? (s/n): ");
            String respuesta = scanner.next();
            if (!respuesta.equalsIgnoreCase("s")) {
                continuar = false;
                System.out.println("¡Nos vemos!");
            }
        }

        scanner.close();
    }
    //Realiza la conversión de monedas según la opción seleccionada.
    public double realizarConversion(int opcion, double cantidad) {
        double factor = 0;

        switch (opcion) {
            case 1: // Dólares a Euros
                factor = 0.9119;
                break;
            case 2: // Euros a Dólares
                factor = 1.0965;
                break;
            case 3: // Dólares a Pesos Colombianos
                factor = 4079.7809;
                break;
            case 4: // Pesos Colombianos a Dólares
                factor = 0.0002451112;
                break;
            case 5: // Dólares a Libras Esterlinas
                factor = 0.78434;
                break;
            case 6: // Libras Esterlinas a Dólares
                factor = 1.2749;
                break;
            default:
                System.out.println("Opción inválida");
                return Double.NaN;
        }

        return cantidad * factor;
    }
}
