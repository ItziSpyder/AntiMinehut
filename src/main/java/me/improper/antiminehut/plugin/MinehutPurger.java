package me.improper.antiminehut.plugin;

import me.improper.antiminehut.AntiMinehut;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

public class MinehutPurger {

    private final BukkitScheduler scheduler = Bukkit.getScheduler();
    private final CommandSender sender = Bukkit.getConsoleSender();
    private final Plugin plugin = AntiMinehut.getInstance();

    public MinehutPurger() {

    }

    public void purgeAll() {
        scheduler.scheduleSyncDelayedTask(plugin,() -> {
            boolean restart = MinehutChecker.getMinehutFiles().size() != 0;
            Bukkit.broadcastMessage("> requires restart?: " + restart);
            MinehutChecker.getMinehutPlugins().forEach(PluginRemover::removePlugin);
            MinehutChecker.getMinehutFiles().forEach(PluginRemover::removeFile);
            if (restart && MinehutChecker.getMinehutFiles().size() == 0)
                scheduler.scheduleSyncDelayedTask(plugin,() -> Bukkit.dispatchCommand(sender,"reload confirm"),40);
        },20);
    }
}
