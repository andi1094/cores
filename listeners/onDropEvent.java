package net.minecresthd.cores.listeners;

import net.minecresthd.cores.managers.GameStateHandler;
import net.minecresthd.cores.managers.IngameState;
import net.minecresthd.cores.managers.LobbyState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class onDropEvent implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        if(GameStateHandler.getGameState() instanceof LobbyState) {
            e.setCancelled(true);
        } else if(GameStateHandler.getGameState() instanceof IngameState) {
            e.setCancelled(false);
        }
    }

}
