package dev.tobys.magma.GamemodeCommands;

import dev.tobys.magma.Magma;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Creative implements CommandExecutor {

    private final Magma main;

    public Creative(Magma main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be run by a player.");
            return true;
        }

        Player player = (Player) sender;
        String gamemodeChangeMessage = main.getConfig().getString("GamemodeChangeMessage");
        gamemodeChangeMessage = PlaceholderAPI.setPlaceholders(player, gamemodeChangeMessage);
        gamemodeChangeMessage = ChatColor.translateAlternateColorCodes('&', gamemodeChangeMessage);
        player.sendMessage(gamemodeChangeMessage);
        player.setGameMode(GameMode.CREATIVE);

        String gamemode = "CREATIVE";
        gamemodeChangeMessage = gamemodeChangeMessage.replace("%gamemode%", gamemode);
        player.sendMessage(gamemodeChangeMessage);

        return true;
    }
}
