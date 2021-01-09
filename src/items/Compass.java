package items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Compass {

    public static ItemStack getCompass(){

        ItemStack compass = new ItemStack(Material.COMPASS);

        ItemMeta meta = compass.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "Compass Seeker");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GOLD + "<Right click> to update target's location.");
        lore.add(ChatColor.RED + "Inspired and initial idea by: Dream & GeorgeNotFound.");
        lore.add("Made by: BigBlaster1");

        meta.setLore(lore);
        compass.setItemMeta(meta);

        return compass;
    }

}
