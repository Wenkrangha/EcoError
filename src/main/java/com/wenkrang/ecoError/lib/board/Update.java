package com.wenkrang.ecoError.lib.board;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Update {
    public static void updateBoardGUI(Inventory inventory, ArrayList<ItemStack> arrayList) {
        for (int i = 12;i - 12 < arrayList.size();i++) {
            inventory.setItem(i, arrayList.get(i - 12));
        }

    }
}
