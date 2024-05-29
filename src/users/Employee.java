package users;

import Exceptions.*;
import Exceptions.PasswordException;
import Exceptions.PhoneNumberException;
import Exceptions.UsernameException;
import Exceptions.emailException;

import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Employee extends User {
    public Employee(String name, String lastname, String username, String password, String email, String phoneNumber, String id)
            throws IdLenNotMatchException, PasswordException, PhoneNumberException, NameException, UsernameException, LastNameException, emailException, IdRepeatedException {
        super(name, lastname, username, password, email, phoneNumber, id);
        if(id.length() != 4)throw new IdLenNotMatchException();
    }
    @Override
    public void showList(){
        while (true) {
            super.showList();
            System.out.println("2.کلاس ها");
            System.out.println("3.حدف واضافه و تغییر اظلاعات استاد");
            System.out.println("4.حدف و اضافه و تغییر اطلاعات دانشجو");
            System.out.println("خروج");
            System.out.println("time: " + new Date());
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (Objects.equals(input, "1")) {
                printProf();
            } else if (Objects.equals(input, "خروج") || Objects.equals(input, "q")) {
                System.out.println("logout!");
                break;
            } else if (Objects.equals(input, "2")) {
                while (true) {
                    int index;
                    System.out.printf("نام کاربری استادی که این کلاس را دارد وارد کنید ");
                    String name = scanner.nextLine();
                    boolean select = true;
                    Master user = null;
                    for (int i = 0; i < users.size(); i++) {
                        if (name == users.get(i).getUsername()) {
                            user = (Master) users.get(i);
                            select = false;
                            break;
                        }
                    }
                    if (select) {
                        System.out.printf("استاد با این نام کاربری یافت نشد");
                    } else {
                        for (int i = 0; i < user.lessons.size(); i++) {
                            System.out.println(i + "- " + user.lessons.get(i).getName());
                        }
                        input = scanner.nextLine();
                        boolean flag = true;
                        Lesson current = null;
                        while (flag)
                            try {
                                input = scanner.nextLine();
                                index = Integer.parseInt(input);
                                current = user.lessons.get(index);
                                flag = false;
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("عدد نامعتبر است!");
                            } catch (RuntimeException e) {
                                System.out.println("لطفا عدد وارد کنید!");
                            }

                        editLessons(current);

                    }
                }
            } else if (Objects.equals(input,"3")){
                while (true) {
                    int index;
                    System.out.printf("نام کاربری استادی که این کلاس را دارد وارد کنید ");
                    String name = scanner.nextLine();
                    boolean select = true;
                    Master user = null;
                    for (int i = 0; i < users.size(); i++) {
                        if (name == users.get(i).getUsername()) {
                            user = (Master) users.get(i);
                            select = false;
                            break;
                        }
                    }
                    if (select) {
                        System.out.printf("استاد با این نام کاربری یافت نشد");
                    } else {
                        for (int i = 0; i < user.lessons.size(); i++) {
                            System.out.println(i + "- " + user.lessons.get(i).getName());
                        }
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
            System.out.println("5.حدف دانشجو");
            System.out.println("6.اضافه دانشجو");
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
                System.out.println("در صورت درخواست تغییر شماره را وارد کنید");
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
                        System.out.println("عدد نامعتبر است!");
                    }
                }else{
                    System.out.println("ورودی نامعتبر است!");
                }

                editPractice();
            } else if (Objects.equals(input, "5")) {
                System.out.println("شماره دانشجویی فرn مورد نظر را وارد کنید");
                String serchid;
                boolean removed=false;
                serchid=scanner.nextLine();
                for (int i = 0; i < les.students.size(); i++) {
                    if(Objects.equals(serchid, les.students.get(i).getId())){
                        les.students.remove(i);
                        removed=true;
                        break;
                    }
                }
                if(!removed){
                    System.out.println("دانشجوی موردنظر یافت نشد");
                }
            }else if (Objects.equals(input, "6")) {
                System.out.println("شماره دانشجویی فرئ مورد نظر را وارد کنید");
                String serchid;
                boolean plusd = false;
                serchid = scanner.nextLine();
                for (int i = 0; i < users.size(); i++) {
                    if (Objects.equals(serchid, users.get(i).getId())) {
                        les.students.add((Student) users.get(i));
                        plusd = true;
                        break;
                    }
                }
                if (!plusd) {
                    System.out.println("دانشجوی موردنظر یافت نشد");
                }
            }
        }
    }

    private void editPractice() {

        if(id.length() != 4)throw new IdLenNotMatchException("len of id must be 4 digits");
    }
}
