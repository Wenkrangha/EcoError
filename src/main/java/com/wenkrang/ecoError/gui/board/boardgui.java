package com.wenkrang.ecoError.gui.board;

import com.wenkrang.ecoError.gui.board.lib.updata;
import com.wenkrang.ecoError.item.boarditem;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.util.ArrayList;

public class boardgui {
    public static void openboard (Player player) throws IOException, InvalidConfigurationException {
        Inventory inventory = Bukkit.createInventory(null,27,"紧急公告-神秘年兽");
        inventory.setItem(0, boarditem.background_item());
        inventory.setItem(1, boarditem.background_item());
        inventory.setItem(2, boarditem.background_item());
        inventory.setItem(3, boarditem.background_item());
        inventory.setItem(4, boarditem.background_item());
        inventory.setItem(5, boarditem.background_item());
        inventory.setItem(6, boarditem.background_item());
        inventory.setItem(7, boarditem.background_item());
        inventory.setItem(8, boarditem.background_item());
        inventory.setItem(9, boarditem.background_item());
        inventory.setItem(10, boarditem.borad_head());
        inventory.setItem(11, boarditem.background_item());
        inventory.setItem(17, boarditem.background_item());
        inventory.setItem(18, boarditem.background_item());
        inventory.setItem(19, boarditem.background_item());
        inventory.setItem(20, boarditem.background_item());
        inventory.setItem(21, boarditem.background_item());
        inventory.setItem(22, boarditem.background_item());
        inventory.setItem(23, boarditem.background_item());
        inventory.setItem(24, boarditem.background_item());
        inventory.setItem(25, boarditem.background_item());
        inventory.setItem(26, boarditem.background_item());

        YamlConfiguration yamlConfiguration = new YamlConfiguration();
        yamlConfiguration.load("./plugins/EcoError/player/" + player.getPlayer().getUniqueId().toString() + ".yaml");
        ArrayList<ItemStack> arrayList = new ArrayList<>();
        if (yamlConfiguration.getString("1").equalsIgnoreCase("no")){
            arrayList.add(boarditem.head_sure());
        }
        if (yamlConfiguration.getString("2").equalsIgnoreCase("no")){
            arrayList.add(boarditem.get_book());
        }
        if (yamlConfiguration.getString("3").equalsIgnoreCase("no")){
            arrayList.add(boarditem.get_camara());
        }
        if (yamlConfiguration.getString("4").equalsIgnoreCase("no")){
            arrayList.add(boarditem.getsure());
        }

        updata.updateboardgui(inventory,arrayList);

        player.openInventory(inventory);

    }
}
