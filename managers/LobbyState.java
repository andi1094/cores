package net.minecresthd.cores.managers;

import net.minecresthd.cores.Var;
import net.minecresthd.cores.countdowns.LobbyCountdown;
import org.bukkit.Bukkit;

public class LobbyState extends GameState {
    private LobbyCountdown countdown;

    @Override
    public void init() {
        countdown = new LobbyCountdown();
    }

    @Override
    public void end() {
        Bukkit.broadcastMessage(Var.prefix.replace("&", "§") + Var.ingame_allplayers_teleport.replace("&", "§"));
    }

    public LobbyCountdown getCountdown() {
        return countdown;
    }

}
