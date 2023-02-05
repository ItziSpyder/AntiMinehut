package me.improper.antiminehut.commands;

import me.improper.antiminehut.plugin.MinehutChecker;
import me.improper.antiminehut.plugin.PluginRemover;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class AntiMhCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try {
            switch (args[0]) {
                case "removeall" -> {
                    MinehutChecker.getMinehutPlugins().forEach(PluginRemover::removePlugin);
                    MinehutChecker.getMinehutFiles().forEach(PluginRemover::removeFile);
                    sender.sendMessage("Attempted to delete all Minehut plugins!");
                }
                case "about" -> {
                    sender.sendMessage("""
                            §8=========================================
                            §fAbout AntiMinehut
                            §8-------------------------
                            §7AntiMinehut is a plugin that aims to disable all
                            Minehut plugins then deleting all relating files. 
                            This plugin will then auto reload the server if 
                            there were Minehut files detected in the process.
                            §8-------------------------
                            §f- §3/antimh §bremoveall
                            §f- §3/antimh §babout
                            §f- §3/antimh §bhelp
                            §8=========================================
                            """);
                }
                case "help" -> {
                    sender.sendMessage("""
                            §8=========================================
                            §fAntiMinehut Guide
                            §8-------------------------
                            §7Doing "/antimh removeall" 
                            or "/reload confirm"
                            will both disable and delete all Minehut-
                            related files and/or plugins. However they will not
                            unregister a plugin until you do "/restart".
                            §8-------------------------
                            §7Because of this we've provided a feature that will auto
                            reload your server right after server starts up
                            so by the time you've joined your server, you
                            won't be able to see a single "Minehut" on your
                            screen.
                            §8-------------------------
                            §7If you do spot bugs please report them to: 
                            §3https://github.com/ItziSpyder/AntiMinehut
                            §7rather than using a review through SpigotMC.
                            §8-------------------------
                            §f- §3/antimh §bremoveall
                            §f- §3/antimh §babout
                            §f- §3/antimh §bhelp
                            §8=========================================
                            """);
                }
            }
            return true;
        }
        catch (Exception ex) {
            CommandExceptionHandler handler = new CommandExceptionHandler(ex,command);
            sender.sendMessage(handler.getErrorMessage());
            return true;
        }
    }

    public static class AntiMhTab implements TabCompleter {
        @Override
        public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
            List<String> list = new ArrayList<>();
            switch (args.length) {
                case 1 -> {
                    list.add("removeall");
                    list.add("about");
                    list.add("help");
                }
            }
            list.removeIf(s -> !s.toLowerCase().contains(args[args.length - 1].toLowerCase()));
            return list;
        }
    }
}