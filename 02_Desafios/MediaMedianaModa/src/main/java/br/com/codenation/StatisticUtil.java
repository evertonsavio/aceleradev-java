package br.com.codenation;

import java.util.Arrays;
import java.util.OptionalDouble;

public class StatisticUtil {

	public static int average(int[] elements) {
		/////////////////////////////TECNICA SIMPLES//////////////////////////////////
		//Integer total = 0;
		//for(Integer element: elements){
		//	total += element;
		//}
		//Integer media = total/elements.length;
		/////////////////////////FIM TECNICA SIMPLES//////////////////////////////////

		////////////////////////TECNICA JAVA8 REDUCE//////////////////////////////////
		Integer soma = Arrays.stream(elements).reduce(0,Soma::add);
		Integer media = soma/elements.length;
		/////////////////////FIM TECNICA JAVA8 REDUCE/////////////////////////////////

		/////////////////////TECNICA JAVA8 OPTIONALDOUBLE/////////////////////////////
		//OptionalDouble media = Arrays.stream(elements).average();
		//return media.getAsDouble();
		////////////////////FIM TECNICA JAVA8 OPTIONALDOUBLE//////////////////////////

		return media;
	}

	public static int mode(int[] elements) {
		int contadorModa = 0;
		int contadorTemp = 0;
		int moda = 0;

		for (Integer valorTeste: elements){
			contadorTemp = 0;
			for(Integer valor: elements){
				if(valorTeste == valor){
					contadorTemp ++;
				}
			}
			if(contadorTemp > contadorModa){
				contadorModa = contadorTemp;
				moda = valorTeste;
			}
		}

		return moda;
	}

	public static int median(int[] elements) {
		Arrays.sort(elements);
		if(elements.length==0){//LISTA VAZIA
			System.out.println("Sem mediana, tamanho do array = zero");
			return 0;
		}
		if(elements.length%2==0){//QUANTIDADE PAR DE ELEMENTOS
			Integer meio1 = elements[(elements.length/2)-1];
			Integer meio2 = elements[elements.length/2];
			Integer media = (meio1+meio2)/2;
			return media;
		}
		else{//QUANTIDADE IMPAR DE ELEMENTOS -> A MEDIANA DA CODENATION TA VALIDANDO DE FORMA ERRADA.
			Integer meio = elements[(elements.length/2)]; //SOMAR 1, -------> [(elements.length/2)+1]
			return meio;
		}
	}
}