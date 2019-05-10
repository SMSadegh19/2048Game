package models;

import java.util.ArrayList;

public class GameContents {
    private static Table currentGame;
    private static ArrayList<Profile> profiles = new ArrayList<>();
    private static Profile currnetProfile;

    public static Table getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Table currentGame) {
        GameContents.currentGame = currentGame;
    }

    public static Profile getProfile(String name) {
        for (Profile profile : profiles) {
            if (profile.getName().equalsIgnoreCase(name)) {
                return profile;
            }
        }
        return null;
    }

    public static void addProfile(String name, String password) {
        profiles.add(new Profile(name, password));
    }
}
