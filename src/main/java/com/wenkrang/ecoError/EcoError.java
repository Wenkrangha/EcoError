package com.wenkrang.ecoError;

import com.wenkrang.ecoError.command.EcoCommand;
import com.wenkrang.ecoError.event.board.BoardGuiClick;
import com.wenkrang.ecoError.event.board.BoardPlayerJoin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Objects;

public final class EcoError extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Objects.requireNonNull(this.getCommand("ee")).setExecutor(new EcoCommand());

        getServer().getPluginManager().registerEvents(new BoardPlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new BoardGuiClick(), this);

        File file = new File("./plugins/EcoError/player/");
        file.mkdirs();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
