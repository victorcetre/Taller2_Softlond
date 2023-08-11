package SistemaHotel;

import java.util.*;

import SistemaHotel.Habitacion.TipoHabitacion;

public class Sistema {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Hotel> hoteles = new ArrayList<>();
        hoteles.add(null);  //Elemento nulo para el índice 0
        hoteles.add(new Hotel("Hotel A", 3, Arrays.asList(Habitacion.TipoHabitacion.NORMAL, Habitacion.TipoHabitacion.SUITE, Habitacion.TipoHabitacion.EJECUTIVA)));
        hoteles.add(new Hotel("Hotel B", 5, Arrays.asList(Habitacion.TipoHabitacion.NORMAL, Habitacion.TipoHabitacion.SUITE, Habitacion.TipoHabitacion.EJECUTIVA)));
        hoteles.add(new Hotel("Hotel C", 4, Arrays.asList(Habitacion.TipoHabitacion.NORMAL, Habitacion.TipoHabitacion.SUITE, Habitacion.TipoHabitacion.EJECUTIVA)));

        List<Cliente> clientes = new ArrayList<>();
        List<Reserva> reservas = new ArrayList<>();

        Cliente cliente1 = new Cliente("Juan Pérez", "123456789", "ABC Company");
        Cliente cliente2 = new Cliente("María Gómez", "987654321", "XYZ Inc.");
        Cliente cliente3 = new Cliente("Carlos Rodríguez", "555555555", "LMN Corp");
    
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        int opcion;
        do {
            System.out.println("Sistema de Reservas de Hotel");
            System.out.println("***************************");
            System.out.println("1. Hotel");
            System.out.println("2. Cliente");
            System.out.println("3. Reservas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    menuHotel(hoteles, scanner);
                    break;
                case 2:
                    menuCliente(clientes, scanner);
                    break;
                case 3:
                    menuReservas(reservas, hoteles, clientes, scanner);
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 4);
    }

    //Método para gestionar el menú de Hotel
    private static void menuHotel(List<Hotel> hoteles, Scanner scanner) {
        int opcion;
        do {
            System.out.println("Menú Hotel");
            System.out.println("**********");
            System.out.println("1. Listar Hoteles Disponibles");
            System.out.println("2. Listar Habitaciones Disponibles en Hotel");
            System.out.println("3. Listar Habitaciones Reservadas en Hotel");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    listarHotelesDisponibles(hoteles);
                    break;
                case 2:
                    System.out.print("Ingrese el índice del hotel: ");
                    int indiceHotel = scanner.nextInt();
                    listarHabitacionesDisponiblesEnHotel(hoteles.get(indiceHotel), scanner);
                    break;
                case 3:
                    System.out.print("Ingrese el índice del hotel: ");
                    int indiceHotelReserva = scanner.nextInt();
                    listarHabitacionesReservadasEnHotel(hoteles.get(indiceHotelReserva), scanner);
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 4);
    }

    //Método para listar hoteles disponibles
    private static void listarHotelesDisponibles(List<Hotel> hoteles) {
        System.out.println("Hoteles Disponibles:");
        for (int i = 1; i < hoteles.size(); i++) {
            System.out.println(i + ". " + hoteles.get(i).getNombre());
        }
    }

    //Método para listar habitaciones disponibles en un hotel
    private static void listarHabitacionesDisponiblesEnHotel(Hotel hotel, Scanner scanner) {
        List<Habitacion> habitacionesDisponibles = hotel.listarHabitacionesDisponibles();
        System.out.println("Habitaciones Disponibles en " + hotel.getNombre() + ":");
        for (Habitacion habitacion : habitacionesDisponibles) {
            System.out.println("Habitación " + habitacion.getNumero() + " - Tipo: " + habitacion.getTipo());
        }
        System.out.println();
    }

