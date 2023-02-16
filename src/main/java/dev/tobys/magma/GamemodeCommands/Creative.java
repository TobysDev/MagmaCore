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

        if (args.length < 1) {
            sender.sendMessage(ChatColor.RED + "You must specify a target player.");
            return false;
        }

        if (!sender.hasPermission("creative.others")) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to change other players' gamemode.");
            return true;
        }

        Player targetPlayer = main.getServer().getPlayer(args[0]);
        if (targetPlayer == null) {
            sender.sendMessage(ChatColor.RED + "Player not found.");
            return false;
        }

        String gamemodeChangeMessage = main.getConfig().getString("GamemodeChangeMessage");
        gamemodeChangeMessage = PlaceholderAPI.setPlaceholders(targetPlayer, gamemodeChangeMessage);
        gamemodeChangeMessage = ChatColor.translateAlternateColorCodes('&', gamemodeChangeMessage);
        targetPlayer.sendMessage(gamemodeChangeMessage);
        targetPlayer.setGameMode(GameMode.CREATIVE);

        String gamemode = "CREATIVE";
        gamemodeChangeMessage = gamemodeChangeMessage.replace("%gamemode%", gamemode);
        targetPlayer.sendMessage(gamemodeChangeMessage);

        return true;
    }
}
