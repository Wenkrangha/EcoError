package com.wenkrang.ecoError;

import com.wenkrang.ecoError.command.EcoCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class EcoError extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        //?//不做指令也可以
        //不做也可以了
        //命令
        //最好做
        this.getCommand("ee").setExecutor(new EcoCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
