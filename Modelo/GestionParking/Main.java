package Modelo.GestionParking;

import Modelo.Vehiculos.Automovil;
import Modelo.Vehiculos.Camion;
import Modelo.Vehiculos.Moto;
import Modelo.Vehiculos.Vehiculo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Estacionamiento estacionamiento = new Estacionamiento(10);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n===== ESTACIONAMIENTO INTELIGENTE =====");
            System.out.println("1. Ingresar vehículo");
            System.out.println("2. Retirar vehículo");
            System.out.println("3. Consultar plazas disponibles");
            System.out.println("4. Mostrar plazas");
            System.out.println("5. Mostrar reporte diario");
            System.out.println("6. Salir");
            int opcion = leerEntero(entrada, "Seleccione una opción: ");

            if (opcion == 1) {
                ingresarVehiculo(entrada, estacionamiento);
            } else if (opcion == 2) {
                System.out.print("Ingrese la placa del vehículo que desea retirar: ");
                String placa = entrada.nextLine().trim();
                estacionamiento.retirarVehiculo(placa);
            } else if (opcion == 3) {
                System.out.println("Plazas disponibles: " + estacionamiento.consultarDisponibilidad());
            } else if (opcion == 4) {
                estacionamiento.mostrarPlazas();
            } else if (opcion == 5) {
                System.out.println(estacionamiento.generarReporteDiario());
            } else if (opcion == 6) {
                continuar = false;
                System.out.println("Sistema finalizado.");
            } else {
                System.out.println("Opción no válida.");
            }
        }
        entrada.close();
    }

    private static void ingresarVehiculo(Scanner entrada, Estacionamiento estacionamiento) {
        System.out.println("\n--- Tipo de vehículo ---");
        System.out.println("1. Moto");
        System.out.println("2. Automóvil");
        System.out.println("3. Camión");
        int tipo = leerEntero(entrada, "Seleccione el tipo: ");

        if (tipo != 1 && tipo != 2 && tipo != 3) {
            System.out.println("Tipo de vehículo no válido.");
            return;
        }

        System.out.print("Ingrese la placa: ");
        String placa = entrada.nextLine().trim();
        System.out.print("Ingrese la marca: ");
        String marca = entrada.nextLine().trim();
        System.out.print("Ingrese el modelo: ");
        String modelo = entrada.nextLine().trim();
        System.out.print("Ingrese el color: ");
        String color = entrada.nextLine().trim();

        Vehiculo vehiculo;

        if (tipo == 1) {
            int ruedas = leerEntero(entrada, "Ingrese el número de ruedas: ");
            double cilindraje = leerDouble(entrada, "Ingrese el cilindraje: ");
            vehiculo = new Moto(placa, marca, modelo, color, null, null, ruedas, cilindraje);
        } else if (tipo == 2) {
            int puertas = leerEntero(entrada, "Ingrese el número de puertas: ");
            System.out.print("Ingrese el tipo de combustible: ");
            String combustible = entrada.nextLine().trim();
            vehiculo = new Automovil(placa, marca, modelo, color, null, null, puertas, combustible);
        } else {
            int ejes = leerEntero(entrada, "Ingrese el número de ejes: ");
            double capacidad = leerDouble(entrada, "Ingrese la capacidad de carga: ");
            vehiculo = new Camion(placa, marca, modelo, color, null, null, ejes, capacidad);
        }

        try {
            estacionamiento.ingresarVehiculo(vehiculo);
            System.out.println("Tarifa por hora del vehículo: $" + vehiculo.calcularTarifa());
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("No se pudo registrar el vehículo: " + e.getMessage());
        }
    }

    private static int leerEntero(Scanner entrada, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = entrada.nextLine().trim();
            try { return Integer.parseInt(texto); }
            catch (NumberFormatException e) { System.out.println("Ingrese un número entero válido."); }
        }
    }

    private static double leerDouble(Scanner entrada, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = entrada.nextLine().trim().replace(',', '.');
            try { return Double.parseDouble(texto); }
            catch (NumberFormatException e) { System.out.println("Ingrese un número válido."); }
        }
    }
}
