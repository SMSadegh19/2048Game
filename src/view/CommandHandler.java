package view;

import view.commands.Command;

import java.util.Scanner;

import static view.Notify.logError;
import static view.Notify.logMessage;

public class CommandHandler {
    private static Scanner scanner = new Scanner(System.in);

    public static String scanCommandByMessage(String message) {
        logMessage(message);
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        }
        return null;
    }

    public static void scanAndRunCommands() {
        while (scanner.hasNextLine()) {
            try {
                String string = scanner.nextLine();
                runCommand(string);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    private static void runCommand(String string) {
        for (Command command : MenuHandler.getCurrentMenu().getCommands()) {
            command.setMatcher(string);
            if (command.getMatcher().matches()) {
                command.doIt();
                return;
            }
        }
        logError("invalid command!");
    }
}
