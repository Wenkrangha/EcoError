package com.wenkrang.ecoError.event.board;

import com.wenkrang.ecoError.gui.board.boardgui;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

import java.io.IOException;

public class BoardInvClose implements Listener {
    @EventHandler
    public static void InvClose(InventoryCloseEvent event) throws IOException, InvalidConfigurationException {
        if (event.getView().getTitle().equalsIgnoreCase("紧急公告-神秘年兽")){
            YamlConfiguration yamlConfiguration = new YamlConfiguration();
            yamlConfiguration.load("./plugins/EcoError/player/" + event.getPlayer().getUniqueId().toString() + ".yaml");
            if (!(yamlConfiguration.getString("1").equalsIgnoreCase("yes") && yamlConfiguration.getString("2").equalsIgnoreCase("yes") && yamlConfiguration.getString("3").equalsIgnoreCase("yes") && yamlConfiguration.getString("4").equalsIgnoreCase("yes"))) {
                boardgui.openboard((Player) event.getPlayer());
            }
        }
    }
}
