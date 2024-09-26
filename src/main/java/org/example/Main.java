package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
                //QUESTÃO 01
                //int INDICE = 13, SOMA = 0, K = 0;
                //while(K < INDICE){ K = K + 1; SOMA = SOMA + K; }
                //System.out.println(SOMA);
                //SOMA IGUAL A = 91

                //QUESTÃO 02
                Scanner teclado = new Scanner(System.in);
                System.out.println("Digite um número inteiro entre 0(zero) e 20(vinte): ");
                int numero = teclado.nextInt();
                CalcularFibonacci fibonacci = new CalcularFibonacci();
                fibonacci.verificarNumero(numero);

                //QUESTÃO 03
                ArrayList<Object> mesFaturamento = new ArrayList<>();
                mesFaturamento.addAll();
    }
}