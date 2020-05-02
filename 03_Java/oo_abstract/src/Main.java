import alunos.Student;
import alunos.ValidationException;
import diretor.Diretor;
import professor.Professor;
import usuario.UsuarioAutorizavel;

public class Main {
    public static void main(String[] args) throws ValidationException {
        //Student st1 = new Student();
        //try {
        //    st1.setLogin("havyx_");
        //} catch (ValidationException e) {
            //System.out.println(e.getMessage());
            //   e.printStackTrace();
        //}
        //System.out.println(st1.getLogin());
        //st1.setCpf("08945612392");
        //System.out.println(st1.getCpf());
        //System.out.println(st1);

        UsuarioAutorizavel usuario = new Professor("Jorge", "25825825885", "Jorge");
        System.out.println(usuario.temAuth());
        UsuarioAutorizavel usuario2 = new Diretor("Jorge", "25825825885", "Jorge");
        System.out.println(usuario2.temAuth());

    }
}
