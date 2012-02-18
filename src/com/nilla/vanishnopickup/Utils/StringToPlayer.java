package com.nilla.vanishnopickup.Utils;

import com.nilla.vanishnopickup.VanishNoPickup;
import org.bukkit.Server;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Acrobot
 */
public class StringToPlayer {
    public static Set<Player> getFromString(Set<String> players) {
        Server server = VanishNoPickup.getBukkitServer();
        Set<Player> pl = new HashSet<Player>();

        for (String s : players) {
            Player player = server.getPlayer(s);
            if (player != null)  pl.add(player);
        }

        return pl;
    }
}
