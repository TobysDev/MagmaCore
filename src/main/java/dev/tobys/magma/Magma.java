package dev.tobys.magma;

import dev.tobys.magma.GamemodeCommands.Creative;
import dev.tobys.magma.GamemodeCommands.Survival;
import dev.tobys.magma.JoinLeaveMessage.JoinMessage;
import dev.tobys.magma.JoinLeaveMessage.LeaveMessage;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Magma extends JavaPlugin {

    @Override
    public void onEnable() {

        //PlaceholderAPI Enabled
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {

            //Register Events
            getServer().getPluginManager().registerEvents(new JoinMessage(this), this);
            getServer().getPluginManager().registerEvents(new LeaveMessage(this), this);

            // Command
            this.getCommand("reloadconfig").setExecutor(new ConfigReload(this));
            this.getCommand("gmc").setExecutor(new Creative(this));
            this.getCommand("gms").setExecutor(new Survival(this));

        }

        // Plugin startup logic
        this.getLogger().info("MagmaCore - Enabling...");
        this.getLogger().info("MagmaCore - For perfect work download PlaceholderAPI for best experience");

        //Load Config
        this.getConfig().options().copyDefaults();
        this.saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
