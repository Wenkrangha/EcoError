package com.wenkrang.ecoError.lib.TaskCentre;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public abstract class CraftTask {
    //获取名字
    public abstract String getName();
    //获取解释
    public abstract String getDescribe();
    //获取图标
    public abstract ItemStack getItemStack();
    //获取图标
    public abstract Material getMaterial();
    //获取需要列表
    public abstract ArrayList<CraftNeeded> getNeededList();
}
