package view.menuItems.graphicElements.sceneMakers;

import controllers.InGameController;
import controllers.ProfileController;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import view.MenuHandler;
import view.Notify;
import view.menuItems.graphicElements.Background;
import view.menuItems.graphicElements.ExitButton;
import view.menuItems.graphicElements.MyButton;
import view.menuItems.graphicElements.MyGridPane;

import static view.menuItems.MenuConstants.IN_GAME_MENU;

public class MainMenuSceneMaker extends SceneMaker {
    @Override
    public Scene makeScene() {
        TextField newUsernameField = new TextField("new username");
        TextField baseNumberField = new TextField("base number");
        TextField numberOfRowsField = new TextField("number of rows");
        TextField numberOfColumnsField = new TextField("number of columns");

        Button startGameButton = makeStartGameButton(baseNumberField, numberOfRowsField, numberOfColumnsField);
        Button changeUsernameButton = new MyButton("Change username");
        changeUsernameButton.setOnMouseClicked(event -> new ProfileController().changeUsername(newUsernameField.getText()));

        Button exitButton = new ExitButton();

        GridPane gridPane = new MyGridPane();

        gridPane.add(changeUsernameButton, 1, 0);
        gridPane.add(newUsernameField, 1, 1);

        gridPane.add(new Label(), 0, 2);

        gridPane.add(startGameButton, 1, 3);
        gridPane.add(baseNumberField, 0, 4);
        gridPane.add(numberOfRowsField, 1, 4);
        gridPane.add(numberOfColumnsField, 2, 4);

        gridPane.add(new Label(), 0, 5);

        gridPane.add(exitButton, 1, 6);

        for (Node node : gridPane.getChildren()) {
            GridPane.setHalignment(node, HPos.CENTER);
            GridPane.setValignment(node, VPos.CENTER);
        }
        Group group = new Group();

        ImageView backgroundView = Background.getInstance();
        if (backgroundView != null) {
            group.getChildren().addAll(backgroundView, gridPane);
        } else {
            group.getChildren().add(gridPane);
        }


        return new Scene(group, 1000, 600);
    }

    private Button makeStartGameButton(TextField baseNumberField, TextField numberOfRowsField, TextField numberOfColumnsField) {
        Button startGameButton = new MyButton("Start game!");
        startGameButton.setOnMouseClicked(event -> {
            try {
                int baseNumber = Integer.parseInt(baseNumberField.getText());
                int numberOfRows = Integer.parseInt(numberOfRowsField.getText());
                int numberOfColumns = Integer.parseInt(numberOfColumnsField.getText());
                if (baseNumber < 1 || numberOfRows < 4 || numberOfColumns < 4) {
                    throw new NumberFormatException();
                }
                new InGameController()
                        .startGame(baseNumber
                                , numberOfRows
                                , numberOfColumns);
                MenuHandler.goToSubMenu(IN_GAME_MENU);
            } catch (NumberFormatException e) {
                Notify.logError("Put valid numbers! base number > 0, rows > 3, columns > 3");
            }
        });
        return startGameButton;
    }
}
