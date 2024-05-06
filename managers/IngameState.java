package net.minecresthd.cores.managers;

import net.minecresthd.cores.Var;
import net.minecresthd.cores.countdowns.EndCountdown;
import net.minecresthd.cores.countdowns.SpawnCountdown;
import net.minecresthd.cores.listeners.onScoreboardEvent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class IngameState extends GameState {

    private SpawnCountdown spawncd;
    private EndCountdown endcd;

    @Override
    public void init() {
        spawncd = new SpawnCountdown();
        endcd = new EndCountdown();

        for(Player all : Bukkit.getOnlinePlayers()) {
            Var.currentkills.put(all, 0);
            onScoreboardEvent.setScoreboard(all);
            onScoreboardEvent.setTab(all);
        }

        Block b1 = Bukkit.getServer().getWorld(Var.world_game).getBlockAt(Factory.getConfigLocation("Spawn.Core.Red.Left", Var.locs));
        b1.setTypeId(138);
        Block b2 = Bukkit.getServer().getWorld(Var.world_game).getBlockAt(Factory.getConfigLocation("Spawn.Core.Red.Right", Var.locs));
        b2.setTypeId(138);
        Block b3 = Bukkit.getServer().getWorld(Var.world_game).getBlockAt(Factory.getConfigLocation("Spawn.Core.Blue.Left", Var.locs));
        b3.setTypeId(138);
        Block b4 = Bukkit.getServer().getWorld(Var.world_game).getBlockAt(Factory.getConfigLocation("Spawn.Core.Blue.Right", Var.locs));
        b4.setTypeId(138);

        for(int i = 0; i < Var.team_red.size(); i++) {
            Player p = Var.team_red.get(i);
            p.teleport(Factory.getConfigLocation("Spawn.spawn.1", Var.locs));
            p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1);
            p.getInventory().clear();
            p.setGameMode(GameMode.SURVIVAL);
        }
        for(int i = 0; i < Var.team_blue.size(); i++) {
            Player p = Var.team_blue.get(i);
            p.teleport(Factory.getConfigLocation("Spawn.spawn.2", Var.locs));
            p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1);
            p.getInventory().clear();
            p.setGameMode(GameMode.SURVIVAL);
        }
        spawncd.start();
        CheckCores.startCheckCore();
    }

    @Override
    public void end() {
        endcd.start();
        Var.canAttack = false;
        Var.canBuild = false;
        for(Player all : Bukkit.getOnlinePlayers()) {
            all.teleport(Factory.getConfigLocation("Spawn.Lobby", Var.locs));
        }
    }

}
