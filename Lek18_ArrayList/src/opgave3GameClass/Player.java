package opgave3GameClass;

public class Player {
    public String name;
    public int age;
    public int score;

    Player(String _name, int _age) {
        name = _name;
        age = _age;
        score = 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int _score) {
        score = _score;
    }

    public void addScore(int _score) {
        score += _score;
    }


}
