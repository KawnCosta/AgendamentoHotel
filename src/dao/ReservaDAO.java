package dao;

import java.util.ArrayList;
import java.util.List;
import model.Reserva;

public class ReservaDAO {
    private List<Reserva> reservas = new ArrayList<>();

    public void salvar(Reserva reserva) {
        reservas.add(reserva);
    }

    public Reserva buscarPorId(int id) {
        for (Reserva r : reservas) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    public List<Reserva> listarTodas() {
        return reservas;
    }
}
