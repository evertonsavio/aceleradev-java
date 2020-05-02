package diretor;

import alunos.ValidationException;
import usuario.Usuario;
import usuario.UsuarioAutorizavel;

public class Diretor extends Usuario implements UsuarioAutorizavel {

    public Diretor(String login, String cpf, String nome) throws ValidationException {
        super(login, cpf, nome);
    }

    @Override
    public boolean temAutorizacao() {
        return true;
    }
}
