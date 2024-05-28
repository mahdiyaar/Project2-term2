import Exceptions.IdLenNotMatchException;
import users.Student;

public class Main {
    public static void main(String[] args) {
        Student s = null;
        try{
            s = new Student("hadi", "sharghi", "comp","asdfg", "123", "hadisharghi84@gmail.com", "09944367463", "40212623350");

        } catch (IdLenNotMatchException e) {
            System.out.println(e.fillInStackTrace());
        }
        System.out.println(s);
    }
}