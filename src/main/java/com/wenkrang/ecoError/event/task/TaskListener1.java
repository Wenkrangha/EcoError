package com.wenkrang.ecoError.event.task;

import com.wenkrang.ecoError.EcoError;
import com.wenkrang.ecoError.item.PublicItem;
import com.wenkrang.ecoError.lib.JavaUse;
import org.bukkit.Material;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import javax.annotation.Nonnull;

//此处null修改为实际描述
public class TaskListener1 implements Listener {
    @EventHandler
    public void onTask11Complete(@Nonnull CraftItemEvent event) {
        final var photo11 = PublicItem.get_photo("新年鞭炮", "null");
        if (event.getRecipe().getResult() == PublicItem.getFirework()) {
            if (!event.getWhoClicked().getInventory().contains(photo11))
                event.getWhoClicked().getInventory().addItem(photo11);
        }
    }

    @EventHandler
    public void onTask12Complete(@Nonnull PlayerInteractEvent event) {
        if (event.getItem() == PublicItem.get_camara(event.getPlayer())) {
            if (event.getPlayer()
                    //获取周围实体
                    .getNearbyEntities(8, 8, 8).stream()
                    //检测是否有烟花掉落物
                    .anyMatch(i -> i.getType() == EntityType.ITEM
                            && ((Item)i).getItemStack() == PublicItem.getFirework()) &&
                    event.getPlayer()
                            //获取周围实体
                            .getNearbyEntities(8, 8, 8).stream()
                            //检测是否有下界之星掉落物
                            .anyMatch(i -> i.getType() == EntityType.ITEM
                                    && ((Item)i).getItemStack().getType() == Material.NETHER_STAR)) {
                ((Enderman) event.getPlayer().getWorld().spawnEntity(
                        event.getPlayer().getLocation(),
                        EntityType.ENDERMAN
                )).setCarriedMaterial(JavaUse.nn(PublicItem.getFirework().getData()));
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        PublicItem.get_photo("这是什么？", "null");
                    }
                }.runTaskLaterAsynchronously(JavaPlugin.getPlugin(EcoError.class), 5000);
            }
        }
    }
}
