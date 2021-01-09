package events;

import items.Compass;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class onCompassDrop implements Listener {

    @EventHandler
    public void onCompassDrop(PlayerDropItemEvent e){
        if(e.getItemDrop().getItemStack().equals(Compass.getCompass())){
            e.setCancelled(true);
        }
    }

}
