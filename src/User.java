import java.util.ArrayList;
import java.util.regex.Pattern;

public class User {
    private String name,lastname,field;
    private String username,password,email, phoneNumber;
    private int id;

    private static ArrayList<Static_Atribute> static_atributes=new ArrayList<>();
    private boolean staticatribute[]=new boolean[4];


    public User(String name, String lastname, String field, String username, String password, String email, String phoneNumber,int id) {
        for (int i = 0; i < 4; i++) {
            staticatribute[i]=true;
        }
        if(name.length()<19&& Pattern.matches("[a-zA-Z]",name))
            this.name = name;
        else
            throw new RuntimeException("this name is incorrect");
        if(name.length()<19&& Pattern.matches("[a-zA-Z]",lastname))
            this.lastname = lastname;
        else
            throw new RuntimeException("this lastname is incorrect");
        if(name.length()<19&& Pattern.matches("[a-zA-Z]",field))
            this.field = field;
        else
            throw new RuntimeException("this field is incorrect");
        for (int i = 0; i < static_atributes.size(); i++) {

        }
        for (int i = 0; i < static_atributes.size(); i++) {
            if(username==static_atributes.get(i).getUsername()) {
                staticatribute[0] = false;
                break;
            }
            if(id==static_atributes.get(i).getId()){
                staticatribute[1] = false;
                break;
            }
            if(email==static_atributes.get(i).getEmail()){
                staticatribute[2]=false;
                break;
            }
            if(phoneNumber==)
        }
        if()
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
