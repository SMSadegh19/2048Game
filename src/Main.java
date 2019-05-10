import view.CommandHandler;
import view.MenuHandler;

public class Main {
    public static void main(String[] args) {
        MenuHandler.startFirstMenu();
        CommandHandler.scanAndRunCommands();
    }
}
