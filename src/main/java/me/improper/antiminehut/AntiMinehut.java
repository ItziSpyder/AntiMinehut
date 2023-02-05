package me.improper.antiminehut;

import me.improper.antiminehut.commands.AntiMhCommand;
import me.improper.antiminehut.plugin.MinehutPurger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class AntiMinehut extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        MinehutPurger purger = new MinehutPurger();
        purger.purgeAll();

        // Commands
        getCommand("antiminehut").setExecutor(new AntiMhCommand());
        getCommand("antiminehut").setTabCompleter(new AntiMhCommand.AntiMhTab());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Plugin getInstance() {
        return Bukkit.getPluginManager().getPlugin("AntiMinehut");
    }
}
