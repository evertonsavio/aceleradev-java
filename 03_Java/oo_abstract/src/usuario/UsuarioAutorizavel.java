package usuario;

import alunos.ValidationException;

import java.util.List;

public abstract class UsuarioAutorizavel extends Usuario{

    public UsuarioAutorizavel(String login, String cpf, String nome) throws ValidationException {
        super(login, cpf, nome);
    }

    public boolean temAuth(){
        List<String> autorizacoes = getAutorizacoes();
        return autorizacoes.contains("ADMIN") || verificarAutorizacaoLogin();
    }

    protected abstract List<String > getAutorizacoes();

    protected abstract boolean verificarAutorizacaoLogin();

}
