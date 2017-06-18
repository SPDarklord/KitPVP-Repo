package net.pvping.kitpvp;

import net.pvping.kitpvp.listeners.Death;
import net.pvping.kitpvp.listeners.Hunger;
import net.pvping.kitpvp.listeners.SoupEat;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Thomas on 09/02/2017.
 */
public class KitPvp extends JavaPlugin{

    public static KitPvp plugin;

    @Override
    public void onEnable() {
        plugin = this;
        registerEventListeners();
    }

    public  void registerEventListeners(){
        Bukkit.getPluginManager().registerEvents(new Death(), this);
        Bukkit.getPluginManager().registerEvents(new Hunger(), this);
        Bukkit.getPluginManager().registerEvents(new SoupEat(), this);
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public static KitPvp getInstance() {
        return plugin;
    }

}
