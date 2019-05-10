package models;

import java.util.ArrayList;

public class Profile {
    private String name;
    private String password;
    private ArrayList<Integer> scores = new ArrayList<>();

    public Profile(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getHighScore() {
        int max = 0;
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }
        return max;
    }

    public void addScore(int newScore) {
        scores.add(newScore);
    }
}
