package com.wenkrang.ecoError.event.board;

import com.wenkrang.ecoError.gui.board.BoardGUI;
import com.wenkrang.ecoError.lib.JavaUse;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class BoardPlayerJoin implements Listener {
    @EventHandler
    public static void onPlayerJoin(@Nonnull PlayerJoinEvent event) throws IOException, InvalidConfigurationException {
        File file = new File("./plugins/EcoError/player/" + event.getPlayer().getUniqueId().toString() + ".yaml");
        YamlConfiguration yamlConfiguration = new YamlConfiguration();
        if (!file.exists()) {
            yamlConfiguration.set("1", "no");
            yamlConfiguration.set("2", "no");
            yamlConfiguration.set("3", "no");
            yamlConfiguration.set("4", "no");
            yamlConfiguration.save("./plugins/EcoError/player/" + event.getPlayer().getUniqueId().toString() + ".yaml");
        }

        if (!(JavaUse.nn(yamlConfiguration.getString("1")).equalsIgnoreCase("yes") && yamlConfiguration.getString("2").equalsIgnoreCase("yes") && yamlConfiguration.getString("3").equalsIgnoreCase("yes") && yamlConfiguration.getString("4").equalsIgnoreCase("yes"))) {
            BoardGUI.openboard(event.getPlayer());
        }
    }
}
