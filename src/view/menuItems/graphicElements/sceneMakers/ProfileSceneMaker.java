package view.menuItems.graphicElements.sceneMakers;

import controllers.ProfileController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import view.MenuHandler;
import view.menuItems.graphicElements.Background;
import view.menuItems.graphicElements.ExitButton;
import view.menuItems.graphicElements.MyButton;
import view.menuItems.graphicElements.MyGridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static view.menuItems.MenuConstants.SCOREBOARD_MENU;

public class ProfileSceneMaker extends SceneMaker {

    @Override
    public Scene makeScene() {
        Group group = new Group();

        Text usernameLabel = new Text("Username: ");
        Text passwordLabel = new Text("Password: ");
        usernameLabel.setStyle("-fx-font-size: 25px; -fx-font-weight: bolder;");
        passwordLabel.setStyle("-fx-font-size: 25px; -fx-font-weight: bolder;");

        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();

        Button scoreboardButton = new MyButton("Scoreboard");
        scoreboardButton.setOnMouseClicked(event -> MenuHandler.goToSubMenu(SCOREBOARD_MENU));

        Button createProfileButton = new MyButton("Create profile");
        createProfileButton.setOnMouseClicked(event -> new ProfileController().createProfile(usernameField.getText(), passwordField.getText()));

        Button loginButton = new MyButton("Login");
        loginButton.setOnMouseClicked(event -> new ProfileController().login(usernameField.getText(), passwordField.getText()));

        Button exitButton = new ExitButton();

        GridPane gridPane = new MyGridPane();

        gridPane.add(scoreboardButton, 0, 0);
        gridPane.add(usernameLabel, 0, 1);
        gridPane.add(usernameField, 1, 1);
        gridPane.add(passwordLabel, 0, 2);
        gridPane.add(passwordField, 1, 2);
        gridPane.add(createProfileButton, 0, 3);
        gridPane.add(loginButton, 1, 3);
        gridPane.add(exitButton, 0, 4);

        ImageView backgroundView = Background.getInstance();
        if (backgroundView != null) {
            group.getChildren().add(backgroundView);
        }

        group.getChildren().add(gridPane);

        return new Scene(group, 1000, 600);
    }
}
