package commands;

import items.Compass;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CompassGetCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        //Checks if command is used by a player.
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(cmd.getName().equals("csget")){
                if(args.length == 0){
                    //If the player already has a compassSeeker he won't ge another one.
                    if(!p.getInventory().contains(Compass.getCompass())){
                        p.getInventory().addItem(Compass.getCompass());
                        p.sendMessage(ChatColor.GREEN + "You got the compass!");
                        return true;
                    }
                    p.sendMessage(ChatColor.RED + "You already have the compass!");
                    return true;
                }
                p.sendMessage(ChatColor.RED + "Usage: /csget.");
                return true;
            }
            p.sendMessage(ChatColor.RED + "Usage: /csget.");
            return true;
        }
        sender.sendMessage(ChatColor.RED + "Command only used by players!");
        return true;
    }
}
