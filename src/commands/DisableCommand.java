package commands;

import items.Compass;
import items.Tracker;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class DisableCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        //Checks if command is used by a player.
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(cmd.getName().equals("csdisable")){
                if(args.length == 0){
                    for(ItemStack i:p.getInventory().getContents()){
                        if(i != null){
                            if(i.equals(Compass.getCompass())){
                                p.getInventory().remove(i);
                            }
                        }
                    }
                    Tracker.disable(p);
                    p.setCompassTarget(p.getWorld().getSpawnLocation());
                    return true;
                }
                p.sendMessage(ChatColor.RED + "Usage: /csdisable.");
                return true;
            }
            p.sendMessage(ChatColor.RED + "Usage: /csdisable.");
            return true;
        }
        sender.sendMessage(ChatColor.RED + "Command only used by players!");
        return true;
    }

}
