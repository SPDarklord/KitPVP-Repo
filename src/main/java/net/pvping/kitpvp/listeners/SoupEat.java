package net.pvping.kitpvp.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;

/**
 * Created by Thomas on 09/02/2017.
 */
public class SoupEat implements Listener{

    @EventHandler
    public void onEat(PlayerInteractEvent e){
        Player player = e.getPlayer();
        if (player.getItemInHand().getType() == Material.MUSHROOM_SOUP){
            player.getItemInHand().setAmount(0);
            player.setHealth(player.getHealth() + 3);
        }

    }

}
