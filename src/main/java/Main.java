import Conexion.ConexionOracle;
import libs.Leer;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        boolean salir = false;
        int opcion;
        Connection conexion = null;

        do {
            System.out.println("0. Salir");
            System.out.println("1. Conectar a la base de datos");

            opcion = Leer.pedirEntero("Introduce una opción: ");

            switch (opcion) {
                case 0:
                    salir = true;
                    break;
                case 1:
                    String nombreBD = Leer.pedirCadena("Introduce el nombre de la base de datos: ");
                    conexion = ConexionOracle.conectar(nombreBD);
                    try {
                        conexion.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    System.out.println("La opción seleccionada no existe");
            }

        } while (!salir);
    }
}
