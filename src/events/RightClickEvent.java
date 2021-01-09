package events;

import items.Compass;
import items.Tracker;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class RightClickEvent implements Listener {

    @EventHandler
    public void rightClick(PlayerInteractEvent e){
        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
            Player p = e.getPlayer();
            if(p.getInventory().getItemInMainHand().equals(Compass.getCompass())){
                if(!Tracker.areTargetsEmpty(p)){
                    Tracker.updateTracker(p);
                }
                else{
                    p.sendMessage(ChatColor.RED + "No targets!");
                }
            }
        }
    }

}