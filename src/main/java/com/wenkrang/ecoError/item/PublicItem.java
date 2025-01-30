package com.wenkrang.ecoError.item;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class PublicItem {
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
    public static ItemStack get_camara(Player player) {
        ItemStack itemStack = new ItemStack(Material.OBSERVER);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setItemName("§f相§9机");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("§7你可以用它来拍一些照片，但只能是图册中要求");
        arrayList.add("§7的，但它很神奇，不需要纸");
        arrayList.add("§7相机主人的UUID：" + player.getUniqueId());
        arrayList.add("§7( 这个相机只能完成相机主人的任务 )");
        arrayList.add("");
        arrayList.add("§6右键 §f拍照");
        itemMeta.setLore(arrayList);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static List<String> splitEveryNChars(String str, int n) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < str.length()) {
            result.add("§7" + str.substring(index, Math.min(index + n, str.length())));
            index += n;
        }
        return result;
    }
    /**
     * 用于生成完成任务的照片
     * @param name 相片的名字，自动加《》
     * @param describe 相片的解释
     * @return
     */
    public static ItemStack get_photo(String name,String describe) {
        ItemStack itemStack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("《" + name + "》");

        List<String> strings = splitEveryNChars(describe, 20);

        itemMeta.setLore(strings);

        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
}
