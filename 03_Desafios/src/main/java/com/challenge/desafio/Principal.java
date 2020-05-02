package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

import java.math.BigDecimal;

public class Principal {

    public static void main(String[] args) throws IllegalAccessException {

        Teste teste = new Teste();

        CalculadorDeClasses calcula = new CalculadorDeClasses();
        BigDecimal teste2 = calcula.somar(teste);
        System.out.println("RESULTADO " + teste2);
    }
}

