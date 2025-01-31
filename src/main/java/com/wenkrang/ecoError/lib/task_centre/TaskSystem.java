package com.wenkrang.ecoError.lib.task_centre;

import com.wenkrang.ecoError.PublicData;
import com.wenkrang.ecoError.lib.Fireworks;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class TaskSystem {
    public static ArrayList<NianTask> nianTasks = new ArrayList<>();

    public static ArrayList<NianTask> getNianTasks() {
        return nianTasks;
    }

    public static void addTask(NianTask nianTask){
        nianTasks.add(nianTask);
    }

    public static void complete(Player player, NianTask nianTask) throws IOException, InvalidConfigurationException {
        YamlConfiguration yamlConfiguration = new YamlConfiguration();
        yamlConfiguration.load(PublicData.yamlfile(player));
        yamlConfiguration.set("complete-" + nianTask.getName(), true);
        yamlConfiguration.save(PublicData.yamlfile(player));
        Fireworks.play(player, (byte) 3);
        Bukkit.broadcastMessage("§9[*]§f " + player.getName() + " 刚才完成了任务 " + nianTask.getName());
    }

    public static boolean isCompleted(Player player, NianTask nianTask) throws IOException, InvalidConfigurationException {
        YamlConfiguration yamlConfiguration = new YamlConfiguration();
        yamlConfiguration.load(PublicData.yamlfile(player));
        return yamlConfiguration.getBoolean("complete-" + nianTask.getName());
    }

    public static ArrayList<Player> getCompletedPlayers(NianTask nianTask) throws IOException, InvalidConfigurationException {
        File file = new File("./plugins/EcoError/player/");

        ArrayList<Player> arrayList = new ArrayList<>();

        for (File YamlFile : file.listFiles()) {
            YamlConfiguration yamlConfiguration = new YamlConfiguration();
            yamlConfiguration.load(YamlFile);
            if (yamlConfiguration.getBoolean("complete-" + nianTask.getName())) {
                String name = YamlFile.getName();
                String replace = name.replace(".yaml", "");
                OfflinePlayer player = Bukkit.getOfflinePlayer(UUID.fromString(replace));
                arrayList.add((Player) player);
            }
        }

        return arrayList;
    }
}
