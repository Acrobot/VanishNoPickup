package com.nilla.vanishnopickup.Commands;

import com.nilla.vanishnopickup.Permissions.Permission;
import com.nilla.vanishnopickup.Vanish.Vanish;
import com.nilla.vanishnopickup.Utils.StringToPlayer;
import com.nilla.vanishnopickup.VanishNoPickup;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Set;

/**
 * The /vanish command
 * @author Acrobot
 */
public class VanishCommand implements CommandExecutor{
    public boolean onCommand(CommandSender commandSender, Command command, String alias, String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("list")) {
            return listVanished(commandSender);
        }

        return vanish(commandSender);
    }

    private static boolean listVanished(CommandSender sender) {
        if (!Permission.has(sender, Permission.VANISH_LIST)) return false;

        Set<String> invisible = VanishNoPickup.getInvisible();

        if (invisible.size() == 0) {
            sender.sendMessage(ChatColor.RED + "No invisible players found");
            return true;
        }

        StringBuilder message = new StringBuilder();
        message.append("List of Invisible Players: ").append('\n');

        for (Player p : StringToPlayer.getFromString(invisible)) {
            message.append(ChatColor.WHITE).append(p.getName()).append(' ');
        }

        sender.sendMessage(ChatColor.RED + message.toString());

        return true;
    }

    private static boolean vanish(CommandSender sender) {
        if (!Permission.has(sender, Permission.VANISH) || !(sender instanceof Player)) return false;

        Vanish.vanish((Player) sender);
        return true;
    }
}
