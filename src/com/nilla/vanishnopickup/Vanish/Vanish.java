package com.nilla.vanishnopickup.Vanish;

import com.nilla.vanishnopickup.Permissions.Permission;
import com.nilla.vanishnopickup.Utils.StringToPlayer;
import com.nilla.vanishnopickup.VanishNoPickup;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * @author Acrobot
 */
public class Vanish {
    public static void vanish(Player p) {
        if (VanishNoPickup.getInvisible().contains(p.getName())) {
            showPlayer(p);
        } else {
            hidePlayer(p);
        }
    }

    private static void showPlayer(Player p) {
       VanishNoPickup.getInvisible().remove(p.getName());
       NoPickup.enablePickup(p);
        
        for (Player player : VanishNoPickup.getBukkitServer().getOnlinePlayers()) {
            player.showPlayer(p);
        }

        VanishNoPickup.log.info(p.getName() + " reappeared.");
        p.sendMessage(ChatColor.RED + "You have reappeared!");
    }

    private static void hidePlayer(Player p) {
        VanishNoPickup.getInvisible().add(p.getName());
        NoPickup.disablePickup(p);

        for (Player player : VanishNoPickup.getBukkitServer().getOnlinePlayers()) {
            if (!player.equals(p)) hide(player, p);
        }

        VanishNoPickup.log.info(p.getName() + " disappeared.");
        p.sendMessage(ChatColor.RED + "You have disappeared!");
    }
    
    public static void hideHidden(Player normal) {
        for (Player p : StringToPlayer.getFromString(VanishNoPickup.getInvisible())) {
            hide(normal, p);
        }
    }
    
    public static void hide(Player normal, Player hidden) {
        if (!Permission.has(normal, Permission.DONT_HIDE) 
                || (Permission.has(hidden, Permission.ADMIN) 
                && !Permission.has(normal, Permission.DONT_HIDE_ADMINS))) {
            normal.hidePlayer(hidden);
        }
    }

    public static void showAll() {
        for (Player p : VanishNoPickup.getBukkitServer().getOnlinePlayers()) {
            for (Player hidden : StringToPlayer.getFromString(VanishNoPickup.getInvisible())) {
                p.showPlayer(hidden);
            }
        }
    }
}
