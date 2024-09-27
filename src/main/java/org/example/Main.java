package org.example;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Main {
    public static void main(String[] args) {
//        QUESTÃO 01
        System.out.println("Questão 01");
        int INDICE = 13, SOMA = 0, K = 0;
        while(K < INDICE){ K = K + 1; SOMA = SOMA + K; }
        System.out.println("A soma é " + SOMA);
//        SOMA IGUAL A = 91

//        QUESTÃO 02
        System.out.println("Questão 02");
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite um número inteiro entre 0(zero) e 20(vinte): ");
        int numero = teclado.nextInt();
        CalcularFibonacci fibonacci = new CalcularFibonacci();
        fibonacci.verificarNumero(numero);

//        QUESTÃO 03
        System.out.println("Questão 03");
        Gson gson = new Gson();
        List<FaturamentoDoDia> listaDeDias = new ArrayList<>();
        try {
            FileReader reader = new FileReader("src/main/resources/FaturamentoPorDia.json");
            Type pessoaListType = new TypeToken<List<FaturamentoDoDia>>() {}.getType();
            listaDeDias = gson.fromJson(reader, pessoaListType);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<FaturamentoDoDia> listaSemDiasZerados = listaDeDias.stream()
                .filter(valor -> valor.getValor() > 0)
                .toList();

        Optional<FaturamentoDoDia> menorValor = listaSemDiasZerados.stream()
                .min(Comparator.comparingDouble(FaturamentoDoDia::getValor));

        Optional<FaturamentoDoDia> maiorValor = listaSemDiasZerados.stream()
                .max(Comparator.comparingDouble(FaturamentoDoDia::getValor));

        double somaFaturamento = listaSemDiasZerados.stream()
                .mapToDouble( FaturamentoDoDia::getValor)
                .sum();

        double diasComFaturamento = listaSemDiasZerados.stream()
                .count();

        double mediaFaturamentoPorDia = somaFaturamento / diasComFaturamento;

        long diasAcimaDaMedia = listaSemDiasZerados.stream()
                .filter(f -> f.getValor() > mediaFaturamentoPorDia)
                .count();

//        IMPRIME O DIA COM O MENOR FATURAMENTO E O VALOR
        System.out.println("O dia com menor faturamento foi o dia " + menorValor.get().getDia() + " com o valor R$" + menorValor.get().getValor());
//        IMPRIME O DIA COM O MAIOR FATURAMENTO E O VALOR
        System.out.println("O dia com maior faturamento foi o dia " + maiorValor.get().getDia() + " com o valor R$" + maiorValor.get().getValor());
//        IMPRIME A MÉDIA MENSAL E QUANTOS DIAS TIVERAM UM VALOR SUPERIOR A ESSA MÉDIA
        System.out.println("A média mensal é de R$" + String.format("%.2f", mediaFaturamentoPorDia));
        System.out.println(diasAcimaDaMedia + " dias tiveram um faturamento acima dessa média mensal.");


//        QUESTÃO 04
        System.out.println("Questão 04");
        double sp = 67836.43, rj = 36678.66, mg = 29229.88, es = 27165.48, outros = 19849.53;
        List<String> estados = Arrays.asList("SP", "RJ", "MG", "ES", "Outros");
        List<Double> faturamentos = Arrays.asList(67836.43, 36678.66, 29229.88, 27165.48, 19849.53);

        double faturamentoTotal = faturamentos.stream().mapToDouble(Double::doubleValue).sum();

        for(int i = 0; i < estados.size(); i++){
            double percentual = (faturamentos.get(i) / faturamentoTotal) * 100;
            System.out.println("Percentual de " + estados.get(i) + " é igual a: " + String.format("%.2f", percentual) + "%");
        }

//        QUESTÃO 05
        System.out.println("Questão 05");
        System.out.println("Digite uma palavra que terá os caracteres invertidos.");
        teclado.nextLine();
        String palavra = teclado.nextLine();

        List<Character> listaDeCaracteres = palavra.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        List<Character> caracteresInvertidos = new ArrayList<>();
        for(int i = 0; i < listaDeCaracteres.size(); i++){
            caracteresInvertidos.add(listaDeCaracteres.get(listaDeCaracteres.size() - i - 1));
        }
        String palavraInvertida = caracteresInvertidos.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(palavraInvertida);
    }
}