package com.wenkrang.ecoError.event.board;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import javax.annotation.Nonnull;

public final class FireworkDamage implements Listener {
    @EventHandler
    public void onDamage(@Nonnull EntityDamageEvent event) {
        switch (event.getCause()) {
            case PROJECTILE:
                if (event.getEntity().getType() == EntityType.PLAYER) {
                    event.setCancelled(true);
                } else if (false/*todo 判断被伤害实体是否为年兽*/) {
                    event.setDamage(event.getDamage() * 5/*todo 伤害*/);
                }
            case ENTITY_ATTACK:
                //todo
                break;
            default:
                break;
        }
    }
}
