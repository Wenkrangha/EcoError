package com.wenkrang.ecoError;

import com.wenkrang.ecoError.command.EcoCommand;
import com.wenkrang.ecoError.event.board.BoardInvClose;
import com.wenkrang.ecoError.event.board.BoardPlayerJoin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class EcoError extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("ee").setExecutor(new EcoCommand());

        getServer().getPluginManager().registerEvents(new BoardPlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new BoardInvClose(), this);

        File file = new File("./plugins/EcoError/player/");
        file.mkdirs();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
