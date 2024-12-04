package model;

public class Student {
    private String name;
    private boolean active;
    private int[] grades;
    private final char[] multipleChoiceAnswers;

    public Student(String _name, boolean _active, int[] _grades) {
        name = _name;
        active = _active;
        grades = _grades;
        multipleChoiceAnswers = new char[10];
    }

    public void setName(String _name) {
        name = _name;
    }

    public String getName() {
        return name;
    }


    public boolean isActive() {
        return active;
    }

    public void setGrades(int[] _grades) {
        grades = _grades;
    }

    public int[] getGrades() {
        return grades;
    }

    public char[] getMultipleChoiceAnswers() {
        return multipleChoiceAnswers;
    }

    public void setMultipleChoiceAnswers() {
        for (int i = 0; i < multipleChoiceAnswers.length; i++) {
            multipleChoiceAnswers[i] = getRandomChar('A', 'D');
        }
    }

    public int correctAnswers(char[] _correct) {
        int result = 0;

        for (int i = 0; i < _correct.length; i++) {
            if (_correct[i] == getMultipleChoiceAnswers()[i]) {
                result++;
            }
        }
        return result;
    }

    public static char getRandomChar(char ch1, char ch2) {
        return (char) (ch1 + Math.random() * (ch2 - ch1 + 1));
    }

    public int highestGrade() {
        int max = grades[0];

        for (int i = 1; i < grades.length; i++) {
            if (grades[i] > max) {
                max = grades[i];
            }
        }
        return max;
    }

    public double avgGrade() {
        double sum = grades[0];

        for (int i = 1; i < grades.length; i++) {
            sum += grades[i];
            }

        return sum/grades.length;
    }



    public void printInfo() {
        System.out.println(name);
        System.out.println(active);

        // Print grades
        for (int i = 0; i < grades.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(grades[i]);
        }
        System.out.println();

        // Print multiple choice answers
        for (int i = 0; i < multipleChoiceAnswers.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(multipleChoiceAnswers[i]);
        }
        System.out.println();
    }
}
