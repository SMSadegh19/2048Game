package view.menuItems.graphicElements;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class MyGridPane extends GridPane {
    public MyGridPane() {
        super();
        setMinSize(1000, 600);
        setPadding(new Insets(10, 10, 10, 10));
        setVgap(5);
        setHgap(5);
        setAlignment(Pos.CENTER);
    }
}
