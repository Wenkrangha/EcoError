package com.wenkrang.ecoError.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class publicitem {
    public static ItemStack get_book() {
        ItemStack itemStack = new ItemStack(Material.WRITABLE_BOOK);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setItemName("§f图§9册");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("§7这是一本用来装图片的图册，收集完所有的图片后，");
        arrayList.add("§7可以激活BOSS战，恢复经济系统");
        itemMeta.setLore(arrayList);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static ItemStack get_camara() {
        ItemStack itemStack = new ItemStack(Material.OBSERVER);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setItemName("§f相§9机");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("§7你可以用它来拍一些照片，但只能是图册中要求");
        arrayList.add("§7的，但它很神奇，不需要纸");
        arrayList.add("");
        arrayList.add("§6右键 §f拍照");
        itemMeta.setLore(arrayList);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
