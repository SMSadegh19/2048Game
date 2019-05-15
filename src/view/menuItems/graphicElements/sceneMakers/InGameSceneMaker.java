package view.menuItems.graphicElements.sceneMakers;

import controllers.InGameController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import models.Cell;
import models.Directon;
import models.Table;

public class InGameSceneMaker extends SceneMaker {
    private static int baseNumber;
    private static Group group = new Group();
    private static Scene gameScene = new Scene(group, 1000, 600);
    private final static int BOX_HEIGHT = 70;
    private final static int BOX_FIRST_DEPTH = 10;

    private final static Rotate rxBox = new Rotate(0, 0, 0, 0, Rotate.X_AXIS);
    private final static Rotate ryBox = new Rotate(0, 0, 0, 0, Rotate.Y_AXIS);
    private final static Rotate rzBox = new Rotate(0, 0, 0, 0, Rotate.Z_AXIS);

    static {
        rxBox.setAngle(-10);
        ryBox.setAngle(0);
        rzBox.setAngle(0);
    }

    @Override
    public Scene makeScene() {
        new InGameController().loadGameTable();
        gameScene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    new InGameController().move(Directon.UP);
                    break;
                case RIGHT:
                    new InGameController().move(Directon.RIGHT);
                    break;
                case LEFT:
                    new InGameController().move(Directon.LEFT);
                    break;
                case DOWN:
                    new InGameController().move(Directon.DOWN);
                    break;
            }
        });
        return gameScene;
    }

    public static void updateScene(Table table) {
        int numberOfRows = table.getNumberOfRows();
        int numberOfColumns = table.getNumberOfColumns();
        baseNumber = table.getBaseNumber();

        Box groundBox = new Box(numberOfColumns * BOX_HEIGHT, numberOfRows * BOX_HEIGHT, BOX_FIRST_DEPTH);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.LIGHTBLUE);
        groundBox.setMaterial(material);
        groundBox.relocate(0, 0);
        groundBox.getTransforms().addAll(new Translate(), rxBox, ryBox, rzBox);

        group.getChildren().clear();
        group.getChildren().add(groundBox);

        Cell[][] cells = table.getCells();
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                Cell cell = cells[i][j];
                if (cell.getValue() != 0) {
                    Box box = makeBox(i, j, cell);
                    Label label = makeLabel(i, j, cell);
                    group.getChildren().add(box);
                    group.getChildren().add(label);
                }
            }
        }

        group.relocate(BOX_HEIGHT, BOX_HEIGHT);
    }

    private static Box makeBox(int i, int j, Cell cell) {
        Box box = new Box(BOX_HEIGHT, BOX_HEIGHT, getDepth(cell.getValue()));
        box.relocate(j * BOX_HEIGHT, i * BOX_HEIGHT);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(getBackgroundColor(cell.getValue()));
        box.setMaterial(material);

        box.getTransforms().addAll(new Translate(), rxBox, ryBox, rzBox);
        return box;
    }

    private static Label makeLabel(int i, int j, Cell cell) {
        Translate translate = new Translate(0, 0, 0);
        Label label = new Label(cell.getValue() + "");
        label.setFont(Font.font("Arial", FontWeight.BOLD,16));
        label.relocate(j * BOX_HEIGHT + BOX_HEIGHT / 4, i * BOX_HEIGHT + BOX_HEIGHT / 4);
        label.setTextFill(getForegroundColor(cell.getValue()));
        label.getTransforms().addAll(translate, rxBox, ryBox, rzBox);
        return label;
    }

    private static int getDepth(int number) {
        number = number / baseNumber * 2;
        int power = -1;
        while (number > 0) {
            number /= 2;
            power++;
        }
        return power * BOX_FIRST_DEPTH;
    }

    private static Color getBackgroundColor(int number) {
        number = number / baseNumber * 2;
        switch (number) {
            case 2:
                return Color.web("0xeee4da");
            case 4:
                return Color.web("0xede0c8");
            case 8:
                return Color.web("0xf2b179");
            case 16:
                return Color.web("0xf59563");
            case 32:
                return Color.web("0xf67c5f");
            case 64:
                return Color.web("0xf65e3b");
            case 128:
                return Color.web("0xedcf72");
            case 256:
                return Color.web("0xedcc61");
            case 512:
                return Color.web("0xedc850");
            case 1024:
                return Color.web("0xedc53f");
            case 2048:
                return Color.web("0xedc22e");
        }
        return Color.web("0x504BCD");
    }

    private static Color getForegroundColor(int number) {
        number = number / baseNumber * 2;
        return number < 16 ? Color.web("0x776e65") : Color.web("0xf9f6f2");
    }
}
