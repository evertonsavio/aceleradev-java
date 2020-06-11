package professor;

import alunos.ValidationException;
import usuario.Usuario;

public class Professor extends Usuario {

    public Professor(String login, String cpf, String nome) throws ValidationException {
        super(login, cpf, nome);
    }
}
