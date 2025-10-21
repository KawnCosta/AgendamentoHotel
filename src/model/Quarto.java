package model;

public abstract class Quarto {
    protected int numero;
    protected double valorBase;

    public Quarto(int numero, double valorBase) {
        this.numero = numero;
        this.valorBase = valorBase;
    }

    public int getNumero() {
        return numero;
    }

    public abstract double calcularDiaria();
}
