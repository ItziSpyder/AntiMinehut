package me.improper.antiminehut.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;

public class CommandExceptionHandler {

    private final Exception exception;
    private final Command command;

    public CommandExceptionHandler(Exception exception, Command command) {
        this.exception = exception;
        this.command = command;
    }

    public Exception getException() {
        return exception;
    }

    public Command getCommand() {
        return command;
    }

    public String getErrorMessage() {
        String msg = ChatColor.RED + "Command Error: ";
        if (exception instanceof NullPointerException) msg += "Command contains a null value!";
        else if (exception instanceof IndexOutOfBoundsException) msg += "Incomplete command, please provide more information!";
        else msg += exception.getMessage();
        msg += "\nCorrect usage: " + ChatColor.GRAY + command.getUsage();
        return msg;
    }
}
