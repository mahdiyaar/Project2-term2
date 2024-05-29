package users;

import Exceptions.*;
import Exeptions.PasswordException;
import Exeptions.PhoneNumberException;
import Exeptions.UsernameException;
import Exeptions.emailException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Master extends User {
    String field;

    private ArrayList<Lesson> lessons = new ArrayList<Lesson>();

    public Master(String name, String lastname, String field, String username, String password, String email, String phoneNumber, String id) throws IdLenNotMatchException, FieldExeption, PasswordException, PhoneNumberException, NameException, UsernameException, LastNameException, emailException, IdRepeatedException {
        super(name, lastname, username, password, email, phoneNumber, id);
        if (field.length() < 19 && Pattern.matches("[a-zA-Z]+", field))
            this.field = field;
        else
            throw new FieldExeption();
        if(id.length() != 6)throw new IdLenNotMatchException("len of id must be 6 digits");
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

    @Override
    public void showList(){
        while (true) {
            super.showList();
            System.out.println("2.کلاس ها");
            System.out.println("خروج");
            System.out.println("time: " + new Date());
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (Objects.equals(input, "1")) {
                printProf();
                System.out.println("field: " + field);
            } else if (Objects.equals(input, "خزوج") || Objects.equals(input, "q")) {
                System.out.println("logout!");
                break;
            } else if (Objects.equals(input, "2")) {
                outerWhile : while (true) {
                    int index;
                    for (int i = 0; i < lessons.size(); i++) {
                        System.out.println(i + "- " + lessons.get(i).getName());
                    }

                    input = scanner.nextLine();
                    boolean flag = true;
                    Lesson current = null;
                    while (flag)
                        try{
                            input = scanner.nextLine();
                            if(Objects.equals(input, "q"))break outerWhile;
                            index = Integer.parseInt(input);
                            current = lessons.get(index);
                            flag = false;
                        }catch (IndexOutOfBoundsException e){
                            System.out.println("عدد نامعتبر است!");
                        }catch (RuntimeException e){
                            System.out.println("لطفا عدد وارد کنید!");
                        }

                    editLessons(current);

                }
            }
        }
    }

    private void editLessons(Lesson les){
        while (true) {
            System.out.println("------------------");
            System.out.println("--" + les.getName() + "--");
            System.out.println("1. اعلانات");
            System.out.println("2. مطالب درسی");
            System.out.println("3. تمارین");
            System.out.println("4. امتحانات");
            System.out.println("خروج");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (Objects.equals(input, "1")) {
                for (String not : les.notifications){
                    System.out.println("-" + not);
                }
                System.out.println("آیا می خواهید اضافه کنید؟(بله/خیر)");
                input = scanner.nextLine();
                if(Objects.equals(input, "بله")){
                    System.out.println("متن خود را وارد کنید: ");
                    les.notifications.add(scanner.nextLine());
                }
            } else if (Objects.equals(input, "2")) {
                for (String mat : les.courseMaterial){
                    System.out.println("-" + mat);
                }
                System.out.println("آیا می خواهید اضافه کنید؟(بله/خیر)");
                input = scanner.nextLine();
                if(Objects.equals(input, "بله")){
                    System.out.println("متن خود را وارد کنید: ");
                    les.courseMaterial.add(scanner.nextLine());
                }
            } else if (Objects.equals(input, "3")) {
                for (int i = 0; i < les.practices.size(); i++) {
                    System.out.println(i + "- " + les.practices.get(i));
                }
                System.out.println("در صورت درخواست تغییر، شماره را وارد کنید");
                System.out.println("در صورت درخواست اضاثه کردن بله را وارد کنید");
                System.out.println("در غیر این صورت خیر را وارد کنید");
                input = scanner.nextLine();
                if(Objects.equals(input, "بله")){
                    les.getPracticeFromUser();
                } else if (Objects.equals(input, "خیر")) {
                    continue;
                }else if(input.matches("[0-9]+")){
                    int index = Integer.parseInt(input);
                    try {
                        les.editPracticeFromUser(index);
                    }catch (IndexOutOfBoundsException e){
                        e.printStackTrace();
                        System.out.println("عدد نامعتبر است!");
                    }
                }else{
                    System.out.println("ورودی نامعتبر است!");
                }


            }
        }
    }

    private void editPractice() {

    }


}
