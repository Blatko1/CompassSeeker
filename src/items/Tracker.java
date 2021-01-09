package items;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Tracker {

    private static HashMap<Player, List<Player>> map = new HashMap<>();
    private static HashMap<Player, Vector> teleportedPlayersMap = new HashMap<>();

    public static void setTargets(Player p, List<Player> list){
        map.put(p, list);
        p.sendMessage(String.valueOf(map.size()));
    }

    public static void setPlayerLocationinDimension(Player p, Vector vec){
        teleportedPlayersMap.put(p, vec);
    }

    public static void updateTracker(Player p){
        HashMap<Double, Player> distanceMap = new HashMap<>();
        for(Player player:map.get(p)){
            if(!player.getWorld().getEnvironment().equals(World.Environment.NETHER) && !player.getWorld().getEnvironment().equals(World.Environment.NETHER)){
                Location loc = player.getLocation();
                double dist = loc.distance(p.getLocation());
                distanceMap.put(dist, player);
            }
            else{
                Location loc = new Location(player.getWorld(), teleportedPlayersMap.get(player).getX(), teleportedPlayersMap.get(player).getY(), teleportedPlayersMap.get(player).getZ());
                double dist = loc.distance(p.getLocation());
                distanceMap.put(dist, player);
            }
        }
        List<Double> keys = new ArrayList<Double>(distanceMap.keySet());
        Collections.sort(keys);
        p.setCompassTarget(distanceMap.get(keys.get(0)).getLocation());
        p.sendMessage(ChatColor.GOLD + "Now pointing at: " + distanceMap.get(keys.get(0)).getName());
    }

    public static boolean areTargetsEmpty(Player p){
        if(map.get(p) == null){
            return true;
        }
        return false;
    }

    public static void disable(Player p){
        map.remove(p);
    }

}
