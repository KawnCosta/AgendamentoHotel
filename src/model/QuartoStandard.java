package model;

public class QuartoStandard extends Quarto {

    public QuartoStandard(int numero) {
        super(numero, 150.0);
    }

    @Override
    public double calcularDiaria() {
        return valorBase;
    }

    @Override
    public String toString() {
        return "Standard - Nº " + numero;
    }
}
