import Exceptions.IdLenNotMatchException;

import java.util.regex.Pattern;


public class Student extends User{
    String field;
    public Student(String name, String lastname, String field, String username, String password, String email, String phoneNumber, String id) throws IdLenNotMatchException {
        super(name, lastname, username, password, email, phoneNumber, id);
        if(field.length()<19&& Pattern.matches("[a-zA-Z]+",field))
            this.field = field;
        else
            throw new RuntimeException("this field is incorrect");
        if(id.length() != 10)throw new IdLenNotMatchException();
    }
}
