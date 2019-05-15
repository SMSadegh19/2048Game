package view.menuItems.graphicElements;

import view.MenuHandler;

public class ExitButton extends MyButton {
    public ExitButton() {
        super("Exit");
        setOnMouseClicked(event -> MenuHandler.goToParentMenu());
    }
}
