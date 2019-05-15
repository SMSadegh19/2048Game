package view.menuItems.graphicElements;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class MyButton extends Button {
    public MyButton(String text) {
        super(text);
        setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        setOnMouseExited(event -> setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"));
        setOnMouseEntered(event -> setStyle("-fx-background-color: #6a5b8b; -fx-text-fill: #ff8d90;"));
    }
}
