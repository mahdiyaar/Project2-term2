package users;

import Exceptions.IdException;
import Exceptions.LastNameException;
import Exceptions.NameException;
import Exceptions.emailException;
import Exceptions.PasswordException;
import Exceptions.PhoneNumberException;
import Exceptions.UsernameException;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Pattern;

public class User {
    private String name, lastname;
    private String username, password, email, phoneNumber;
    private String id;
    private static ArrayList<Static_Atribute> static_atributes = new ArrayList<>();
    private boolean staticatribute[] = new boolean[4];

    public static ArrayList<User> users = new ArrayList<User>();

    public User(String name, String lastname, String username, String password, String email, String phoneNumber, String id)
            throws NameException, LastNameException, IdException, UsernameException, PasswordException, emailException, PhoneNumberException {
        for (int i = 0; i < 4; i++) {
            staticatribute[i] = true;
        }
        if (name.length() < 19 && Pattern.matches("[a-zA-Z]+", name))
            this.name = name;
        else
            throw new NameException();
        if (lastname.length() < 19 && Pattern.matches("[a-zA-Z]+", lastname))
            this.lastname = lastname;
        else
            throw new LastNameException();

        for (int i = 0; i < static_atributes.size(); i++) {
            if (Objects.equals(username, static_atributes.get(i).getUsername())) {
                staticatribute[0] = false;
                break;
            }
            if (Objects.equals(id, static_atributes.get(i).getId())) {
                staticatribute[1] = false;
                break;
            }
            if (Objects.equals(email, static_atributes.get(i).getEmail())) {
                staticatribute[2] = false;
                break;
            }
            if (Objects.equals(phoneNumber, static_atributes.get(i).getPhoneNumber())) {
                staticatribute[3] = false;
                break;
            }
        }
        if (staticatribute[0] && username.length() > 4 && username.length() < 13&Pattern.matches("[a-zA-Z0-9]+", username))
            this.username = username;
        else
            throw new UsernameException();
        if (password.length() > 7 && password.length() < 13&&Pattern.matches("[a-zA-Z0-9]+", password))
            this.password = password;
        else
            throw new PasswordException();
        if (staticatribute[1])
            this.id = id;
        else
            throw new IdException();
        if (staticatribute[2]) {
            String p1, p2, p3;
            p1 = email.substring(0, email.indexOf('@'));
            p2 = email.substring(email.indexOf('@') + 1, email.indexOf('.'));
            p3 = email.substring(email.indexOf('.') + 1);
            if (Pattern.matches("[a-zA-Z0-9\\.]+", p1) && p1.length() < 19 && Pattern.matches("[a-z\\.-]+", p2) && p2.length() < 9 && Pattern.matches("[a-z]+", p3) && p3.length() < 4)
                this.email = email;
            else
                throw new emailException();
        } else
            throw new emailException();
        if (staticatribute[3] && phoneNumber.charAt(0) == '0' && phoneNumber.charAt(1) == '9')
            this.phoneNumber = phoneNumber;
        else
            throw new PhoneNumberException();
    }

    protected String getLastname() {
        return lastname;
    }

    protected void setLastname(String lastname) throws LastNameException {
        if (lastname.length() < 19 && Pattern.matches("[a-zA-Z]", lastname))
            this.lastname = lastname;
        else
            throw new LastNameException();
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) throws NameException {
        if (name.length() < 19 && Pattern.matches("[a-zA-Z]", name))
            this.name = name;
        else
            throw new NameException();
    }



    public String getUsername() {
        return username;
    }

    protected void setUsername(String username) throws UsernameException {
        staticatribute[0] = true;
        for (int i = 0; i < static_atributes.size(); i++) {
            if (Objects.equals(username, static_atributes.get(i).getUsername())) {
                staticatribute[0] = false;
                break;
            }
        }
        if (staticatribute[0] && username.length() > 4 && username.length() < 13&Pattern.matches("[a-zA-Z0-9]+", username))
            this.username = username;
        else
            throw new UsernameException();
    }

    protected String getPassword() {
        return password;
    }

    protected void setPassword(String password) throws PasswordException {
        if (password.length() > 7 && password.length() < 13&&Pattern.matches("[a-zA-Z0-9]+", password))
            this.password = password;
        else
            throw new PasswordException();
    }

    protected String getEmail() {
        return email;
    }

    protected void setEmail(String email) throws emailException {
        staticatribute[2] = true;
        for (int i = 0; i < static_atributes.size(); i++) {
            if (Objects.equals(email, static_atributes.get(i).getEmail())) {
                staticatribute[2] = false;
                break;
            }
        }
        if (staticatribute[2]) {
            String p1, p2, p3;
            p1 = email.substring(0, email.indexOf('@'));
            p2 = email.substring(email.indexOf('@') + 1, email.indexOf('.'));
            p3 = email.substring(email.indexOf('.') + 1);
            if (Pattern.matches("[a-zA-Z0-9\\.]+", p1) && p1.length() < 19 && Pattern.matches("[a-z\\.-]+", p2) && p2.length() < 9 && Pattern.matches("[a-z]+", p3) && p3.length() < 4)
                this.email = email;
            else
                throw new emailException();
        } else
            throw new emailException();
    }

    protected String getPhoneNumber() {
        return phoneNumber;
    }

    protected void setPhoneNumber(String phoneNumber) throws PhoneNumberException {
        staticatribute[3]=true;
        for (int i = 0; i < static_atributes.size(); i++) {
            if (Objects.equals(phoneNumber, static_atributes.get(i).getPhoneNumber())) {
                staticatribute[3] = false;
                break;
            }
        }
        if (staticatribute[3] && phoneNumber.charAt(0) == '0' && phoneNumber.charAt(1) == '9')
            this.phoneNumber = phoneNumber;
        else
            throw new PhoneNumberException();
    }

    protected String getId() {
        return id;
    }

    protected void setId(String id) {
        this.id = id;
    }

    public boolean matchPassword(String password){
        return Objects.equals(this.password, password);
    }

    public void showList(){
        System.out.println("--------------------");
        System.out.println("سلام" + name);
        System.out.println("از موارد زیر یک گزینه را انتخاب کنید و وارد کنید");
        System.out.println("1. پروفایل");



    }

    public void printProf(){
        System.out.println(name + " " + lastname + "\n" + "username: " + username + "password: " + password + "\n" +
                email + "\n" + phoneNumber + "\n" + "id: " + id);
    }
}
