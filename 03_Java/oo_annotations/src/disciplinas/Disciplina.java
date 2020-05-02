package disciplinas;

import alunos.Aluno;
import alunos.ValidationException;
import professor.Professor;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private List<Aluno> alunos = new ArrayList<>();
    private Professor professor;

    public Disciplina(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
    }

    public static final byte LIMITE = 10;

    public void matricular(Aluno aluno) throws LimiteAlunosException {
        if(this.alunos.size()<LIMITE){
            this.alunos.add(aluno);
        }else{
            throw new LimiteAlunosException("Sem chances" + LIMITE);
        }
    }
    public void mostrarAlunos(){
        this.alunos.stream().forEach(aluno -> System.out.println(aluno.getNome()));
    }
}
