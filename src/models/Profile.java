package models;

public class Profile {
    private String name;
    private String password;
    private int highScore;

    public Profile(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public int getHighScore() {
        return highScore;
    }

    public void catchNewScore(int newScore) {
        if (newScore > highScore) {
            highScore = newScore;
        }
    }
}
