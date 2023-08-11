package Alumnos;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String identificacion;
    private String nombre;
    private String apellido;
    private int edad;
    private String direccion;
    private List<Double> calificaciones;

    public Alumno(String identificacion, String nombre, String apellido, int edad, String direccion) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion = direccion;
        this.calificaciones = new ArrayList<>();
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Double> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Double> calificaciones) {
        this.calificaciones = calificaciones;
    }
    // Métods para agregar calificaciones
    public void agregarCalificacion(double calificacion) {
        calificaciones.add(calificacion);
    }
    // Método para calcular promedio y mostrar información
    public double calcularPromedioCalificaciones() {
        if (calificaciones.isEmpty()) {
            return 0;
        }

        double suma = 0;
        for (double calificacion : calificaciones) {
            suma += calificacion;
        }
        return suma / calificaciones.size();
    }
    // Método para mostrar información
    @Override
    public String toString() {
        return "Alumno:\n" +
                "Identificación = '" + identificacion + '\'' +
                ", Nombre = '" + nombre + '\'' +
                ", Apellido = '" + apellido + '\'' +
                ", Edad = " + edad +
                ", Direccion = '" + direccion + '\'';
    }
}
