package com.wenkrang.ecoError.event.board;

import com.wenkrang.ecoError.lib.JavaUse;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import javax.annotation.Nonnull;

public final class FireworkDamage implements Listener {
    @EventHandler
    @SuppressWarnings("all")
    public void onDamage(@Nonnull EntityDamageEvent event) {
        switch (event.getCause()) {
            case PROJECTILE:
                if (JavaUse.nn(event.getDamageSource().getDirectEntity()).getType()
                        .equals(EntityType.FIREWORK_ROCKET)) {
                    if (event.getEntity().getType() == EntityType.PLAYER) {
                        event.setCancelled(true);
                    } else if (false/*todo 判断被伤害实体是否为年兽*/) {
                        event.setDamage(event.getDamage() * 5/*todo 伤害*/);
                    }
                }
            case ENTITY_ATTACK:
                //todo
                break;
            default:
                break;
        }
    }
}
