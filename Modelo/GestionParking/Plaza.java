package Modelo.GestionParking;

import Modelo.Vehiculos.Vehiculo;

public class Plaza {
    private int numero;
    private boolean ocupada;
    private Vehiculo vehiculo;

    public Plaza(int numero) {
        if (numero <= 0) throw new IllegalArgumentException("El número de la plaza debe ser mayor que cero.");
        this.numero = numero;
        this.ocupada = false;
        this.vehiculo = null;
    }

    public int getNumero() { return numero; }
    public boolean plazaOcupada() { return ocupada; }
    public Vehiculo getVehiculo() { return vehiculo; }

    public void ocupar(Vehiculo vehiculo) {
        if (vehiculo == null) throw new IllegalArgumentException("No se puede ocupar una plaza con un vehículo nulo.");
        if (ocupada) throw new IllegalStateException("La plaza " + numero + " ya está ocupada.");
        this.vehiculo = vehiculo;
        this.ocupada = true;
    }

    public void liberarPlaza() {
        if (!ocupada) throw new IllegalStateException("La plaza " + numero + " ya está disponible.");
        this.vehiculo = null;
        this.ocupada = false;
    }

    @Override
    public String toString() {
        if (ocupada) return "Plaza " + numero + " - Ocupada - Vehículo: " + vehiculo.getMatricula();
        return "Plaza " + numero + " - Disponible";
    }
}
