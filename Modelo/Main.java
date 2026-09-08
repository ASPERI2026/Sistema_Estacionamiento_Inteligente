package Modelo;
import Modelo.Vehiculos.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("===== ESTACIONAMIENTO INTELIGENTE =====");

        System.out.println("\nSeleccione el tipo de vehículo:");
        System.out.println("1. Moto");
        System.out.println("2. Automóvil");
        System.out.println("3. Camión");
        System.out.print("Opción: ");

        int opcion = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Ingrese la placa: ");
        String placa = entrada.nextLine();

        System.out.print("Ingrese la marca: ");
        String marca = entrada.nextLine();

        System.out.print("Ingrese el modelo: ");
        String modelo = entrada.nextLine();

        if (opcion == 1) {

            Moto moto = new Moto(placa, marca, modelo);

            System.out.println("\nMoto registrada correctamente.");

        } else if (opcion == 2) {

            Automovil automovil = new Automovil(placa, marca, modelo);

            System.out.println("\nAutomóvil registrado correctamente.");

        } else if (opcion == 3) {

            Camion camion = new Camion(placa, marca, modelo);

            System.out.println("\nCamión registrado correctamente.");

        } else {

            System.out.println("\nOpción no válida.");
        }

        entrada.close();
    }
}