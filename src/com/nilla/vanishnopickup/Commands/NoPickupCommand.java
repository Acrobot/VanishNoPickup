package com.nilla.vanishnopickup.Commands;

import com.nilla.vanishnopickup.Permissions.Permission;
import com.nilla.vanishnopickup.Utils.StringToPlayer;
import com.nilla.vanishnopickup.Vanish.NoPickup;
import com.nilla.vanishnopickup.VanishNoPickup;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Set;

/**
 * @author Acrobot
 */
public class NoPickupCommand implements CommandExecutor{
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if (!Permission.has(sender, Permission.NO_PICKUP)) return false;

        if (args.length > 0 && args[0].equalsIgnoreCase("list")) {
            return noPickupList(sender);
        }
        
        return noPickup(sender);
    }

    private boolean noPickup(CommandSender sender) {
        if (!(sender instanceof Player)) return false;

        NoPickup.noPickup((Player) sender);

        return true;
    }

    private boolean noPickupList(CommandSender sender) {
        if (!Permission.has(sender, Permission.NO_PICKUP_LIST)) return false;

        Set<String> noPickup = VanishNoPickup.getNoPickup();

        if (noPickup.size() == 0) {
            sender.sendMessage(ChatColor.RED + "No players found");
            return true;
        }

        StringBuilder message = new StringBuilder();
        message.append("List of players with item pickup disabled: ").append('\n');

        for (Player p : StringToPlayer.getFromString(noPickup)) {
            message.append(ChatColor.WHITE).append(p.getName()).append(' ');
        }

        sender.sendMessage(ChatColor.RED + message.toString());

        return true;
    }
}
