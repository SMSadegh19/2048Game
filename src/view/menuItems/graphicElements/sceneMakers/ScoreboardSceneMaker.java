package view.menuItems.graphicElements.sceneMakers;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import models.GameContents;
import models.Profile;
import view.menuItems.graphicElements.Background;
import view.menuItems.graphicElements.ExitButton;
import view.menuItems.graphicElements.MyGridPane;

import java.util.ArrayList;
import java.util.Comparator;

public class ScoreboardSceneMaker extends SceneMaker {
    @Override
    public Scene makeScene() {
        ArrayList<Profile> profiles = GameContents.getProfiles();
        profiles.sort(Comparator.comparingInt(Profile::getHighScore).reversed());

        GridPane gridPane = new MyGridPane();
        gridPane.add(highScoreLabel(), 1, 0);
        for (int i = 0; i < profiles.size(); i++) {
            Profile profile = profiles.get(i);
            gridPane.add(nameLabel(profile, i + 1), 0, i + 1);
            gridPane.add(scoreLabel(profile), 1, i + 1);
        }

        Button exitButton = new ExitButton();
        exitButton.relocate(500, 100);

        Group group = new Group();

        ImageView backgroundView = Background.getInstance();
        if (backgroundView != null) {
            group.getChildren().addAll(backgroundView, gridPane, exitButton);
        } else {
            group.getChildren().addAll(gridPane, exitButton);
        }

        return new Scene(group, 1000, 600);
    }

    private Label nameLabel(Profile profile, int i) {
        Label label = new Label(i + ": " + profile.getName());
        label.setStyle("-fx-text-fill: #000093; -fx-font-size: 20px; -fx-font-weight: bolder;");
        return label;
    }

    private Label scoreLabel(Profile profile) {
        Label label = new Label("  " + profile.getHighScore());
        label.setStyle("-fx-text-fill: #9f0000; -fx-font-size: 25px; -fx-font-weight: bolder;");
        return label;
    }

    private Label highScoreLabel() {
        Label label = new Label(" HIGH SCORE ");
        label.setStyle("-fx-text-fill: #9f0000; -fx-font-size: 25px; -fx-font-weight: bolder;");
        return label;
    }
}
