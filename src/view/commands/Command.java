package view.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Command {
    protected String name;
    protected Pattern pattern;
    protected Matcher matcher;

    public String getName() {
        return name;
    }

    public Matcher getMatcher() {
        return matcher;
    }

    public void setMatcher(String string) {
        this.matcher = pattern.matcher(string);
    }

    public abstract void doIt();
}
