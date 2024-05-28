package users;

import Exceptions.*;
import Exeptions.PasswordException;
import Exeptions.PhoneNumberException;
import Exeptions.UsernameException;
import Exeptions.emailException;

import java.util.regex.Pattern;

public class Master extends User {
    String field;
    public Master(String name, String lastname, String field, String username, String password, String email, String phoneNumber, String id) throws IdLenNotMatchException, FieldExeption, PasswordException, PhoneNumberException, NameException, UsernameException, LastNameException, emailException, IdException {
        super(name, lastname, username, password, email, phoneNumber, id);
        if (field.length() < 19 && Pattern.matches("[a-zA-Z]", field))
            this.field = field;
        else
            throw new FieldExeption();
        if(id.length() != 6)throw new IdLenNotMatchException();
    }

    protected String getField() {
        return field;
    }

    protected void setField(String field) throws FieldExeption {
        if (field.length() < 19 && Pattern.matches("[a-zA-Z]", field))
            this.field = field;
        else
            throw new FieldExeption();
    }
}
