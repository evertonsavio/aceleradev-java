package professor;

import alunos.ValidationException;
import usuario.Usuario;
import usuario.UsuarioAutorizavel;

import java.util.Arrays;
import java.util.List;

public class Professor extends UsuarioAutorizavel {

    public Professor(String login, String cpf, String nome) throws ValidationException {
        super(login, cpf, nome);
    }

    @Override
    protected List<String> getAutorizacoes() {
        return Arrays.asList("PROF");
    }

    @Override
    protected boolean verificarAutorizacaoLogin() {
        return false;
    }


}
