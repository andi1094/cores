package net.minecresthd.cores.listeners;

import net.minecresthd.cores.managers.GameStateHandler;
import net.minecresthd.cores.managers.LobbyState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class onFoodEvent implements Listener {

    @EventHandler
    public void onFood(FoodLevelChangeEvent e) {
        if(GameStateHandler.getGameState() instanceof LobbyState) {
            e.setCancelled(true);
        }
    }

}
