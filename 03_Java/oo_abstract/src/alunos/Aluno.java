package alunos;

import usuario.Usuario;

public class Aluno extends Usuario {

    private Integer numeroMatricula;

    public Aluno(String login, String cpf, String nome) throws ValidationException {
        super(login, cpf, nome);
        //validarCpf(cpf);
    }

    public Integer getNumeroMatricula() {
        return numeroMatricula;
    }


    public void setNumeroMatricula(Integer numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }
}
