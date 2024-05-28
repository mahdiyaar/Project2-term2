import Exceptions.*;
import Exeptions.PasswordException;
import Exeptions.PhoneNumberException;
import Exeptions.UsernameException;
import Exeptions.emailException;
import users.Employee;
import users.Master;
import users.Student;
import users.User;

import java.util.Objects;
import java.util.Scanner;

public class Main {




    Main(){
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true){
            System.out.println("-----------------------");
            System.out.println("enter:");
            System.out.println("1- login");
            System.out.println("2- sing up");
            System.out.println("\"quit\" for quit");
            input = scanner.nextLine();
            if(Objects.equals(input, "1")){
                while (true) {
                    System.out.println("please enter:(or \"q\" for quit)");
                    System.out.print("username: ");
                    String username = scanner.nextLine();
                    if(Objects.equals(username, "q"))break;
                    User loginedUser = null;
                    for (User u : User.users) {
                        if (Objects.equals(u.getUsername(), username)) loginedUser = u;
                    }
                    if (loginedUser == null) {
                        System.out.println("username not found!");
                    } else {
                        while (true) {
                            System.out.print("password: ");
                            String password = scanner.nextLine();
                            if(Objects.equals(password, "q"))break;
                            if(loginedUser.matchPassword(password)){
                                loginedUser.showList();
                                break;
                            }else {
                                System.out.println("password is incorrect. try again");
                            }
                        }
                    }
                }


            } else if (Objects.equals(input, "2")) {
                System.out.println("select a Role?");
                System.out.println("1- student");
                System.out.println("2- master");
                System.out.println("3- employee");
                input = scanner.nextLine();
                if(Objects.equals(input, "1")){
                    System.out.println("please enter:");
                    System.out.print("name: ");
                    String name = scanner.nextLine();
                    System.out.print("lastname: ");
                    String lastname = scanner.nextLine();
                    System.out.print("field: ");
                    String field = scanner.nextLine();
                    System.out.print("username: ");
                    String username = scanner.nextLine();
                    System.out.print("password: ");
                    String password = scanner.nextLine();
                    System.out.print("email: ");
                    String email = scanner.nextLine();
                    System.out.print("phoneNumber: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("id: ");
                    String id = scanner.nextLine();
                    boolean flag = true;
                    while (flag)
                        try {
                            User.users.add(new Student(name, lastname, field, username, password, email, phoneNumber, id));
                            flag = false;
                        } catch (IdLenNotMatchException e) {
                            System.out.println("len of id must be 10 digits. please try again:");
                            id = scanner.nextLine();
                        } catch (FieldExeption e) {
                            System.out.println("field is invalid. please try again:");
                            field = scanner.nextLine();
                        } catch (PasswordException e) {
                            System.out.println("password is invalid. please try again:");
                            password = scanner.nextLine();
                        } catch (PhoneNumberException e) {
                            System.out.println("PhoneNumber is invalid. please try again:");
                            phoneNumber = scanner.nextLine();
                        } catch (NameException e) {
                            System.out.println("name is invalid. please try again:");
                            name = scanner.nextLine();
                        } catch (UsernameException e) {
                            System.out.println("username is invalid. please try again:");
                            username = scanner.nextLine();
                        } catch (LastNameException e) {
                            System.out.println("lastname is invalid. please try again:");
                            lastname = scanner.nextLine();
                        } catch (emailException e) {
                            System.out.println("email is invalid. please try again:");
                            email = scanner.nextLine();
                        } catch (IdException e) {
                            System.out.println("id is taken by another user. please try again:");
                            id = scanner.nextLine();
                        }
                } else if (Objects.equals(input, "2")) {
                    System.out.println("please enter:");
                    System.out.print("name: ");
                    String name = scanner.nextLine();
                    System.out.print("lastname: ");
                    String lastname = scanner.nextLine();
                    System.out.print("field: ");
                    String field = scanner.nextLine();
                    System.out.print("username: ");
                    String username = scanner.nextLine();
                    System.out.print("password: ");
                    String password = scanner.nextLine();
                    System.out.print("email: ");
                    String email = scanner.nextLine();
                    System.out.print("phoneNumber: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("id: ");
                    String id = scanner.nextLine();
                    boolean flag = true;
                    while (flag)
                        try {
                            User.users.add(new Master(name, lastname, field, username, password, email, phoneNumber, id));
                            flag = false;
                        } catch (IdLenNotMatchException e) {
                            System.out.println("len of id must be 6 digits. please try again:");
                            id = scanner.nextLine();
                        } catch (FieldExeption e) {
                            System.out.println("field is invalid. please try again:");
                            field = scanner.nextLine();
                        } catch (PasswordException e) {
                            System.out.println("password is invalid. please try again:");
                            password = scanner.nextLine();
                        } catch (PhoneNumberException e) {
                            System.out.println("PhoneNumber is invalid. please try again:");
                            phoneNumber = scanner.nextLine();
                        } catch (NameException e) {
                            System.out.println("name is invalid. please try again:");
                            name = scanner.nextLine();
                        } catch (UsernameException e) {
                            System.out.println("username is invalid. please try again:");
                            username = scanner.nextLine();
                        } catch (LastNameException e) {
                            System.out.println("lastname is invalid. please try again:");
                            lastname = scanner.nextLine();
                        } catch (emailException e) {
                            System.out.println("email is invalid. please try again:");
                            email = scanner.nextLine();
                        } catch (IdException e) {
                            System.out.println("id is taken by another user. please try again:");
                            id = scanner.nextLine();
                        }
                } else if (Objects.equals(input, "3")) {
                    System.out.println("please enter:");
                    System.out.print("name: ");
                    String name = scanner.nextLine();
                    System.out.print("lastname: ");
                    String lastname = scanner.nextLine();
                    System.out.print("username: ");
                    String username = scanner.nextLine();
                    System.out.print("password: ");
                    String password = scanner.nextLine();
                    System.out.print("email: ");
                    String email = scanner.nextLine();
                    System.out.print("phoneNumber: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("id: ");
                    String id = scanner.nextLine();
                    boolean flag = true;
                    while (flag)
                        try {
                            User.users.add(new Employee(name, lastname, username, password, email, phoneNumber, id));
                            flag = false;
                        } catch (IdLenNotMatchException e) {
                            System.out.println("len of id must be 4 digits. please try again:");
                            id = scanner.nextLine();
                        } catch (PasswordException e) {
                            System.out.println("password is invalid. please try again:");
                            password = scanner.nextLine();
                        } catch (PhoneNumberException e) {
                            System.out.println("PhoneNumber is invalid. please try again:");
                            phoneNumber = scanner.nextLine();
                        } catch (NameException e) {
                            System.out.println("name is invalid. please try again:");
                            name = scanner.nextLine();
                        } catch (UsernameException e) {
                            System.out.println("username is invalid. please try again:");
                            username = scanner.nextLine();
                        } catch (LastNameException e) {
                            System.out.println("lastname is invalid. please try again:");
                            lastname = scanner.nextLine();
                        } catch (emailException e) {
                            System.out.println("email is invalid. please try again:");
                            email = scanner.nextLine();
                        } catch (IdException e) {
                            System.out.println("id is taken by another user. please try again:");
                            id = scanner.nextLine();
                        }
                }

            } else if (Objects.equals(input, "quit") || Objects.equals(input, "q")) {
                break;
            }else {
                System.out.println("unknown command please try again!");
            }
        }
    }


    public static void main(String[] args) {
        new Main();
    }
}