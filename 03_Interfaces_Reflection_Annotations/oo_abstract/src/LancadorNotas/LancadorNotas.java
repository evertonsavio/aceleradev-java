package LancadorNotas;

import alunos.Aluno;
import professor.Professor;
import usuario.Usuario;
import usuario.UsuarioAutorizavel;

public class LancadorNotas {

    public void login(UsuarioAutorizavel userAuth){
        boolean hasAuth = userAuth.temAuth();
        if(hasAuth){
            System.out.println("Usuario tem autorizacao!");
        }
    }
}
