package users;

import Exceptions.*;
import Exeptions.PasswordException;
import Exeptions.PhoneNumberException;
import Exeptions.UsernameException;
import Exeptions.emailException;

public class Employee extends User {
    public Employee(String name, String lastname, String username, String password, String email, String phoneNumber, String id) throws IdLenNotMatchException, PasswordException, PhoneNumberException, NameException, UsernameException, LastNameException, emailException, IdException {
        super(name, lastname, username, password, email, phoneNumber, id);
        if(id.length() != 4)throw new IdLenNotMatchException();
    }
}
