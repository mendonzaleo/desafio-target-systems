package org.example;

public class FaturamentoDoDia {
    int dia;
    double valor;

    public FaturamentoDoDia(int dia, double valor) {
        this.dia = dia;
        this.valor = valor;
    }

    public int getDia() {
        return dia;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Faturamento do " + "dia= " + dia + ", valor= " + valor;
    }
}
