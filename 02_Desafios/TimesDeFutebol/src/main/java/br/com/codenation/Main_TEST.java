package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main_TEST {
    public static void main(String[] args) {
        DesafioMeuTimeApplication desafio = new DesafioMeuTimeApplication();
        desafio.incluirTime(1L, "HavyxTeam", LocalDate.now(),"Yeallow", "Black" );
        desafio.incluirTime(2L, "HavyxTeam", LocalDate.now(),"Yeallow", "Black" );
        desafio.incluirTime(3L, "HavyxTeam", LocalDate.now(),"Yeallow", "Black" );
        desafio.incluirJogador(1L,3L, "Savio", LocalDate.now(), 10, BigDecimal.valueOf(999999));
        desafio.incluirJogador(2L,3L, "Joao", LocalDate.now(), 100, BigDecimal.valueOf(999999));
        desafio.incluirJogador(3L,2L, "Silvio", LocalDate.now(), 101, BigDecimal.valueOf(999999));
        desafio.definirCapitao(2L);
        System.out.println(desafio.buscarCapitaoDoTime(3L));
        System.out.println(desafio.buscarJogadoresDoTime(3L));
        System.out.println(desafio.buscarMelhorJogadorDoTime(3L));
        desafio.buscarJogadorMaisVelho(3L);
        System.out.println(desafio.buscarTimes());
        System.out.println(desafio.buscarTopJogadores(1));

    }
}

