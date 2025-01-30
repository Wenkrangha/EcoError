package com.wenkrang.ecoError.gui.board;

import com.wenkrang.ecoError.lib.board.Update;
import com.wenkrang.ecoError.item.BoardItem;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.util.ArrayList;

public class BoardGUI {
    public static void openboard (Player player) throws IOException, InvalidConfigurationException {
        Inventory inventory = Bukkit.createInventory(null,27,"紧急公告-神秘年兽");
        inventory.setItem(0, BoardItem.background_item());
        inventory.setItem(1, BoardItem.background_item());
        inventory.setItem(2, BoardItem.background_item());
        inventory.setItem(3, BoardItem.background_item());
        inventory.setItem(4, BoardItem.background_item());
        inventory.setItem(5, BoardItem.background_item());
        inventory.setItem(6, BoardItem.background_item());
        inventory.setItem(7, BoardItem.background_item());
        inventory.setItem(8, BoardItem.background_item());
        inventory.setItem(9, BoardItem.background_item());
        inventory.setItem(10, BoardItem.boardHead());
        inventory.setItem(11, BoardItem.background_item());
        inventory.setItem(17, BoardItem.background_item());
        inventory.setItem(18, BoardItem.background_item());
        inventory.setItem(19, BoardItem.background_item());
        inventory.setItem(20, BoardItem.background_item());
        inventory.setItem(21, BoardItem.background_item());
        inventory.setItem(22, BoardItem.background_item());
        inventory.setItem(23, BoardItem.background_item());
        inventory.setItem(24, BoardItem.background_item());
        inventory.setItem(25, BoardItem.background_item());
        inventory.setItem(26, BoardItem.background_item());

        YamlConfiguration yamlConfiguration = new YamlConfiguration();
        yamlConfiguration.load("./plugins/EcoError/player/" + player.getPlayer().getUniqueId().toString() + ".yaml");
        ArrayList<ItemStack> arrayList = new ArrayList<>();
        if (yamlConfiguration.getString("1").equalsIgnoreCase("no")){
            arrayList.add(BoardItem.head_sure());

        }
        if (yamlConfiguration.getString("2").equalsIgnoreCase("no")){
            arrayList.add(BoardItem.get_book());

        }
        if (yamlConfiguration.getString("3").equalsIgnoreCase("no")){
            arrayList.add(BoardItem.get_camara());

        }
        if (yamlConfiguration.getString("4").equalsIgnoreCase("no")){
            arrayList.add(BoardItem.getsure());

        }


        Update.updateBoardGUI(inventory,arrayList);

        player.openInventory(inventory);

    }
}
