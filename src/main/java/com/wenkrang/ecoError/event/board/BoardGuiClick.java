package com.wenkrang.ecoError.event.board;

import com.wenkrang.ecoError.gui.board.BoardGUI;
import com.wenkrang.ecoError.item.BoardItem;
import com.wenkrang.ecoError.item.PublicItem;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.io.IOException;

public class BoardGuiClick implements Listener {
    @EventHandler
    public static void onclick(InventoryClickEvent event) throws IOException, InvalidConfigurationException {
        if (event.getView().getTitle().equalsIgnoreCase("紧急公告-神秘年兽")){
            YamlConfiguration yamlConfiguration = new YamlConfiguration();
            yamlConfiguration.load("./plugins/EcoError/player/" + event.getView().getPlayer().getUniqueId().toString() + ".yaml");
            if (event.getInventory().getItem(event.getRawSlot()).equals(BoardItem.head_sure())) {
                yamlConfiguration.set("1","yes");
            }
            if (event.getInventory().getItem(event.getRawSlot()).equals(BoardItem.get_book())) {
                yamlConfiguration.set("2","yes");
                event.getView().getPlayer().getInventory().addItem(PublicItem.get_book());
            }
            if (event.getInventory().getItem(event.getRawSlot()).equals(BoardItem.get_camara())) {
                yamlConfiguration.set("3","yes");
                event.getView().getPlayer().getInventory().addItem(PublicItem.get_camara());
            }
            if (event.getInventory().getItem(event.getRawSlot()).equals(BoardItem.getsure()) && yamlConfiguration.getString("1").equalsIgnoreCase("yes") && yamlConfiguration.getString("2").equalsIgnoreCase("yes") && yamlConfiguration.getString("3").equalsIgnoreCase("yes")) {
                yamlConfiguration.set("4","yes");
            }
            yamlConfiguration.save("./plugins/EcoError/player/" + event.getView().getPlayer().getUniqueId().toString() + ".yaml");
            if ((yamlConfiguration.getString("1").equalsIgnoreCase("yes") && yamlConfiguration.getString("2").equalsIgnoreCase("yes") && yamlConfiguration.getString("3").equalsIgnoreCase("yes") && yamlConfiguration.getString("4").equalsIgnoreCase("yes"))) {
                event.getView().getPlayer().closeInventory();
            } else {
                BoardGUI.openboard((Player) event.getView().getPlayer());
            }

            event.setCancelled(true);
        }
    }
}
