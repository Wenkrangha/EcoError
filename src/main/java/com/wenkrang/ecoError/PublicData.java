package com.wenkrang.ecoError;

import org.bukkit.entity.Player;

import java.io.File;

public class PublicData {
    public static File yamlfile(Player player) {
        return new File("./plugins/EcoError/player/" + player.getPlayer().getUniqueId().toString() + ".yaml");
    }
}
