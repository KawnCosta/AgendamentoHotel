package model;

public class QuartoLuxo extends Quarto {
    public QuartoLuxo(int numero) {
        super(numero);
    }

    @Override
    public double calcularTarifa() {
        return 350.0;
    }
}
