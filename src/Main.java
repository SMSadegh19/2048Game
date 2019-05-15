import javafx.application.Application;
import javafx.stage.Stage;
import view.MenuHandler;
import view.menuItems.graphicElements.sceneMakers.ProfileSceneMaker;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        MenuHandler.setStage(primaryStage);
        primaryStage.setScene(new ProfileSceneMaker().makeScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        MenuHandler.startFirstMenu();
        launch(args);
//        CommandHandler.scanAndRunCommands();
    }
}
