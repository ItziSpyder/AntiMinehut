package me.improper.antiminehut.plugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class MinehutChecker {

    public static final File pluginFolder = new File("plugins/");
    public static final PluginManager pluginManager = Bukkit.getPluginManager();

    public static List<Plugin> getMinehutPlugins() {
        List<Plugin> list = new ArrayList<>();
        Plugin[] plugins = pluginManager.getPlugins();
        for (Plugin plugin : plugins) {
            if (plugin == null) continue;
            String name = plugin.getName().toLowerCase();
            if (name.contains("minehut") && !name.contains("antiminehut")) list.add(plugin);
        }
        return list;
    }

    public static List<File> getMinehutFiles() {
        List<File> list = new ArrayList<>();
        File[] files = pluginFolder.listFiles();
        for (File file : files) {
            if (file == null) continue;
            String name = file.getName().toLowerCase();
            if (name.contains("minehut") && !name.contains("antiminehut")) list.add(file);
        }
        return list;
    }
}
