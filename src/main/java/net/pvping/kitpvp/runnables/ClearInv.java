package net.pvping.kitpvp.runnables;

import org.bukkit.entity.Player;

/**
 * Created by Thomas on 09/02/2017.
 */
public class ClearInv {

    public void clearInv(Player player){
        player.getInventory().clear();
    }

    public void clearArmour(Player player){
        player.getInventory().setArmorContents(null);
    }

    public void clearAll(Player player){
        player.getInventory().clear();
        player.getInventory().setArmorContents(null);
    }

}
