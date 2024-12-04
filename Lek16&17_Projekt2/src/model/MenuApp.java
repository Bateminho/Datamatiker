package model;

import java.util.Arrays;
import java.util.Scanner;

public class MenuApp {
    public static void main(String[] args) {

        int numberOfTeams = 0;

        Team[] teams = createTeams(5);
        Scanner inputScan = new Scanner(System.in);

        boolean continueMakingTeams = true;

        while (continueMakingTeams) {


            int choice;
            do {
                // Display the main menu
                mainMenu();
                choice = inputScan.nextInt();

                switch (choice) {
                    case 1:
                        // Create Team
                        System.out.println("Team name and room: ");
                        String teamName = inputScan.next();
                        String teamRoom = inputScan.next();

                        teams[numberOfTeams].setName(teamName);
                        teams[numberOfTeams].setRoom(teamRoom);
                        numberOfTeams++;
                        System.out.printf("-->Team created with name and room set to %s and %s\n", teamName, teamRoom);

                        break;

                    case 2:
                        //Create student
                        System.out.println("Name of student's team:");
                        String studentTeamName = inputScan.next();
                        System.out.println("Student's name and activity status (true/false)");
                        String studentName = inputScan.next();
                        boolean studentActiviy = inputScan.nextBoolean();
                        System.out.println("Student's number of grades: ");
                        int studentNumberOfGrades = inputScan.nextInt();
                        System.out.printf("Student's %d grades: \n", studentNumberOfGrades);
                        int[] studentGrades = new int[studentNumberOfGrades];
                        for (int i = 0; i < studentNumberOfGrades; i++) {
                            studentGrades[i] = inputScan.nextInt();
                        }

                        Student newStudent = new Student(studentName, studentActiviy, studentGrades );
                        newStudent.setMultipleChoiceAnswers();
                        findTeam(studentTeamName, teams).addStudent(newStudent);
                        System.out.printf("--> Student %s(%s) with grades %s created in team %s\n", studentName, studentActiviy, Arrays.toString(studentGrades), studentTeamName);

                        break;

                    case 3:
                        System.out.println("Name of student: ");
                        String studentNameForInfo = inputScan.next();
                        System.out.println("Name of student's team: ");
                        String studentsTeamName = inputScan.next();
                        findStudent(studentNameForInfo, studentsTeamName, teams).printInfo();

                        break;
                    case 4:
                        System.out.print("Enter team's name: ");
                        String teamTeamName = inputScan.next();

                        System.out.println("--> Team info for team whit name " + teamTeamName +
                                "\nStatistics for team: " + teamTeamName + "\n" + Arrays.toString(findTeam(teamTeamName, teams).studentInfo()));

                        break;

                    case 5:
                        System.out.println("--> Team info for all teams: ");
                        for (Team t: teams) {
                            if (t != null) {
                                System.out.println("\nStatistics for team: " + t.getName() + "\n" + Arrays.toString(t.studentInfo()));
                            }
                        }

                        break;
                    case 6:
                        // Exit menu

                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } while (choice != 6);  // Exit the menu only when choice is 6

            System.out.println("Would you like to perform another transaction? (yes/no)");
            String response = inputScan.next().toLowerCase();
            System.out.println("Exiting account...");

            if (response.equals("no")) {
                continueMakingTeams = false; // End the outer loop
            }
        }
    }

    // Method to display the main menu
    public static void mainMenu() {
        System.out.println("-----------------------------");
        System.out.println("Main menu");
        System.out.println("1: Create a team");
        System.out.println("2: Create a student");
        System.out.println("3: Show one student's info and results");
        System.out.println("4: Show one team's info and results");
        System.out.println("5: Show info and results for all teams");
        System.out.println("6: Exit program");
        System.out.println("Enter a choice: ");
        System.out.println("-----------------------------");
    }

    // Method to create teams
    public static Team[] createTeams(int number) {
        Team[] teams = new Team[number];
        for (int i = 0; i < number; i++) {
            teams[i] = new Team(" ", " ");
        }
        return teams;
    }

    public static Team findTeam(String _name, Team[] teams) {

        for (Team team : teams) {
            if (team.getName().equals(_name)) {
                return team;
            }
        }
        return null;
    }

    public static Student findStudent(String studentName, String teamName, Team[] teams) {


        Team team = findTeam(teamName, teams);


        if (team != null) {
            for (Student student : team.getStudents()) {
                if (student.getName().equals(studentName)) {
                    return student;
                }
            }
        }
        return null;
    }

}


