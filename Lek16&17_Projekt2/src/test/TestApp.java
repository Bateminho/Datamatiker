package test;

import model.Student;
import model.Team;
import java.util.Arrays;


public class TestApp {
    public static void main(String[] args) {
        Team team1 = new Team("24s", "230");
        Team team2 = new Team("24s", "230");

        Student stud1 = new Student("Sean", true, new int[]{7, 10, 5});
        Student stud2 = new Student("Katrine", true, new int[]{10, 10, 10});
        Student stud3 = new Student("Christoffer", true, new int[]{10, 10, 10});

        Student stud4 = new Student("Carsten", true, new int[]{7, 10, 5});
        Student stud5 = new Student("Hanne", true, new int[]{10, 10, 10});
        Student stud6 = new Student("Margrethe", true, new int[]{10, 10, 10});

        team1.addStudent(stud1);
        team1.addStudent(stud2);
        team1.addStudent(stud3);

        team2.addStudent(stud4);
        team2.addStudent(stud5);
        team2.addStudent(stud6);



        team1.removeStudent("Katrine");
        team2.removeStudent("Carsten");

        System.out.println(Arrays.toString(stud1.getGrades()));

        System.out.println(team1.getAvgGradesOfAllStudents());



        stud1.setMultipleChoiceAnswers();
        stud2.setMultipleChoiceAnswers();
        stud3.setMultipleChoiceAnswers();

        stud1.printInfo();
        stud2.printInfo();
        stud3.printInfo();

        char[] correctAnswers = {'A', 'B', 'D', 'C', 'A', 'C', 'A', 'A', 'B', 'D'};

        System.out.println("Number of correct score are: " + stud1.correctAnswers(correctAnswers));

        System.out.println("Opgave 2.7");

        String[] infos = team1.studentInfo();
        for (String info : infos) {
            System.out.println(info);
        }



        System.out.println(Arrays.toString(team1.getCorrectAnswersByQuestion()));


        System.out.println( team1.getAvgGradesOfAllStudents());


    }


}
