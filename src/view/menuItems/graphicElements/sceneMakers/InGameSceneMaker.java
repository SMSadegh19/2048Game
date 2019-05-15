package view.menuItems.graphicElements.sceneMakers;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class InGameSceneMaker extends SceneMaker {
    @Override
    public Scene makeScene() {
        // TODO: 5/15/19

        Button chert = new Button();

        Group group = new Group(chert);

        return new Scene(group, 1000, 600);
    }
}
