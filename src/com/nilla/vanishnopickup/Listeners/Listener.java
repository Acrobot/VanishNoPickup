package com.nilla.vanishnopickup.Listeners;

import com.nilla.vanishnopickup.Permissions.Permission;
import com.nilla.vanishnopickup.Vanish.Vanish;
import com.nilla.vanishnopickup.VanishNoPickup;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

/**
 * @author Acrobot
 */
public class Listener implements org.bukkit.event.Listener {
    @EventHandler
    public static void onJoin(PlayerJoinEvent event) {
        Vanish.hideHidden(event.getPlayer());
    }

    @EventHandler
    public static void onPickup(PlayerPickupItemEvent event) {
        Player p = event.getPlayer();

        if (!VanishNoPickup.noPickup(p)) return;

        event.setCancelled(true);
    }
    
    @EventHandler
    public static void onTarget(EntityTargetEvent event) {
        Entity e = event.getTarget();
        if (!(e instanceof Player)) return;
        
        Player player = (Player) e;
        
        if (!Permission.has(player, Permission.NO_AGGRESIVE_MOBS)) return;

        event.setCancelled(true);
    }
}
