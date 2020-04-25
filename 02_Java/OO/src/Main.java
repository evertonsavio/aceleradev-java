import alunos.Student;
import alunos.ValidationException;

public class Main {
    public static void main(String[] args) {
        Student st1 = new Student();
        try {
            st1.setLogin("havyx");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println(st1.getLogin());
        st1.setCpf("08945612392");
        System.out.println(st1.getCpf());
        System.out.print(st1);
    }
}
