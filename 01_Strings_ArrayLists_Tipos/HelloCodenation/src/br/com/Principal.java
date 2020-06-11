package br.com;

import br.com.tarefas.ArrayTarefas;
import br.com.tarefas.ListaTarefas;
import br.com.tarefas.Tarefa;

public class Principal {

    public static void main(String[] args) {
        System.out.println("TO DO LIST");

        ListaTarefas tarefas = new ListaTarefas();
        Tarefa tarefa1 = new Tarefa("Regar Plantas logo depois da hora do jantar");
        Tarefa tarefa2 = new Tarefa("Estudar");
        Tarefa tarefa3 = new Tarefa("Relaxar");

        tarefas.adicionar(tarefa1);
        tarefas.adicionar(tarefa2);
        tarefas.adicionar(tarefa3);
        System.out.println("---------------");
        System.out.println("Minhas Tarefas");
        Tarefa tarefa =  tarefas.buscar("Estudar");
        tarefa.exibirTarefa();
        System.out.println("---------------");
        tarefas.remover(tarefa3);
        //tarefas.remover(0);
        System.out.println("---------------");
        System.out.println("Minhas Tarefas apos remover");
        tarefas.exibirTarefas();

        //tarefa1.exibirTarefa();
        //System.out.println("A tarefa " + tarefa1.obterTamanho() + " caracteres");
    }

}
