package controller;

import dao.ReservaDAO;
import model.*;
import util.DataUtils;

import java.time.LocalDate;
import java.util.List;

public class ReservaController {
    private final ReservaDAO reservaDAO = new ReservaDAO();

    public void criarReserva(int id, String nomeCliente, String documento, String tipoQuarto, String data) throws Exception {
        LocalDate checkIn = DataUtils.converterData(data);

        Cliente cliente = new Cliente(nomeCliente, documento);
        Quarto quarto = tipoQuarto.equalsIgnoreCase("luxo") ? new QuartoLuxo(id) : new QuartoStandard(id);

        Reserva reserva = new Reserva(id, cliente, quarto, checkIn);
        reservaDAO.salvar(reserva);
    }

    public List<Reserva> listarReservas() {
        return reservaDAO.listarTodas();
    }

    public void cancelarReserva(int id) {
        Reserva reserva = reservaDAO.buscarPorId(id);
        if (reserva != null) {
            reserva.cancelar();
        }
    }
}
