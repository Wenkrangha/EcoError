package com.wenkrang.ecoError.lib.TaskCentre;

import org.bukkit.inventory.ItemStack;

public abstract class CraftNeeded {
    //获取名字
    public abstract String getName();
    //获取解释
    public abstract String getDescribe();
    //获取需要的照片
    public abstract ItemStack getItemStack();
}
