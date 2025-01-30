package com.wenkrang.ecoError.lib;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Fireworks {
    public static void play(@Nonnull Player player, @Nullable Byte number /*真的可空*/) {
        final var colours = new Color[]{Color.RED, Color.ORANGE};
        for (var i = 0; i < JavaUse.nNqm(number, (byte)1); i++) {
            player.getWorld().spawn(player.getLocation(), Firework.class).getFireworkMeta()
                    .addEffect(FireworkEffect.builder()
                            .withFlicker()
                            .withTrail()
                            .with(FireworkEffect.Type.CREEPER)
                            .withColor(colours[i % 2])
                            .withFade(colours[(i + 1) % 2])
                            .build());
        }
    }
}
