package net.minecresthd.cores.listeners;

import net.minecresthd.cores.Var;
import net.minecresthd.cores.managers.GameState;
import net.minecresthd.cores.managers.GameStateHandler;
import net.minecresthd.cores.managers.LobbyState;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class onQuitEvent implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage(null);
        if(GameStateHandler.getGameState() instanceof LobbyState) {
            Var.playing.remove(p);
            if(Var.team_red.contains(p)) {
                Var.team_red.remove(p);
            }
            if(Var.team_blue.contains(p)) {
                Var.team_blue.remove(p);
            }
            Bukkit.broadcastMessage(Var.prefix.replace("&", "§") + Var.quitmsg.replace("&", "§").replace("%player%", p.getName()).replace("%current%", Integer.toString(Var.playing.size())).replace("%maxplayers%", Integer.toString(Var.maxplayers)));
            LobbyState ls = (LobbyState) GameStateHandler.getGameState();

            if(Var.playing.size() < Var.maxplayers) {
                if(ls.getCountdown().isRunning) {
                    ls.getCountdown().stopCountdown();
                    ls.getCountdown().idle();
                }
            }
        } else {
            Var.playing.remove(p);
            if(Var.team_red.contains(p)) {
                Var.team_red.remove(p);
            }
            if(Var.team_blue.contains(p)) {
                Var.team_blue.remove(p);
            }
            Bukkit.broadcastMessage(Var.prefix.replace("&", "§") + Var.quitmsg_ingame.replace("&", "§").replace("%player%", p.getName()));
            GameState.checkWinning();
        }
    }

}
