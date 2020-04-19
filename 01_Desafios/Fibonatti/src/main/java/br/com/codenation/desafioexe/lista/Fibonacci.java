package br.com.codenation.desafioexe.lista;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    List<Integer> lista = new ArrayList();

    public List<Integer> fibonacci() {

        System.out.println("Acessando classe Fibonatti");

        int a = 0;
        int b = 1;
        int resultado = 0;
        lista.add(a);
        lista.add(b);

        do{
            resultado = a + b;
            a = b;
            b = resultado;
            if(resultado>350){ break; }
            lista.add(resultado);
        }while(resultado <= 350);

        return lista;
    }
    public Boolean isFibonacci(Integer a) {

        for(int i=0;i<lista.size();i++){
            System.out.println(lista.get(i));
            int score = lista.get(i);
            if (a == score) {
                System.out.println(lista.get(i));
                return true;
            }
        }
        return false;
    }

}
