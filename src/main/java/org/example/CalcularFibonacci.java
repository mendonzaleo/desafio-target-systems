package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CalcularFibonacci {
        public void verificarNumero(int numero){
            List<Integer> fibonacci = new ArrayList<>(101);
            if(numero >= 0 && numero <= 20){
                fibonacci.add(0);
                fibonacci.add(1);
                for (int i = 2; i < 20; i++){
                    int proximoNumero = fibonacci.get(i - 1) + fibonacci.get(i - 2);
                    fibonacci.add(proximoNumero);
                }
            }else{
                System.out.println("Número informado fora do intervalo solicitado.");
            }
            Optional<Integer> resposta = fibonacci.stream().
                    filter(n -> n == numero)
                    .findFirst();
            if(resposta.isPresent()) {
                System.out.println(fibonacci);
                System.out.println("Número " + resposta.get() + " está presente na sequência de Fibonacci!");
            }

        }

}
