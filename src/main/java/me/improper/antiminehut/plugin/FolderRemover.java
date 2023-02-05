package me.improper.antiminehut.plugin;

import org.bukkit.Bukkit;

import java.io.File;

public abstract class FolderRemover {

    public static void removeFolder(File folder) {
        File[] files = folder.listFiles();
        if (files == null) return;
        for (File file : files)
            if (!file.delete()) removeFolder(file);
            else Bukkit.broadcastMessage("> subfile deleted: " + file.getPath());
    }
}
