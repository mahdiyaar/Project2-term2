import Exceptions.NameException;
import Exceptions.*;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class User  {
    private String name,lastname,field;
    private String username,password,email, phoneNumber;
    private int id;
    private static ArrayList<Static_Atribute> static_atributes=new ArrayList<>();
    private boolean staticatribute[]=new boolean[4];


    public User(String name, String lastname, String field, String username, String password, String email, String phoneNumber,int id) throws NameException, LastNameException, FieldExeption, IdException {
        for (int i = 0; i < 4; i++) {
            staticatribute[i] = true;
        }
        if (name.length() < 19 && Pattern.matches("[a-zA-Z]", name))
            this.name = name;
        else
            throw new NameException();
        if (lastname.length() < 19 && Pattern.matches("[a-zA-Z]", lastname))
            this.lastname = lastname;
        else
            throw new LastNameException();
        if (field.length() < 19 && Pattern.matches("[a-zA-Z]", field))
            this.field = field;
        else
            throw new FieldExeption();
        for (int i = 0; i < static_atributes.size(); i++) {
            if (username == static_atributes.get(i).getUsername()) {
                staticatribute[0] = false;
                break;
            }
            if (id == static_atributes.get(i).getId()) {
                staticatribute[1] = false;
                break;
            }
            if (email == static_atributes.get(i).getEmail()) {
                staticatribute[2] = false;
                break;
            }
            if (phoneNumber == static_atributes.get(i).getPhoneNumber()) {
                staticatribute[3] = false;
                break;
            }
        }
        if (staticatribute[0] && username.length() > 4 && username.length() < 13)
            this.username = username;
        else
            throw new RuntimeException();

        if (staticatribute[1])
            this.id = id;
        else
            throw new IdException();
        if (staticatribute[2]) {
            String p1, p2, p3;
            p1 = email.substring(0,email.indexOf('@'));
            p2= email.substring(email.indexOf('@')+1,email.indexOf('.'));
            p3= email.substring(email.indexOf('.')+1);
            if (Pattern.matches("[a-zA-Z0-9\\.]+",p1)&&p1.length()<19&&Pattern.matches("[a-z\\.-]+",p2)&&p2.length()<9&&Pattern.matches("[a-z]+",p3)&&p3.length()<4)
                this.email = email;
            else
                throw new emailException();
        }
        else
            throw new emailException();
        if(staticatribute[3]&&phoneNumber.charAt(0)=='0'&&phoneNumber.charAt(1)=='9')
            this.phoneNumber = phoneNumber;
        else
            throw new emailException();
    }
}
