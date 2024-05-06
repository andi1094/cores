package net.minecresthd.cores.listeners;

import net.minecresthd.cores.Var;
import net.minecresthd.cores.managers.GameState;
import net.minecresthd.cores.managers.GameStateHandler;
import net.minecresthd.cores.managers.IngameState;
import net.minecresthd.cores.managers.LobbyState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class onChatEvent implements Listener {

    @EventHandler
    public void onChat(PlayerChatEvent e) {
        Player p = e.getPlayer();
        if(GameStateHandler.getGameState() instanceof LobbyState) {
            if (p.hasPermission("rank.1")) {
                e.setFormat(Var.chat_rank1.replace("&", "§").replace("%player%", p.getName()).replace("%message%", e.getMessage()));
            } else if (p.hasPermission("rank.2")) {
                e.setFormat(Var.chat_rank2.replace("&", "§").replace("%player%", p.getName()).replace("%message%", e.getMessage()));
            } else if (p.hasPermission("rank.3")) {
                e.setFormat(Var.chat_rank3.replace("&", "§").replace("%player%", p.getName()).replace("%message%", e.getMessage()));
            } else if (p.hasPermission("rank.4")) {
                e.setFormat(Var.chat_rank4.replace("&", "§").replace("%player%", p.getName()).replace("%message%", e.getMessage()));
            } else if (p.hasPermission("rank.5")) {
                e.setFormat(Var.chat_rank5.replace("&", "§").replace("%player%", p.getName()).replace("%message%", e.getMessage()));
            } else if (p.hasPermission("rank.6")) {
                e.setFormat(Var.chat_rank6.replace("&", "§").replace("%player%", p.getName()).replace("%message%", e.getMessage()));
            } else if (p.hasPermission("rank.7")) {
                e.setFormat(Var.chat_rank7.replace("&", "§").replace("%player%", p.getName()).replace("%message%", e.getMessage()));
            } else if (p.hasPermission("rank.8")) {
                e.setFormat(Var.chat_rank8.replace("&", "§").replace("%player%", p.getName()).replace("%message%", e.getMessage()));
            } else if (p.hasPermission("rank.9")) {
                e.setFormat(Var.chat_rank9.replace("&", "§").replace("%player%", p.getName()).replace("%message%", e.getMessage()));
            } else if (p.hasPermission("rank.10")) {
                e.setFormat(Var.chat_rank10.replace("&", "§").replace("%player%", p.getName()).replace("%message%", e.getMessage()));
            } else if (p.hasPermission("rank.11")) {
                e.setFormat(Var.chat_rank11.replace("&", "§").replace("%player%", p.getName()).replace("%message%", e.getMessage()));
            } else if (p.hasPermission("rank.12")) {
                e.setFormat(Var.chat_rank12.replace("&", "§").replace("%player%", p.getName()).replace("%message%", e.getMessage()));
            } else if (p.hasPermission("rank.13")) {
                e.setFormat(Var.chat_rank13.replace("&", "§").replace("%player%", p.getName()).replace("%message%", e.getMessage()));
            } else if (p.hasPermission("rank.14")) {
                e.setFormat(Var.chat_rank14.replace("&", "§").replace("%player%", p.getName()).replace("%message%", e.getMessage()));
            } else if (p.hasPermission("rank.15")) {
                e.setFormat(Var.chat_rank15.replace("&", "§").replace("%player%", p.getName()).replace("%message%", e.getMessage()));
            } else if (p.hasPermission("rank.16")) {
                e.setFormat(Var.chat_rank16.replace("&", "§").replace("%player%", p.getName()).replace("%message%", e.getMessage()));
            } else if (p.hasPermission("rank.17")) {
                e.setFormat(Var.chat_rank17.replace("&", "§").replace("%player%", p.getName()).replace("%message%", e.getMessage()));
            } else if (p.hasPermission("rank.18")) {
                e.setFormat(Var.chat_rank18.replace("&", "§").replace("%player%", p.getName()).replace("%message%", e.getMessage()));
            } else if (p.hasPermission("rank.19")) {
                e.setFormat(Var.chat_rank19.replace("&", "§").replace("%player%", p.getName()).replace("%message%", e.getMessage()));
            } else if (p.hasPermission("rank.20")) {
                e.setFormat(Var.chat_rank20.replace("&", "§").replace("%player%", p.getName()).replace("%message%", e.getMessage()));
            }
        } else if(GameStateHandler.getGameState() instanceof IngameState) {
            if(Var.team_red.contains(p)) {
                e.setFormat("§4" + p.getName() + "§7: " + e.getMessage());
            } else if(Var.team_blue.contains(p)) {
                e.setFormat("§9" + p.getName() + "§7: " + e.getMessage());
            } else if(Var.spectating.contains(p)) {
                e.setCancelled(true);
                p.sendMessage(Var.prefix.replace("&", "§") + Var.chat_spectator.replace("&", "§"));
            }
        }
    }

}
