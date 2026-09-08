package Modelo.Vehiculos;

import java.time.LocalDateTime;

public class Vehiculo {
    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private LocalDateTime horaIngreso;
    private LocalDateTime horaSalida;

    public Vehiculo(String placa, String marca, String modelo, String color,
                    LocalDateTime horaIngreso, LocalDateTime horaSalida) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.horaIngreso = horaIngreso;
        this.horaSalida = horaSalida;
    }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public LocalDateTime getHoraIngreso() { return horaIngreso; }
    public void setHoraIngreso(LocalDateTime horaIngreso) { this.horaIngreso = horaIngreso; }
    public LocalDateTime getHoraSalida() { return horaSalida; }
    public void setHoraSalida(LocalDateTime horaSalida) { this.horaSalida = horaSalida; }

    public String getMatricula() { return placa; }
    public void setMatricula(String matricula) { this.placa = matricula; }

    public double calcularTarifa() { return 0; }

    @Override
    public String toString() {
        return "Placa: " + placa + ", Marca: " + marca + ", Modelo: " + modelo + ", Color: " + color;
    }
}
