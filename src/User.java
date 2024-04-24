import java.util.regex.Pattern;

public class User {
    private String name,lastname,field;
    private String username,password,email, phoneNumber;

    static A

    public User(String name, String lastname, String field, String username, String password, String email, String phoneNumber) {
        if(name.length()<19&& Pattern.matches("[a-zA-Z]",name))
            this.name = name;
        else
            throw new RuntimeException("this name is incorrect");
        if(name.length()<19&& Pattern.matches("[a-zA-Z]",lastname))
            this.lastname = lastname;
        else
            throw new RuntimeException("this lastname is incorrect");
        if(name.length()<19&& Pattern.matches("[a-zA-Z]",lastname))
            this.field = field;
        else
            throw new RuntimeException("this field is incorrect");
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
