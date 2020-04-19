package br.com.codenation.calculadora;

public class Principal {

    public static void main(String[] args) {

        CalculadoraSalario Calc = new CalculadoraSalario();
        double resultado = Calc.calcularSalarioLiquido(10000);
        System.out.println(resultado);

    }

}
