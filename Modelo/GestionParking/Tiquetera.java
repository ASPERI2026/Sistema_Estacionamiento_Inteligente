package Modelo.GestionParking;

import Modelo.Vehiculos.Automovil;
import Modelo.Vehiculos.Camion;
import Modelo.Vehiculos.Moto;
import Modelo.Vehiculos.Vehiculo;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Tiquetera {
    private Map<String, LocalDateTime> tiquetes;

    public Tiquetera() {
        tiquetes = new HashMap<>();
    }

    public void emitirTiquete(Vehiculo vehiculo) {
        validarVehiculo(vehiculo);
        String placa = vehiculo.getMatricula();
        if (tiquetes.containsKey(placa))
            throw new IllegalStateException("El vehículo ya tiene un tiquete activo.");
        LocalDateTime horaIngreso = vehiculo.getHoraIngreso();
        if (horaIngreso == null) {
            horaIngreso = LocalDateTime.now();
            vehiculo.setHoraIngreso(horaIngreso);
        }
        if (horaIngreso.isAfter(LocalDateTime.now()))
            throw new IllegalArgumentException("La fecha de ingreso no puede ser futura.");
        tiquetes.put(placa, horaIngreso);
        System.out.println("Tiquete emitido correctamente.");
        System.out.println("Hora de ingreso: " + horaIngreso);
    }

    public double calcularMonto(Vehiculo vehiculo) {
        validarVehiculo(vehiculo);
        String placa = vehiculo.getMatricula();
        if (!tiquetes.containsKey(placa))
            throw new IllegalStateException("El vehículo no tiene un tiquete activo.");
        LocalDateTime horaEntrada = tiquetes.get(placa);
        LocalDateTime horaSalida = vehiculo.getHoraSalida();
        if (horaSalida == null) {
            horaSalida = LocalDateTime.now();
            vehiculo.setHoraSalida(horaSalida);
        }
        if (horaSalida.isAfter(LocalDateTime.now()))
            throw new IllegalArgumentException("La fecha de salida no puede ser futura.");
        if (horaSalida.isBefore(horaEntrada))
            throw new IllegalArgumentException("La salida no puede ser anterior a la entrada.");
        long minutos = Duration.between(horaEntrada, horaSalida).toMinutes();
        long horas = (long) Math.ceil(minutos / 60.0);
        if (horas <= 0)
            horas = 1;
        double tarifa = obtenerTarifaPorHora(vehiculo);
        double total = tarifa * horas;
        tiquetes.remove(placa);
        System.out.println("----- TIQUETE -----");
        System.out.println("Matrícula: " + placa);
        System.out.println("Entrada: " + horaEntrada);
        System.out.println("Salida: " + horaSalida);
        System.out.println("Horas cobradas: " + horas);
        System.out.println("Tarifa por hora: $" + tarifa);
        System.out.println("Total a pagar: $" + total);
        System.out.println("-------------------");
        return total;
    }

    private double obtenerTarifaPorHora(Vehiculo vehiculo) {
        if (vehiculo instanceof Moto)
            return vehiculo.calcularTarifa();
        if (vehiculo instanceof Camion)
            return vehiculo.calcularTarifa();
        if (vehiculo instanceof Automovil)
            return vehiculo.calcularTarifa();
        throw new IllegalArgumentException("Tipo de vehículo no válido.");
    }

    public boolean tieneTiquete(String matricula) {
        return matricula != null && !matricula.isBlank() && tiquetes.containsKey(matricula);
    }

    private void validarVehiculo(Vehiculo vehiculo) {
        if (vehiculo == null)
            throw new IllegalArgumentException("El vehículo no puede ser nulo.");
        if (vehiculo.getMatricula() == null || vehiculo.getMatricula().isBlank())
            throw new IllegalArgumentException("La matrícula es obligatoria.");
    }
}