    //Método para listar habitaciones reservadas en un hotel
    private static void listarHabitacionesReservadasEnHotel(Hotel hotel, Scanner scanner) {
        List<Habitacion> habitacionesReservadas = obtenerHabitacionesReservadasEnHotel(hotel);
        if (habitacionesReservadas.isEmpty()) {
            System.out.println("No hay habitaciones reservadas en " + hotel.getNombre());
        } else {
            System.out.println("Habitaciones Reservadas en " + hotel.getNombre() + ":");
            for (Habitacion habitacion : habitacionesReservadas) {
                System.out.println("Habitación " + habitacion.getNumero() + " - Tipo: " + habitacion.getTipo());
            }
        }
        System.out.println();
    }

    //Método para obtener las habitaciones reservadas en un hotel
    private static List<Habitacion> obtenerHabitacionesReservadasEnHotel(Hotel hotel) {
        List<Habitacion> habitacionesReservadas = new ArrayList<>();
        for (Habitacion habitacion : hotel.getHabitaciones()) {
            if (!habitacion.esDisponible()) {
                habitacionesReservadas.add(habitacion);
            }
        }
        return habitacionesReservadas;
    }

    //Método para gestionar el menú de Cliente
    private static void menuCliente(List<Cliente> clientes, Scanner scanner) {
        int opcion;
        do {
            System.out.println("Menú Cliente");
            System.out.println("************");
            System.out.println("1. Listar Clientes");
            System.out.println("2. Registrar Nuevo Cliente");
            System.out.println("3. Buscar Cliente por Cédula");
            System.out.println("4. Eliminar Cliente");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    listarClientes(clientes);
                    break;
                case 2:
                    registrarNuevoCliente(clientes, scanner);
                    break;
                case 3:
                    buscarClientePorCedula(clientes, scanner);
                    break;
                case 4:
                    eliminarCliente(clientes, scanner);
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }

    //Método para listar clientes
    private static void listarClientes(List<Cliente> clientes) {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.println("Clientes Registrados:");
            for (Cliente cliente : clientes) {
                System.out.println("Nombre: " + cliente.getNombre() + " - Cédula: " + cliente.getCedula() + " - Empresa: " + cliente.getEmpresa());
            }
        }
        System.out.println();
    }

    //Método para registrar un nuevo cliente
    private static void registrarNuevoCliente(List<Cliente> clientes, Scanner scanner) {
        System.out.println("Registrar Nuevo Cliente");
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.next();
        System.out.print("Ingrese la cédula del cliente: ");
        String cedulaCliente = scanner.next();
        System.out.print("Ingrese el nombre de la empresa del cliente: ");
        String empresaCliente = scanner.next();
        
        Cliente nuevoCliente = new Cliente(nombreCliente, cedulaCliente, empresaCliente);
        clientes.add(nuevoCliente);
        System.out.println("Cliente registrado con éxito.");
        System.out.println();
    }

    //Método para buscar un cliente por cédula
    private static void buscarClientePorCedula(List<Cliente> clientes, Scanner scanner) {
        System.out.print("Ingrese la cédula del cliente: ");
        String cedulaCliente = scanner.next();
        
        Cliente clienteEncontrado = buscarClientePorCedula(clientes, cedulaCliente);
        
        if (clienteEncontrado != null) {
            System.out.println("Cliente encontrado:");
            System.out.println("Nombre: " + clienteEncontrado.getNombre() + " - Cédula: " + clienteEncontrado.getCedula() + " - Empresa: " + clienteEncontrado.getEmpresa());
        } else {
            System.out.println("No se encontró un cliente con la cédula ingresada.");
        }
        System.out.println();
    }

    //Método para buscar un cliente por cédula (sobrecargado)
    private static Cliente buscarClientePorCedula(List<Cliente> clientes, String cedula) {
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null;
    }

    //Método para eliminar un cliente
    private static void eliminarCliente(List<Cliente> clientes, Scanner scanner) {
        System.out.print("Ingrese la cédula del cliente que desea eliminar: ");
        String cedulaCliente = scanner.next();
        
        Cliente clienteEliminar = buscarClientePorCedula(clientes, cedulaCliente);
        
        if (clienteEliminar != null) {
            clientes.remove(clienteEliminar);
            System.out.println("Cliente eliminado con éxito.");
        } else {
            System.out.println("No se encontró un cliente con la cédula ingresada.");
        }
        System.out.println();
    }

