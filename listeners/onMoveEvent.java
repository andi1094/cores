package net.minecresthd.cores.listeners;

import net.minecresthd.cores.Var;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class onMoveEvent implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if(!Var.canMove) {
            e.getPlayer().teleport(e.getFrom());
        }
    }

}
