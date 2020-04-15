package br.com.tarefas;

import java.util.ArrayList;

public class ListaTarefas {

    ArrayList<Tarefa> tarefas =  new ArrayList<>();

    public void adicionar(Tarefa tarefa){
        if (tarefa!= null && tarefa.obterTamanho() <= 20){
            this.tarefas.add(tarefa);
        }else{
            System.out.println("Tarefa Invalida");
        }

    }
    public void remover (int posicao){
        if (posicao < this.tarefas.size()){
            this.tarefas.remove(posicao);
        }else{
            System.out.println("Essa posicao nao existe Sr.");
        }
    }
    public void remover (Tarefa tarefa){
        this.tarefas.remove(tarefa);
    }

    public Tarefa buscar(String descricao){
        for(Tarefa tarefa: tarefas){
            if (descricao.equals(tarefa.descricao)){
                return tarefa;
            }
        }
        System.out.println("Tarefa nao encontrada");
        return null;
    }

    public void exibirTarefas(){
        for(Tarefa tarefa: tarefas){
            tarefa.exibirTarefa();
        }
    }

}
