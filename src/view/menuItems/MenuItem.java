package view.menuItems;

import view.commands.Command;
import view.commands.commonCommands.ExitCommand;
import view.commands.commonCommands.HelpCommand;

import java.util.ArrayList;

public abstract class MenuItem {
    protected String name;
    protected MenuItem parentMenu = null;
    protected ArrayList<Command> commands = new ArrayList<>();
    protected ArrayList<MenuItem> subMenus = new ArrayList<>();

    {
        initMenuItem();
        commands.add(new HelpCommand());
        commands.add(new ExitCommand());
    }

    public String getName() {
        return name;
    }

    public MenuItem getParentMenu() {
        return parentMenu;
    }

    public ArrayList<Command> getCommands() {
        return commands;
    }

    public ArrayList<MenuItem> getSubMenus() {
        return subMenus;
    }

    public void setParentMenu(MenuItem parentMenu) {
        this.parentMenu = parentMenu;
    }

    protected abstract void initMenuItem();
}