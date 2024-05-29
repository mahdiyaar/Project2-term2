package users;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Lesson {
    private String name;

    public ArrayList<String> notifications = new ArrayList<String>();
    public ArrayList<String> courseMaterial = new ArrayList<String>();
    public ArrayList<Practice> practices = new ArrayList<Practice>();
    public ArrayList<Exam> exams = new ArrayList<Exam>();

    private ArrayList<Student> students = new ArrayList<Student>();




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getPracticeFromUser(){
        System.out.println("--------------");
        System.out.print("enter practice name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Practice practice = new Practice(name);
        while (true){
            System.out.println("do you want to add question?(y/n)");
            String input = scanner.nextLine();
            if(Objects.equals(input, "y")){
                System.out.println("enter the question :");
                input = scanner.nextLine();
                practice.questions.add(input);
            } else if (Objects.equals(input, "n")) {
                break;
            }
        }
        practices.add(practice);
        System.out.println("success!");

    }

    @Override
    public String toString() {
        return name;
    }

    public void editPracticeFromUser(int index) {
        Practice practice = practices.get(index);
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------");
        System.out.println("question: ");
        for (String q : practice.questions){
            System.out.println("-" + q);
        }
        while (true){
            System.out.println("do you want to add question?(y/n)");
            System.out.println("or enter number of question you need to remove");
            String input = scanner.nextLine();
            if(Objects.equals(input, "y")){
                System.out.println("enter the question :");
                input = scanner.nextLine();
                practice.questions.add(input);
            } else if (Objects.equals(input, "n")) {
                break;
            } else if (input.matches("[0-9]+")) {
                int index2 = Integer.parseInt(input);
                try {
                    practices.get(index).questions.remove(index2);
                    System.out.println("deleted!");
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
