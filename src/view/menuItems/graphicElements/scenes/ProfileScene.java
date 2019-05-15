package view.menuItems.graphicElements.scenes;

import controllers.ProfileController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import view.MenuHandler;
import view.menuItems.graphicElements.ExitButton;
import view.menuItems.graphicElements.MyButton;

import static view.menuItems.MenuConstants.SCOREBOARD_MENU;

public class ProfileScene {
    public static Scene makeScene() {
        Text usernameLabel = new Text("Username: ");
        Text passwordLabel = new Text("Password: ");

        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();

        Button scoreboardButton = new MyButton("Scoreboard");
        scoreboardButton.setOnMouseClicked(event -> MenuHandler.goToSubMenu(SCOREBOARD_MENU));

        Button createProfileButton = new MyButton("Create profile");
        createProfileButton.setOnMouseClicked(event -> new ProfileController().createProfile(usernameField.getText(), passwordField.getText()));

        Button loginButton = new MyButton("Login");
        loginButton.setOnMouseClicked(event -> new ProfileController().login(usernameField.getText(), passwordField.getText()));

        Button exitButton = new ExitButton();

        GridPane gridPane = gridPaneInit();

        gridPane.add(scoreboardButton, 0, 0);
        gridPane.add(usernameLabel, 0, 1);
        gridPane.add(usernameField, 1, 1);
        gridPane.add(passwordLabel, 0, 2);
        gridPane.add(passwordField, 1, 2);
        gridPane.add(createProfileButton, 0, 3);
        gridPane.add(loginButton, 1, 3);
        gridPane.add(exitButton, 0, 4);

        Group group = new Group(gridPane);

        return new Scene(group, 1000, 600);
    }

    private static GridPane gridPaneInit() {
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(1000, 600);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        return gridPane;
    }
}
