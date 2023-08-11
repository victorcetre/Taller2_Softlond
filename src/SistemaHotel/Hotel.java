package SistemaHotel;

import java.util.*;

import SistemaHotel.Habitacion.TipoHabitacion;

public class Hotel {   
    private String nombre;
    private List<Habitacion> habitaciones;
    
    public Hotel(String nombre, int numHabitaciones, List<TipoHabitacion> tiposHabitaciones) {
        this.nombre = nombre;
        habitaciones = new ArrayList<>();
        
        int numeroHabitacion = 1;
        for (TipoHabitacion tipo : tiposHabitaciones) { // Aquí usa directamente TipoHabitacion
            for (int i = 0; i < numHabitaciones; i++) {
                habitaciones.add(new Habitacion(numeroHabitacion, tipo, this));
                numeroHabitacion++;
            }
        }
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    //Lista las habitaciones disponibles en el hotel.
    public List<Habitacion> listarHabitacionesDisponibles() {
        List<Habitacion> habitacionesDisponibles = new ArrayList<>();
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.esDisponible()) {
                habitacionesDisponibles.add(habitacion);
            }
        }
        return habitacionesDisponibles;
    }

    //Busca una habitación por su número.
    public Habitacion buscarHabitacionPorNumero(int numero) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numero) {
                return habitacion;
            }
        }
        return null;
    }

    //Obtiene todas las habitaciones de un tipo específico.
    public List<Habitacion> listarHabitacionesPorTipo(Habitacion.TipoHabitacion tipo) {
        List<Habitacion> habitacionesTipo = new ArrayList<>();
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getTipo() == tipo) {
                habitacionesTipo.add(habitacion);
            }
        }
        return habitacionesTipo;
    }

    //Obtiene la cantidad total de habitaciones en el hotel.
    public int obtenerCantidadTotalHabitaciones() {
        return habitaciones.size();
    }
}