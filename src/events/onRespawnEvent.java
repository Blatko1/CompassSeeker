package events;

import items.Compass;
import items.Tracker;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class onRespawnEvent implements Listener {

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e){
        Player p = e.getPlayer();
        if(!Tracker.areTargetsEmpty(p)){
            p.getInventory().addItem(Compass.getCompass());
        }
    }
}
