package users;

import Exceptions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Student extends User {
    private String field;
    public ArrayList<Lesson> lessons =new ArrayList<Lesson>();
    public Student(String name, String lastname, String field, String username, String password, String email, String phoneNumber, String id) throws IdLenNotMatchException, FieldExeption, PasswordException, PhoneNumberException, NameException, UsernameException, LastNameException, emailException, IdException {
        super(name, lastname, username, password, email, phoneNumber, id);
        if (field.length() < 19 && Pattern.matches("[a-zA-Z]+", field))
            this.field = field;
        else
            throw new FieldExeption();
        if(id.length() != 10)throw new IdLenNotMatchException("len of id must be 10 digits");
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
    public void showList() {
        super.showList();
        System.out.println("2.نام دروس");
        System.out.println("3.تمارین و امتحانات");
        System.out.println("4.مطالب درسی واعلانات");
        System.out.println("5.زمان");
        System.out.println("6.خروج");
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        String name;
        if(a==2){
            for (int i = 0; i < lessons.size(); i++) {
                lessons.get(i).toString();
            }
        } else if (a==3) {
            for (int i = 0; i < lessons.size(); i++) {
                lessons.get(i).practices.toString();
                lessons.get(i).exams.toString();
            }
            showList();
        }else if (a==4) {
            for (int i = 0; i < lessons.size(); i++) {
                lessons.get(i).notifications.toString();
                lessons.get(i).courseMaterial.toString();
            }
            showList();
        } else if (a==1) {
            printProf();
            System.out.println("field: " + field);
            showList();
        } else if (a==5) {
            System.out.println("time: " + new Date());
            showList();
        } else if (a==6) {
            System.out.println("logout!");
        }
    }
}
