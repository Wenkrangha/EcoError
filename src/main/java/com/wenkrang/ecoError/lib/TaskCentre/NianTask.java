package com.wenkrang.ecoError.lib.TaskCentre;

import com.wenkrang.ecoError.lib.Spliter;
import net.md_5.bungee.api.chat.hover.content.Item;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
    public NianTask(String name, String describe, ArrayList<CraftNeeded> NeededList, Material material){
        this.name = name;
        this.describe = describe;
        this.NeededList = NeededList;
        this.material = material;

        if (name != null &&
                describe != null &&
                material != null &&
                NeededList != null) {
            this.itemStack = new ItemStack(material);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName(name);
            itemMeta.setLore(Spliter.splitEveryNChars(describe, 15));
            this.itemStack.setItemMeta(itemMeta);
        }else {
            throw new NullPointerException("空的任务参数");
        }
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
