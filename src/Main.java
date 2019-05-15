import javafx.application.Application;
import javafx.stage.Stage;
import view.MenuHandler;
import view.menuItems.graphicElements.scenes.ProfileScene;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        MenuHandler.setStage(primaryStage);
        primaryStage.setScene(ProfileScene.makeScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        MenuHandler.startFirstMenu();
        launch(args);
//        CommandHandler.scanAndRunCommands();
    }
}
