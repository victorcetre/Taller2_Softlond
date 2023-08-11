import Alumnos.Alumno;
import Alumnos.MenuAlumnos;
import Alumnos.SistemaAlumnos;
import Calculadora.Calculadora;
import ConversorMonedas.ConversorMonedas;
import SistemaHotel.Sistema;

public class App {
    public static void main(String[] args) throws Exception {

        //Sistema Hotel
        Sistema.main(args);

        //Sistema de Alumnos
        // SistemaAlumnos sistema = new SistemaAlumnos();

        // Alumno alumno1 = new Alumno("1", "Juan", "Perez", 20, "Calle 123");
        // Alumno alumno2 = new Alumno("2", "Maria", "Lopez", 22, "Avenida 456");
        // sistema.agregarAlumno(alumno1);
        // sistema.agregarAlumno(alumno2);

        // MenuAlumnos menu = new MenuAlumnos(sistema);
        // menu.ejecutar();

        // Iniciar el conversor de monedas creando una instancia de la clase
        //ConversorMonedas conversor = new ConversorMonedas();
        //conversor.iniciarConversor();

        // Iniciar la calculadora creando una instancia de la clase
        // Calculadora calculadora = new Calculadora();
        // calculadora.iniciarCalculadora();
    }
}
