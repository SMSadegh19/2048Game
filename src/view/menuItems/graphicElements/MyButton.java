package view.menuItems.graphicElements;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class MyButton extends Button {
    public MyButton(String text) {
        super(text);
        setTextFill(Color.ORANGERED);
        setOnMouseExited(event -> setTextFill(Color.ORANGERED));
        setOnMouseEntered(event -> setTextFill(Color.LIGHTBLUE));
    }
}
