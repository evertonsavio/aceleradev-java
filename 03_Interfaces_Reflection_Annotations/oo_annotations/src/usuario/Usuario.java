package usuario;

import alunos.ValidationException;

public class Usuario implements UsuarioAutorizavel {
    private String login;
    private String cpf;
    private String nome;

    public Usuario(String login, String cpf, String nome) throws ValidationException {
        this.login = login;
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setLogin(String login) throws ValidationException {
        if (validarLogin(login)){
            this.login = login;
        }else{
            throw new ValidationException("Login Invalido");
        }
    }

    public void setCpf(String cpf) {
        if (validarCpf(cpf)) {
            this.cpf = cpf;
        }else{
            System.out.println("CPF invalido");
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    private boolean validarLogin(String login){
        return login != null && !login.isEmpty() && login.length() > 4 && login.length() <20;
    }
    protected boolean validarCpf(String cpf){
        return cpf != null && !cpf.isEmpty() && cpf.length() == 11;
    }

    @Override
    public boolean temAutorizacao() {
        return false;
    }
}


