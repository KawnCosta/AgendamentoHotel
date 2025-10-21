package model;

import java.time.LocalDate;

public class Reserva {
    private int id;
    private Cliente cliente;
    private Quarto quarto;
    private LocalDate dataCheckIn;
    private StatusReserva status;

    public Reserva(int id, Cliente cliente, Quarto quarto, LocalDate dataCheckIn) {
        this.id = id;
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataCheckIn = dataCheckIn;
        this.status = StatusReserva.CONFIRMADO;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public LocalDate getDataCheckIn() {
        return dataCheckIn;
    }

    public StatusReserva getStatus() {
        return status;
    }

    public void cancelar() {
        this.status = StatusReserva.CANCELADO;
    }

    @Override
    public String toString() {
        return "Reserva #" + id +
                " | Cliente: " + cliente +
                " | Quarto: " + quarto +
                " | Check-in: " + dataCheckIn +
                " | Status: " + status;
    }
}
