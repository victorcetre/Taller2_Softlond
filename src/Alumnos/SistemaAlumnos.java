package Alumnos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SistemaAlumnos {
    private List<Alumno> alumnos;
    private Scanner scanner;

    public SistemaAlumnos() {
        alumnos = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    //Método para agregar alumno
    public void agregarAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }
    //Método para asignar calificaciones
    public void asignarCalificacion(String identificacion, double calificacion) {
        Alumno alumno = buscarAlumnoPorIdentificacion(identificacion);
        if (alumno != null) {
            alumno.agregarCalificacion(calificacion);
        } else {
            System.out.println("Alumno no encontrado.");
        }
    }
    //Método para eliminar alumno
    public void eliminarAlumno(String identificacion) {
        Iterator<Alumno> iterator = alumnos.iterator();
        while (iterator.hasNext()) {
            Alumno alumno = iterator.next();
            if (alumno.getIdentificacion().equals(identificacion)) {
                iterator.remove();
                System.out.println("Alumno eliminado.");
                return;
            }
        }
        System.out.println("Alumno no encontrado.");
    }
    //Método para listar alumnos
    public void listarAlumnos() {
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
            System.out.println("Promedio de calificaciones: " + alumno.calcularPromedioCalificaciones());
            System.out.println("-----------------------------------------------------------------------------------");
        }
    }
    // Métodos para listar alumnos por promedio
    public void listarAlumnosPorPromedio() {
        List<Alumno> alumnosOrdenados = new ArrayList<>(alumnos);
        alumnosOrdenados.sort((a1, a2) -> Double.compare(a2.calcularPromedioCalificaciones(), a1.calcularPromedioCalificaciones()));

        for (Alumno alumno : alumnosOrdenados) {
            System.out.println(alumno);
            System.out.println("Promedio de calificaciones: " + alumno.calcularPromedioCalificaciones());
            System.out.println("-----------------------------------------------------------------------------------");
        }
    }
    // Métodos para buscar alumno por identificación
    public Alumno buscarAlumnoPorIdentificacion(String identificacion) {
        for (Alumno alumno : alumnos) {
            if (alumno.getIdentificacion().equals(identificacion)) {
                return alumno;
            }
        }
        return null;
    }
    // Método para crear alumno
    public Alumno crearAlumno() {
        System.out.print("Ingrese la identificación del alumno: ");
        String identificacion = scanner.nextLine();

        System.out.print("Ingrese el nombre del alumno: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido del alumno: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese la edad del alumno: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la dirección del alumno: ");
        String direccion = scanner.nextLine();

        return new Alumno(identificacion, nombre, apellido, edad, direccion);
    }
    // Método para cerrar el sistema
    public void cerrarSistema() {
        scanner.close();
    }
}

