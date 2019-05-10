package contracts;

import models.Table;

public interface InGameContract {
    interface View {
        void setController(Controller controller);

        void showGameTable(Table table);
    }

    interface Controller {
        void loadGameTable();
        void startGame(int baseNumber, int numberOfRows, int numberOfColumns);
    }
}
