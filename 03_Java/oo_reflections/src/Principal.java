import alunos.Aluno;
import alunos.ValidationException;
import disciplinas.Disciplina;
import disciplinas.LimiteAlunosException;
import professor.Professor;
import usuario.repositorios.RepositorioUsuario;

public class Principal{
    public static void main(String[] args) {
        Professor professor = null;
        RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
        try {
            professor = new Professor("professor", "04585245852", "teste da sukti");
            Disciplina disciplina = new Disciplina("Matematica", professor);
            repositorioUsuario.add(professor);
            System.out.println(repositorioUsuario.search("04585245852"));

            //disciplina.matricular(new Aluno("havyx", "09809809898", "savio"));
            //disciplina.mostrarAlunos();
        } catch (ValidationException e) {
            e.printStackTrace();
        }


    }
}