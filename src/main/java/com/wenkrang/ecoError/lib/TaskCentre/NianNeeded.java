package com.wenkrang.ecoError.lib.TaskCentre;

import org.bukkit.inventory.ItemStack;

public class NianNeeded extends CraftNeeded{
    //任务的名字
    private final String name;
    //任务的解释
    private final String describe;
    //任务的需要提交物
    private final ItemStack itemStack;

    public NianNeeded(String name, String describe, ItemStack itemStack) {
        this.name = name;
        this.describe = describe;
        this.itemStack = itemStack;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getDescribe() {
        return "";
    }

    @Override
    public ItemStack getItemStack() {
        return null;
    }
}
