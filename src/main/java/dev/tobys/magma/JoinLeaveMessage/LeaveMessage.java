package dev.tobys.magma.JoinLeaveMessage;

import dev.tobys.magma.Magma;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveMessage implements Listener {

    private Magma main;

    public LeaveMessage(Magma main) {
        this.main = main;
    }
    @EventHandler
    public void onleave(PlayerQuitEvent e){

        Player player = e.getPlayer();

        String LeaveMessage = this.main.getConfig().getString("LeaveMessage");
        LeaveMessage = PlaceholderAPI.setPlaceholders(e.getPlayer(), LeaveMessage);
        LeaveMessage = ChatColor.translateAlternateColorCodes('&', LeaveMessage);
        e.setQuitMessage(LeaveMessage);
    }
}