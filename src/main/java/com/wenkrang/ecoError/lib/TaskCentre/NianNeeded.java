package com.wenkrang.ecoError.lib.TaskCentre;

import org.bukkit.inventory.ItemStack;

public class NianNeeded extends CraftNeeded{

    //任务的需要提交物
    private final ItemStack itemStack;

    public NianNeeded(ItemStack itemStack) {

        this.itemStack = itemStack;
    }

    @Override
    public ItemStack getItemStack() {
        return null;
    }
}
