package com.wenkrang.ecoError.lib.task_centre;

import com.wenkrang.ecoError.lib.JavaUse;
import com.wenkrang.ecoError.lib.Spliter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import java.util.ArrayList;

public class NianTask extends CraftTask{
    //用于存储需要提交的物品
    private final ArrayList<CraftNeeded> NeededList;
    //任务的名字
    private final String name;
    //任务的解释
    private final String describe;
    //任务的图标
    private final Material material;
    //任务需要品
    private final ItemStack itemStack;
    //获取构建器
    public NianTask(@Nonnull String name,
                    @Nonnull String describe,
                    @Nonnull ArrayList<CraftNeeded> NeededList,
                    @Nonnull Material material) {
        //包含空检查
        this.name = JavaUse.nn(name);
        this.describe = JavaUse.nn(describe);
        this.NeededList = JavaUse.nn(NeededList);
        this.material = JavaUse.nn(material);

        this.itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(Spliter.splitEveryNChars(describe, 15));
        this.itemStack.setItemMeta(itemMeta);
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescribe() {
        return this.describe;
    }

    @Override
    public ItemStack getItemStack() {
        return this.itemStack;
    }

    @Override
    public Material getMaterial() {
        return null;
    }

    @Override
    public ArrayList<CraftNeeded> getNeededList() {
        return this.NeededList;
    }

}
