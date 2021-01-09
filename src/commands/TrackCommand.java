package commands;

import items.Compass;
import items.Tracker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TrackCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        //Checks if command is used by a player.
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(cmd.getName().equals("cs")){
                if(args.length > 0){
                    if(p.getInventory().contains(Compass.getCompass())){
                        List<Player> list = new ArrayList<>();
                        for(String name:args){
                            Player target = Bukkit.getPlayerExact(name);
                            if(target == null) {
                                p.sendMessage(ChatColor.RED + "You have entered a player that doesn't exist!");
                                break;
                            }
                            list.add(target);
                        }
                        Tracker.setTargets(p, list);
                        return true;
                    }
                    p.sendMessage(ChatColor.RED + "You don't have the compass!");
                    return true;
                }
                p.sendMessage(ChatColor.RED + "Not enough arguments");
                return true;
            }
            p.sendMessage(ChatColor.RED + "Usage: /cs <player name list>.");
            return true;
        }
        sender.sendMessage(ChatColor.RED + "Command only used by players!");
        return true;
    }
}
