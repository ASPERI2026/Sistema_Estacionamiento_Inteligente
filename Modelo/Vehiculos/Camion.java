package Modelo.Vehiculos;

import java.time.LocalDateTime;

public class Camion extends Vehiculo {
    private int numEjes;
    private double capacidadCarga;

    public Camion(String placa, String marca, String modelo, String color,
                  LocalDateTime horaIngreso, LocalDateTime horaSalida,
                  int numEjes, double capacidadCarga) {
        super(placa, marca, modelo, color, horaIngreso, horaSalida);
        this.numEjes = numEjes;
        this.capacidadCarga = capacidadCarga;
    }

    public Camion(String placa, String marca, String modelo) {
        this(placa, marca, modelo, "No especificado", null, null, 2, 0);
    }

    @Override
    public double calcularTarifa() {
        if (numEjes == 2) return 15000;
        if (numEjes == 3) return 23000;
        if (numEjes == 4) return 30000;
        if (numEjes > 4) return 40000;
        return 0;
    }

    public int getNumEjes() { return numEjes; }
    public void setNumEjes(int numEjes) { this.numEjes = numEjes; }
    public double getCapacidadCarga() { return capacidadCarga; }
    public void setCapacidadCarga(double capacidadCarga) { this.capacidadCarga = capacidadCarga; }
}
