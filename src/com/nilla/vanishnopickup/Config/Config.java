package com.nilla.vanishnopickup.Config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Acrobot
 */
public class Config {
    public static FileConfiguration config;
    
    public static void initialize(JavaPlugin plugin){
        config = plugin.getConfig();
        config.addDefault("range", 512);
    }
    
    public static int getRange() {
        return config.getInt("range", 512);
    }
}
