package Modelo.Vehiculos;

import java.time.LocalDateTime;

public class Moto extends Vehiculo {
    private int numRuedas;
    private double cilindraje;

    public Moto(String placa, String marca, String modelo, String color,
                LocalDateTime horaIngreso, LocalDateTime horaSalida,
                int numRuedas, double cilindraje) {
        super(placa, marca, modelo, color, horaIngreso, horaSalida);
        this.numRuedas = numRuedas;
        this.cilindraje = cilindraje;
    }

    public Moto(String placa, String marca, String modelo) {
        this(placa, marca, modelo, "No especificado", null, null, 2, 125);
    }

    @Override
    public double calcularTarifa() {
        if (cilindraje <= 250) return 8000;
        if (cilindraje <= 600) return 10000;
        return 13000;
    }

    public int getNumRuedas() { return numRuedas; }
    public void setNumRuedas(int numRuedas) { this.numRuedas = numRuedas; }
    public double getCilindraje() { return cilindraje; }
    public void setCilindraje(double cilindraje) { this.cilindraje = cilindraje; }
}
