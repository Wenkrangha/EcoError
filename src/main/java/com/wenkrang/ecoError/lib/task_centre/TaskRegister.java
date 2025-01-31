package com.wenkrang.ecoError.lib.task_centre;

import com.wenkrang.ecoError.EcoError;
import com.wenkrang.ecoError.event.task.TaskListener1;
import com.wenkrang.ecoError.item.PublicItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class TaskRegister {
    public static void registerTask() {
        {
            //此处null修改为实际描述
            final var task = new NianTask("鞭炮异样", "null", new ArrayList<>(){
                {
                    add(new NianNeeded(PublicItem.get_photo("新年鞭炮", "null")));
                    add(new NianNeeded(PublicItem.get_photo("这是什么？", "null")));
                }
            }, Material.TNT_MINECART);
            TaskSystem.addTask(task);
            Bukkit.getServer().getPluginManager().registerEvents(new TaskListener1(),
                    JavaPlugin.getPlugin(EcoError.class));
        }
    }
}
