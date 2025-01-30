package com.wenkrang.ecoError.event.task;

import com.wenkrang.ecoError.lib.JavaUse;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class BaseTask implements Listener {
    public final String name;
    public final Material icon;
    public CameraTask[] cameraTasks;
    private static final List<BaseTask> tasks = new ArrayList<>();
    public BaseTask(String name, @Nullable Material icon, @Nullable CameraTask... cameraTasks) {
        this.name = name;
        this.icon = JavaUse.nNqm(icon, Material.BEDROCK);
        this.cameraTasks = cameraTasks;
        tasks.add(this);
    }
    public void registerTask(JavaPlugin plugin) {
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
    }
    public static List<BaseTask> getAllTasks() {
        return tasks;
    }
    public boolean isCompleted() {
        final var ret = new AtomicBoolean(true);
        Arrays.stream(cameraTasks).forEach(i -> ret.set(i.isCompleted() && ret.get()));
        return ret.get();
    }
    public static class CameraTask {
        public final String name;
        private final String parentName;
        private final YamlConfiguration yamlConf;
        public CameraTask(String name, String parentName) {
            this.name = name;
            this.parentName = parentName;
            yamlConf = new YamlConfiguration();
            try {
                final var f1 = new File("./plugins/EcoError/task.yaml");
                if (!f1.exists())
                    if (!f1.createNewFile())
                        Bukkit.getConsoleSender().sendMessage("阿巴阿巴");
                yamlConf.load(f1);
            } catch (Exception ignored) {}
        }

        //一些任务需要override该方法
        public void complete(@Nonnull Player completedBy) {
            Bukkit.broadcastMessage("玩家" + completedBy.getName() + "刚刚拍摄了照片" + name);
            completedBy.getInventory().addItem(new ItemStack(Material.MAP)/*todo：拍摄照片*/);
            yamlConf.set(parentName + "." + name + ".completed", true);
            final var list = new ArrayList<>(Arrays.stream(getCompletePlayers()).toList());
            list.add(completedBy.getUniqueId());
            yamlConf.set(parentName + "." + name + ".complete-players", list.stream().map(UUID::toString));
            try {
                yamlConf.save("./plugins/EcoError/task.yaml");
            } catch (Exception ignored) {}
        }

        public boolean isCompleted() {
            return yamlConf.getBoolean(parentName + "." + name + ".completed");
        }

        public UUID[] getCompletePlayers() {
            return yamlConf.getStringList(parentName + "." + name + ".complete-players")
                    .stream()
                    .map(UUID::fromString)
                    .toArray(UUID[]::new);
        }
    }
}
