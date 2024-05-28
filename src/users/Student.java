package users;

import Exceptions.*;
import Exeptions.PasswordException;
import Exeptions.PhoneNumberException;
import Exeptions.UsernameException;
import Exeptions.emailException;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Student extends User {
    private String field;
    private ArrayList<classes> classes =new ArrayList<classes>();
    private ArrayList<leasonpage> leasonpages =new ArrayList<leasonpage>();
    private ArrayList<>
    public Student(String name, String lastname, String field, String username, String password, String email, String phoneNumber, String id) throws IdLenNotMatchException, FieldExeption, PasswordException, PhoneNumberException, NameException, UsernameException, LastNameException, emailException, IdException {
        super(name, lastname, username, password, email, phoneNumber, id);
        if (field.length() < 19 && Pattern.matches("[a-zA-Z]", field))
            this.field = field;
        else
            throw new FieldExeption();
        if(id.length() != 10)throw new IdLenNotMatchException();
    }

    public String getField() {
        return field;
    }

    private void setField(String field) throws FieldExeption {
        if (field.length() < 19 && Pattern.matches("[a-zA-Z]", field))
            this.field = field;
        else
            throw new FieldExeption();
    }

    @Override
    protected void Showlist() {
        super.Showlist();
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        if(a==1){
            for (int i = 0; i < classes.size(); i++) {
                classes.get(i).toString();
            }
            Showlist();
        } else if (a==2) {
            for (int i = 0; i < leasonpages.size(); i++) {
                leasonpages.get(i).toString();
            }
            Showlist();
        }else if (a==3) {
            for (int i = 0; i < leasonpages.size(); i++) {
                .get(i).toString();
            }
            Showlist();
        }
    }
}
