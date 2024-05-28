package users;

import Exceptions.IdLenNotMatchException;

public class Master extends User {
    public Master(String name, String lastname, String username, String password, String email, String phoneNumber, String id) throws IdLenNotMatchException {
        super(name, lastname, username, password, email, phoneNumber, id);
        if(id.length() != 10)throw new IdLenNotMatchException();
    }
}