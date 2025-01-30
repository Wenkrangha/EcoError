package com.wenkrang.ecoError.lib.TaskCentre;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class TaskSystem {
    public static ArrayList<NianTask> nianTasks = new ArrayList<>();

    public static ArrayList<NianTask> getNianTasks() {
        return nianTasks;
    }

    public static void addTask(NianTask nianTask){
        nianTasks.add(nianTask);
    }

    public static void complete(Player player, NianTask nianTask) {

    }
}
