package com.nilla.vanishnopickup.Permissions;

import org.bukkit.command.CommandSender;

/**
 * @author Acrobot
 */
public enum Permission {
    VANISH_LIST("vanish.vanish.list"),
    VANISH("vanish.vanish"),

    NO_PICKUP_LIST("vanish.nopickup.list"),
    NO_PICKUP("vanish.nopickup"),

    DONT_HIDE("vanish.dont.hide"),
    DONT_HIDE_ADMINS("vanish.dont.hide.admins"),

    NO_AGGRESIVE_MOBS("vanish.noaggromobs"),

    ADMIN("vanish.admin");
    
    private String permission;
    
    Permission(String permission) {
        this.permission = permission;
    }
    
    private String getPermission() {
        return permission;
    }
    
    public static boolean has(CommandSender p, Permission perm) {
        return p.hasPermission(perm.getPermission());
    }
}
