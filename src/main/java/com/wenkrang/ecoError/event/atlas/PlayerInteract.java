package com.wenkrang.ecoError.event.atlas;

import com.wenkrang.ecoError.item.PublicItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.EquipmentSlot;

public class PlayerInteract implements Listener {
    @EventHandler
    public static void onHeld(PlayerInteractEvent event) {
        if ((event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) && event.getHand().equals(EquipmentSlot.HAND)) {
            if (event.getPlayer().getInventory().getItemInMainHand().equals(PublicItem.get_book())) {

            }
        }
    }
}
