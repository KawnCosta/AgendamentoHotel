package model;

import java.time.LocalDate;

public class Reserva {
    private int id;
    private Cliente cliente;
    private Quarto quarto;
    private LocalDate dataCheckIn;
    private StatusReserva status;

    public Reserva(int id, Cliente cliente, Quarto quarto, LocalDate dataCheckIn, StatusReserva status) {
        this.id = id;
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataCheckIn = dataCheckIn;
        this.status = status;
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

    public void setStatus(StatusReserva status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format(
            "Reserva #%d | Cliente: %s (CPF: %s) | Quarto: %s - Nº %d | Check-in: %s | Status: %s",
            id,
            cliente.getNome(),
            cliente.getDocumento(),
            quarto.getClass().getSimpleName().replace("Quarto", ""),
            quarto.getNumero(),
            dataCheckIn,
            status
        );
    }
}