    //Método para gestionar el menú de Reservas
    private static void menuReservas(List<Reserva> reservas, List<Hotel> hoteles, List<Cliente> clientes, Scanner scanner) {
        int opcion;
        do {
            System.out.println("Menú Reservas");
            System.out.println("*************");
            System.out.println("1. Realizar Reserva");
            System.out.println("2. Cancelar Reserva");
            System.out.println("3. Listar todas las Reservas");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    realizarReserva(reservas, hoteles, clientes, scanner);
                    break;
                case 2:
                    cancelarReserva(reservas, scanner);
                    break;
                case 3:
                    listarTodasLasReservas(reservas);
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 4);
    }

    //Método para realizar una reserva
    private static void realizarReserva(List<Reserva> reservas, List<Hotel> hoteles, List<Cliente> clientes, Scanner scanner) {
        System.out.println("Realizar Reserva");
        listarHotelesDisponibles(hoteles);
        System.out.print("Seleccione el índice del hotel: ");
        int indiceHotel = scanner.nextInt();
        
        Hotel hotelSeleccionado = hoteles.get(indiceHotel);
        
        if (hotelSeleccionado != null) {
            listarHabitacionesDisponiblesEnHotel(hotelSeleccionado, scanner);
            System.out.print("Ingrese el número de habitación que desea reservar: ");
            int numeroHabitacion = scanner.nextInt();
            
            Habitacion habitacion = hotelSeleccionado.buscarHabitacionPorNumero(numeroHabitacion);
            
            if (habitacion != null) {
                if (habitacion.esDisponible()) {
                    System.out.print("Ingrese la cédula del cliente: ");
                    String cedulaCliente = scanner.next();
                    
                    Cliente cliente = buscarClientePorCedula(clientes, cedulaCliente);
                    
                    if (cliente != null) {
                        Reserva nuevaReserva = new Reserva(cliente, habitacion);
                        reservas.add(nuevaReserva);
                        habitacion.reservar();
                        System.out.println("Reserva realizada con éxito.");
                    } else {
                        System.out.println("No se encontró un cliente con la cédula ingresada.");
                    }
                } else {
                    System.out.println("La habitación seleccionada no está disponible.");
                }
            } else {
                System.out.println("No se encontró una habitación con el número ingresado.");
            }
        } else {
            System.out.println("No se encontró un hotel con el índice ingresado.");
        }
        System.out.println();
    }

    //Método para cancelar una reserva
    private static void cancelarReserva(List<Reserva> reservas, Scanner scanner) {
        System.out.println("Cancelar Reserva");
        System.out.print("Ingrese la cédula del cliente: ");
        String cedulaCliente = scanner.next();
        
        Reserva reservaCancelar = buscarReservaPorCedula(reservas, cedulaCliente);
        
        if (reservaCancelar != null) {
            reservaCancelar.getHabitacion().cancelarReserva();
            reservas.remove(reservaCancelar);
            System.out.println("Reserva cancelada con éxito.");
        } else {
            System.out.println("No se encontró una reserva asociada a la cédula ingresada.");
        }
        System.out.println();
    }

    //Método para buscar una reserva por cédula
    private static Reserva buscarReservaPorCedula(List<Reserva> reservas, String cedula) {
        for (Reserva reserva : reservas) {
            if (reserva.getCliente().getCedula().equals(cedula)) {
                return reserva;
            }
        }
        return null;
    }

    //Método para listar todas las reservas
    private static void listarTodasLasReservas(List<Reserva> reservas) {
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas registradas.");
        } else {
            System.out.println("Todas las Reservas:");
            for (Reserva reserva : reservas) {
                System.out.println("Cliente: " + reserva.getCliente().getNombre() + " - Habitación: " + reserva.getHabitacion().getNumero() + " - Hotel: " + reserva.getHabitacion().getHotel().getNombre());
            }
        }
        System.out.println();
    }
}