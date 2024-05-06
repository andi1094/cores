package net.minecresthd.cores.listeners;

import net.minecresthd.cores.Var;
import net.minecresthd.cores.managers.GameStateHandler;
import net.minecresthd.cores.managers.IngameState;
import net.minecresthd.cores.managers.LobbyState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class onServerPingEvent implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent e) {
        if(GameStateHandler.getGameState() instanceof LobbyState) {
            e.setMotd(Var.motd_lobby);
        } else if(GameStateHandler.getGameState() instanceof IngameState) {
            e.setMotd(Var.motd_ingame);
        }
    }

}
