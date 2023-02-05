package me.improper.antiminehut.plugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import java.io.File;

public abstract class PluginRemover {

    private static final PluginManager pluginManager = Bukkit.getPluginManager();

    public static void removePlugin(Plugin plugin) {
        plugin.onDisable();
        pluginManager.disablePlugin(plugin);
        Bukkit.broadcastMessage("> plugin disabled: " + plugin.getName());
        File dataFolder = plugin.getDataFolder();
        if (dataFolder.exists()) FolderRemover.removeFolder(dataFolder);
    }

    public static void removeFile(File file) {
        if (file.exists() && file.delete())
            Bukkit.broadcastMessage("> file removed: " + file.getPath());
    }
}
