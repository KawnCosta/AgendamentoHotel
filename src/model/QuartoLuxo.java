package model;

public class QuartoLuxo extends Quarto {

    public QuartoLuxo(int numero) {
        super(numero, 250.0);
    }

    @Override
    public double calcularDiaria() {
        return valorBase * 1.2;
    }

    @Override
    public String toString() {
        return "Luxo - Nº " + numero;
    }
}
