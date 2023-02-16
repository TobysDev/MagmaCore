package dev.tobys.magma.JoinLeaveMessage;

import dev.tobys.magma.Magma;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinMessage implements Listener {

    private Magma main;

    public JoinMessage(Magma main) {
        this.main = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        if (player.hasPlayedBefore()) {
            String JoinMessage = this.main.getConfig().getString("JoinMessage");
            JoinMessage = PlaceholderAPI.setPlaceholders(e.getPlayer(), JoinMessage);
            JoinMessage = ChatColor.translateAlternateColorCodes('&', JoinMessage);
            e.setJoinMessage(JoinMessage);
        } else {
            String FirstJoinMessage = this.main.getConfig().getString("FirstJoinMessage");
            FirstJoinMessage = PlaceholderAPI.setPlaceholders(e.getPlayer(), FirstJoinMessage);
            FirstJoinMessage = ChatColor.translateAlternateColorCodes('§', FirstJoinMessage);
            e.setJoinMessage(FirstJoinMessage);

        }

    }

}