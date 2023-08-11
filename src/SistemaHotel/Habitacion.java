package SistemaHotel;

public class Habitacion {
    private int numero;
    private boolean disponible;
    private Hotel hotel;
    private TipoHabitacion tipo;
    
    public enum TipoHabitacion {
        NORMAL,
        SUITE,
        EJECUTIVA
    }
    
    public Habitacion(int numero, TipoHabitacion tipo, Hotel hotel) {
        this.numero = numero;
        this.disponible = true;
        this.tipo = tipo;
        this.hotel = hotel;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public boolean esDisponible() {
        return disponible;
    }

    
    
    public TipoHabitacion getTipo() {
        return tipo;
    }
    
    public Hotel getHotel() {
        return hotel;
    }
    
    public void reservar() {
        disponible = false;
    }
    
    public void cancelarReserva() {
        disponible = true;
    }
    
    @Override
    public String toString() {
        return "Habitacion {" +
                "numero =" + numero +
                ", disponible=" + disponible +
                ", tipo=" + tipo +
                '}';
    }
}