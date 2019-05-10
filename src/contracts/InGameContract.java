package contracts;

import models.Directon;
import models.Table;

public interface InGameContract {
    interface View {
        void showGameTable(Table table);
    }

    interface Controller {
        void loadGameTable();
        void startGame(int baseNumber, int numberOfRows, int numberOfColumns);
        void move(Directon directon);
    }
}
