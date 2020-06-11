package alunos;

public class Student {
    private String login;
    private String cpf;
    private String nome;

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
    private boolean validarCpf(String cpf){
    return cpf != null && !cpf.isEmpty() && cpf.length() == 11;
    }
    @Override
    public String toString(){
        return  "nome: " + this.nome + " cpf: " + this.cpf;
    }

}
