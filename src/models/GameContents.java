package models;

import java.util.ArrayList;

public class GameContents {
    private static Table currentGame;
    private static ArrayList<Profile> profiles = new ArrayList<>();
    private static Profile currentProfile;

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

    public static void setCurrentProfile(Profile currentProfile) {
        GameContents.currentProfile = currentProfile;
    }

    public static void addProfile(Profile profile) {
        profiles.add(profile);
    }

    public static ArrayList<Profile> getProfiles() {
        return profiles;
    }
}
