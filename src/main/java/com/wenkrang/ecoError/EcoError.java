package com.wenkrang.ecoError;

import com.wenkrang.ecoError.command.EcoCommand;
import com.wenkrang.ecoError.event.board.BoardGuiClick;
import com.wenkrang.ecoError.event.board.BoardPlayerJoin;
import com.wenkrang.ecoError.event.board.FireworkDamage;
import com.wenkrang.ecoError.lib.JavaUse;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class EcoError extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        JavaUse.nn(this.getCommand("ee")).setExecutor(new EcoCommand());

        JavaUse.let(getServer().getPluginManager(), i -> {
            i.registerEvents(new BoardPlayerJoin(), this);
            i.registerEvents(new BoardGuiClick(), this);
            i.registerEvents(new FireworkDamage(), this);
        });

        File file = new File("./plugins/EcoError/player/");
        file.mkdirs();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
