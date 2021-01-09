package main;

import commands.CompassGetCommand;
import commands.DisableCommand;
import commands.TrackCommand;
import events.RightClickEvent;
import events.onCompassDrop;
import events.onRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginMain extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("csget").setExecutor(new CompassGetCommand());
        this.getCommand("cs").setExecutor(new TrackCommand());
        this.getCommand("csdisable").setExecutor(new DisableCommand());
        this.getServer().getPluginManager().registerEvents(new RightClickEvent(), this);
        this.getServer().getPluginManager().registerEvents(new onCompassDrop(), this);
        this.getServer().getPluginManager().registerEvents(new onRespawnEvent(), this);
    }

    @Override
    public void onDisable() {

    }
}
