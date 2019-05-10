package contracts;

import models.Profile;

import java.util.ArrayList;

public interface ScoreboardContract {
    interface View {
        void showScoreboard(ArrayList<Profile> profiles);
    }
    interface Controller {
        void loadScoreBoard();
    }
}
