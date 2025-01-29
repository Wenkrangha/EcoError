package com.wenkrang.ecoError.gui.board.lib;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class updata {
    public static void updateboardgui (Inventory inventory, ArrayList<ItemStack> arrayList) {
        for (int i = 12;i < 15;i++) {
            inventory.setItem(i, arrayList.get(i - 12));
        }
    }
}
