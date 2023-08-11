package SistemaHotel;

public class Reserva {
    private Cliente cliente;
    private Habitacion habitacion;
    
    public Reserva(Cliente cliente, Habitacion habitacion) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        habitacion.reservar();
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public Habitacion getHabitacion() {
        return habitacion;
    }
    
    //Cancelar la reserva y liberar la habitación
    public void cancelarReserva() {
        habitacion.cancelarReserva();
    }
}