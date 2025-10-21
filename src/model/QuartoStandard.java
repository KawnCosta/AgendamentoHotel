package model;

public class QuartoStandard extends Quarto {
    public QuartoStandard(int numero) {
        super(numero);
    }

    @Override
    public double calcularTarifa() {
        return 200.0;
    }
}
