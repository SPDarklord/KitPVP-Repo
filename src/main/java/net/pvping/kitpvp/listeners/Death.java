package net.pvping.kitpvp.listeners;

import net.pvping.kitpvp.utils.Chat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * Created by Thomas on 09/02/2017.
 */
public class Death implements Listener{

    @EventHandler
    public  void onDeath(PlayerDeathEvent e){
        e.setDeathMessage(null);
        Player killer = e.getEntity().getKiller();
        Player killed = e.getEntity().getPlayer();

        Chat.sendMessage(killed, "You were killed by: " + killer.getDisplayName() + " with " + killer.getItemInHand().getItemMeta().getDisplayName());

        if (killed.getLevel() > 3){

            Chat.sendMessage(killed, "You lost a kill streak of: " + killed.getLevel());
        }

        killed.setLevel(0);
        killer.setLevel(killer.getLevel() + 1);
        switch (killer.getLevel()){
            case 3:
                Chat.sendMessage(killer, "You started a new kill streak!");
             break;
            case 5:
                Chat.sendMessage(killer, "You have a kill streak of 5!");
                break;
            case 10:
                Chat.bc(killer.getDisplayName() + " has a kill streak of 10! Go get them and end their streak...");
        }
    }

}
