package com.nilla.vanishnopickup;

import com.nilla.vanishnopickup.Commands.NoPickupCommand;
import com.nilla.vanishnopickup.Commands.VanishCommand;
import com.nilla.vanishnopickup.Listeners.Listener;
import com.nilla.vanishnopickup.Vanish.Vanish;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;


/**
 * Vanish for Bukkit
 *
 * @author Nodren - original version
 * @author Acrobot - the complete rewrite
 */
public class VanishNoPickup extends JavaPlugin {

    public static final Set<String> invisible = new HashSet<String>();
    public static final Set<String> nopickups = new HashSet<String>();
    
    public static Logger log;
    public static Server bukkitServer;
    
    public void onEnable() {
        bukkitServer = getServer();
        log = getLogger();

        registerCommands();
        registerEvents();
    }

    public void onDisable() {
        Vanish.showAll();

        invisible.clear();
        nopickups.clear();
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new Listener(), this);
    }

    private void registerCommands() {
        getCommand("vanish").setExecutor(new VanishCommand());
        getCommand("nopickup").setExecutor(new NoPickupCommand());
    }

    public static Set<String> getInvisible() {
        return invisible;
    }
    
    public static Set<String> getNoPickup() {
        return nopickups;
    }
    
    public static Server getBukkitServer() {
        return bukkitServer;
    }
    
    public static boolean isInvisible(Player p) {
        return invisible.contains(p.getName());
    }
    
    public static boolean noPickup(Player p) {
        return nopickups.contains(p.getName());
    }
}
