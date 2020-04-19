package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {

		List<Integer> lista = new ArrayList();

		int a = 0, b = 1, resultado = 0;
		lista.add(a);
		lista.add(b);

		do{
			resultado = a + b;
			a = b;
			b = resultado;
			lista.add(resultado);
		}while(resultado <= 350);

		return lista;
	}

	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}
}