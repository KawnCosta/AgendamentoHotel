package controller;

import dao.ReservaDAO;
import java.time.LocalDate;
import model.*;
import util.DataUtils;

public class ReservaController {
    private ReservaDAO reservaDAO = new ReservaDAO();

    public void criarReserva(int id, String nome, String documento, String tipoQuarto, String dataStr) throws Exception {
        // Validações
        if (reservaDAO.buscarPorId(id) != null) {
            throw new Exception("ID de reserva já existe.");
        }

        if (documento.length() != 11) {
            throw new Exception("Documento inválido. Deve conter 11 dígitos numéricos.");
        }

        if (!tipoQuarto.equalsIgnoreCase("standard") && !tipoQuarto.equalsIgnoreCase("luxo")) {
            throw new Exception("Tipo de quarto inválido. Use 'standard' ou 'luxo'.");
        }

        boolean clienteComReserva = reservaDAO.listarTodas().stream()
                .anyMatch(r -> r.getCliente().getDocumento().equals(documento)
                        && r.getStatus() == StatusReserva.CONFIRMADO);
        if (clienteComReserva) {
            throw new Exception("Cliente já possui uma reserva ativa.");
        }

        // Data
        LocalDate dataCheckIn;
        try {
            dataCheckIn = DataUtils.parse(dataStr);
        } catch (Exception e) {
            throw new Exception("Data inválida. Use o formato dd/MM/yyyy.");
        }

        // Quarto
        Quarto quarto;
        if (tipoQuarto.equalsIgnoreCase("standard")) {
            quarto = new QuartoStandard(id);
        } else {
            quarto = new QuartoLuxo(id);
        }

        // Reserva
        Cliente cliente = new Cliente(nome, documento);
        Reserva reserva = new Reserva(id, cliente, quarto, dataCheckIn, StatusReserva.CONFIRMADO);
        reservaDAO.salvar(reserva);
    }

    public java.util.List<Reserva> listarReservas() {
        return reservaDAO.listarTodas();
    }
}
