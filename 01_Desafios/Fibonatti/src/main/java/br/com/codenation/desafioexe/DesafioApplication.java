package br.com.codenation.desafioexe;

import br.com.codenation.desafioexe.lista.Fibonacci;

import java.util.List;


public class DesafioApplication {

	public static void main(String[] args) {
		Fibonacci Fib = new Fibonacci();
		List result = Fib.fibonacci();
		System.out.println(result);
		System.out.println(Fib.isFibonacci(234));
	}

}