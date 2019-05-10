package controllers;

import contracts.ProfileContract;
import models.GameContents;
import models.Profile;
import view.MenuHandler;
import view.Notify;

import static view.menuItems.MenuConstants.MAIN_MENU;

public class ProfileController implements ProfileContract.Controller {
    @Override
    public void login(String name, String password) {
        Profile profile = GameContents.getProfile(name);
        if (profile == null) {
            Notify.logError("This profile doesn't exist!");
        } else if (!profile.getPassword().equals(password)) {
            Notify.logError("The password is incorrect!");
        } else {
            GameContents.setCurrentProfile(profile);
            Notify.logMessage("You logged in successfully!");
            MenuHandler.goToSubMenu(MAIN_MENU);
        }
    }

    @Override
    public void createProfile(String name, String password) {
        if (GameContents.getProfile(name) != null) {
            Notify.logError("Sorry! This profile already exist!");
        } else {
            GameContents.addProfile(new Profile(name, password));
            Notify.logMessage("Profile created!");
        }
    }
}
