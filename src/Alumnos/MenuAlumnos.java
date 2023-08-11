package Alumnos;

import java.util.Scanner;

public class MenuAlumnos {
    private SistemaAlumnos sistema;
    private Scanner scanner;

    public MenuAlumnos(SistemaAlumnos sistema) {
        this.sistema = sistema;
        this.scanner = new Scanner(System.in);
    }

    // Método para mostrar el menú y ejecutar opciones

    public void mostrarMenu() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nMenu:");
            System.out.println("1. Agregar alumno");
            System.out.println("2. Asignar calificación");
            System.out.println("3. Eliminar alumno");
            System.out.println("4. Listar alumnos");
            System.out.println("5. Listar alumnos por promedio");
            System.out.println("6. Salir");
            System.out.print("\nSeleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    Alumno alumno = sistema.crearAlumno();
                    sistema.agregarAlumno(alumno);
                    break;
                case 2:
                    System.out.print("Ingrese la identificación del alumno: ");
                    String identificacion = scanner.nextLine();
                    System.out.print("Ingrese la calificación: ");
                    double calificacion = scanner.nextDouble();
                    sistema.asignarCalificacion(identificacion, calificacion);
                    break;
                case 3:
                    System.out.print("Ingrese la identificación del alumno a eliminar: ");
                    identificacion = scanner.nextLine();
                    sistema.eliminarAlumno(identificacion);
                    break;
                case 4:
                    sistema.listarAlumnos();
                    break;
                case 5:
                    sistema.listarAlumnosPorPromedio();
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }

        scanner.close();
    }

    public void ejecutar() {
        System.out.println("Bienvenido al Sistema de Alumnos");
        mostrarMenu();

        sistema.cerrarSistema();
    }
}
