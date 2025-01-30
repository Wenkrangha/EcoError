package com.wenkrang.ecoError.event.task;

import com.wenkrang.ecoError.EcoError;
import com.wenkrang.ecoError.item.PublicItem;
import com.wenkrang.ecoError.lib.JavaUse;
import org.bukkit.Material;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import javax.annotation.Nonnull;
import java.util.Arrays;

public class Task1 extends BaseTask {
    public Task1() {
        super("年兽异样", Material.TNT_MINECART);
        cameraTasks = new CameraTask[]{
                new CameraTask("新年鞭炮", "年兽异样"),
                new CameraTask("这是什么？", "年兽异样")
        };
    }

    @EventHandler
    public void onTask11Complete(@Nonnull CraftItemEvent event) {
        if (event.getRecipe().getResult() == PublicItem.getFirework()) {
            if (Arrays.stream(cameraTasks[0].getCompletePlayers())
                    .noneMatch(uuid -> uuid.equals(event.getWhoClicked().getUniqueId()))
            ) cameraTasks[0].complete((Player) event.getWhoClicked());
        }
    }

    @EventHandler
    public void onTask12Complete(@Nonnull PlayerInteractEvent event) {
        if (event.getItem() == PublicItem.get_camara()) {
            if (event.getPlayer()
                    .getNearbyEntities(8, 8, 8)
                    .stream().anyMatch(i -> i.getType() == EntityType.ITEM
                    && ((Item)i).getItemStack() == PublicItem.getFirework()) &&
                    event.getPlayer()
                            .getNearbyEntities(8, 8, 8)
                            .stream().anyMatch(i -> i.getType() == EntityType.ITEM
                                    && ((Item)i).getItemStack().getType() == Material.NETHER_STAR)) {
                ((Enderman) event.getPlayer().getWorld().spawnEntity(
                        event.getPlayer()
                                .getNearbyEntities(8, 8, 8)
                                .getFirst()
                                .getLocation(),
                        EntityType.ENDERMAN
                )).setCarriedMaterial(JavaUse.nn(PublicItem.getFirework().getData()));
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        cameraTasks[1].complete(event.getPlayer());
                    }
                }.runTaskLater(JavaPlugin.getPlugin(EcoError.class), 5000);
            }
        }
    }
}
