package model;

public class Team {
    private String name;
    private String room;
    private final Student[] students;
    private static final char[] correctAnswers = new char[]{'A', 'B', 'D', 'C', 'A', 'C', 'A', 'A', 'B', 'D'};
    private int numberOfStudents;
    private static int teamNr;

    public Team(String _name, String _room) {
        name = _name;
        room = _room;
        students = new Student[32];
        numberOfStudents = 0;
        teamNr++;
    }

    public void setName(String _name) {
        name = _name;
    }

    public String getName() {
        return name;
    }


    public void setRoom(String _room) {
        room = _room;
    }

    public String getRoom() {
        return room;
    }

    public void addStudent(Student _student) {
        students[numberOfStudents] = _student;
        numberOfStudents++;
    }

    public void removeStudent(String _name) {

        int index = 0;
        boolean nameFound = false;

        while (!nameFound) {
            if (students[index].getName().equals(_name)) {
                students[index] = null;
                nameFound = true;
            }
            index++;
        }

        for (int i = index - 1; i < numberOfStudents; i++) {
            students[i] = students[i + 1];

        }
        students[numberOfStudents - 1 ] = null;
        numberOfStudents--;


    }

    public Student[] getStudents(){
        Student[] actualStudents = new Student[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            actualStudents[i] = students[i];
        }
        return actualStudents;
    }

    public double getAvgGradesOfAllStudents() {
        int numberOfGrades = 0;
        double sum = 0;

        for (Student student : getStudents()) {
            for (int i = 0; i < student.getGrades().length; i++) {
                numberOfGrades++;
                sum += student.getGrades()[i];
            }
        }

             return sum/numberOfGrades;
    }

    public Student[] highScoreStudents (double minAverage){
        Student[] goodStudents = new Student[numberOfStudents];
        int j = 0;
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].isActive() && students[i].avgGrade() >= minAverage){
                goodStudents[j] = students[i];
                j++;
            }
        }

        Student[] actualGoodStudents = new Student[j];
        for (int i = 0; i < j; i++){
            actualGoodStudents[i] = goodStudents[i];
        }
        return actualGoodStudents;
    }

    //Method that takes an array of correct answers
    //and returns a new array where each element represents the amount of students who got the question right.

    public int[] getCorrectAnswersByQuestion() {

        int[] answers = new int[correctAnswers.length];

        //For each student each answer[i} is checked with the correct _answer[] If equal answer[i]++
        for (Student student : getStudents()) {
            char[] studentAnswers = student.getMultipleChoiceAnswers();
            for (int i = 0; i < correctAnswers.length; i++) {
                if (correctAnswers[i] == studentAnswers[i]) {
                    answers[i]++;
                }
            }
        }
        return answers;
    }

    public String[] studentInfo() {

        String[] studentsInfo = new String[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            studentsInfo[i] = String.format("Navn: %-11s  Gennemsnit: %-6.2f  Antal rigtige: %d",
                    students[i].getName(),
                    students[i].avgGrade(),
                    students[i].correctAnswers(correctAnswers));
        }

        return studentsInfo;
    }

}
