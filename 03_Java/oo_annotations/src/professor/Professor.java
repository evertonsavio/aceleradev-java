package professor;

import alunos.ValidationException;
import usuario.Usuario;
import usuario.UsuarioAutorizavel;

public class Professor extends Usuario implements UsuarioAutorizavel {

    public Professor(String login, String cpf, String nome) throws ValidationException {
        super(login, cpf, nome);
    }

    @Override
    public boolean temAutorizacao() {
        return true;
    }
}
