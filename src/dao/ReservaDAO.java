package dao;

import java.util.ArrayList;
import java.util.List;
import model.Reserva;

public class ReservaDAO {
    private final List<Reserva> reservas = new ArrayList<>();

    public void salvar(Reserva reserva) {
        reservas.add(reserva);
    }

    public List<Reserva> listarTodas() {
        return reservas;
    }

    public Reserva buscarPorId(int id) {
        return reservas.stream()
                .filter(r -> r.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void remover(int id) {
        reservas.removeIf(r -> r.getId() == id);
    }
}
