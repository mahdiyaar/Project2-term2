package users;

import Exceptions.*;





public class Employee extends User {
    public Employee(String name, String lastname, String username, String password, String email, String phoneNumber, String id)
            throws IdLenNotMatchException, PasswordException, PhoneNumberException, NameException, UsernameException, LastNameException, emailException, IdRepeatedException {
        super(name, lastname, username, password, email, phoneNumber, id);
        if(id.length() != 4)throw new IdLenNotMatchException("len of id must be 4 digits");
    }
}
