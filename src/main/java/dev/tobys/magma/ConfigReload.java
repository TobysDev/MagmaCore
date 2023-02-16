package dev.tobys.magma;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ConfigReload implements CommandExecutor{
    private Magma main;

    public ConfigReload(Magma main) {
        this.main = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args) {
        this.main.reloadConfig();
        String ReloadMessage = this.main.getConfig().getString("ReloadMessage");
        ReloadMessage = PlaceholderAPI.setPlaceholders((OfflinePlayer) sender, ReloadMessage);
        ReloadMessage = ChatColor.translateAlternateColorCodes('&', ReloadMessage);
        sender.sendMessage(ReloadMessage);
        return true;
    }
}
