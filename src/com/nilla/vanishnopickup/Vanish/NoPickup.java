package com.nilla.vanishnopickup.Vanish;

import com.nilla.vanishnopickup.VanishNoPickup;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * @author Acrobot
 */
public class NoPickup {
    public static void noPickup(Player p) {
        if (VanishNoPickup.getNoPickup().contains(p.getName())) {
            p.sendMessage(ChatColor.RED + "Enabling item picking up");
            enablePickup(p);
        } else {
            p.sendMessage(ChatColor.RED + "Disabling item picking up");
            disablePickup(p);
        }
    }

    public static void disablePickup(Player p) {
        VanishNoPickup.getNoPickup().add(p.getName());
    }

    public static void enablePickup(Player p) {
        VanishNoPickup.getNoPickup().remove(p.getName());
    }
}
