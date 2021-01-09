package events;

import items.Tracker;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.util.Vector;

public class EnterNetherEvent implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void onNetherEntering(PlayerPortalEvent e){
        Player p = e.getPlayer();
        Tracker.setPlayerLocationinDimension(p, new Vector(p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ()));
    }

}
