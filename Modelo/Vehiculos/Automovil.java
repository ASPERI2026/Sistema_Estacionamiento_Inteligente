package Modelo.Vehiculos;

import java.time.LocalDateTime;

public class Automovil extends Vehiculo {
    private int numPuertas;
    private String tipoCombustible;
    private static final double TARIFA_BASE = 10000.0;

    public Automovil(String placa, String marca, String modelo, String color,
                     LocalDateTime horaIngreso, LocalDateTime horaSalida,
                     int numPuertas, String tipoCombustible) {
        super(placa, marca, modelo, color, horaIngreso, horaSalida);
        this.numPuertas = numPuertas;
        this.tipoCombustible = tipoCombustible;
    }

    public Automovil(String placa, String marca, String modelo) {
        this(placa, marca, modelo, "No especificado", null, null, 4, "Gasolina");
    }

    @Override
    public double calcularTarifa() {
        double factor = 1.0;
        if (numPuertas > 4) factor = 1.2;
        if ("Diesel".equalsIgnoreCase(tipoCombustible)) factor *= 1.1;
        return TARIFA_BASE * factor;
    }

    public int getNumPuertas() { return numPuertas; }
    public void setNumPuertas(int numPuertas) { this.numPuertas = numPuertas; }
    public String getTipoCombustible() { return tipoCombustible; }
    public void setTipoCombustible(String tipoCombustible) { this.tipoCombustible = tipoCombustible; }
}
