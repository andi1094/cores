package net.minecresthd.cores.listeners;

import net.minecresthd.cores.Main;
import net.minecresthd.cores.Var;
import net.minecresthd.cores.managers.Factory;
import net.minecresthd.cores.managers.GameState;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class onBuildEvent implements Listener {

    public void checkWinningLater() {
        Bukkit.getScheduler().runTaskLater(Main.main, () -> {
            GameState.checkWinning();
        }, 20);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Location blockloc = e.getBlock().getLocation();
        if(!Var.canBuild) {
            e.setCancelled(true);
            if(e.getPlayer().getGameMode() == GameMode.CREATIVE) {
                e.setCancelled(false);
            }
            return;
        } else if(e.getBlock().getType() == Material.BEACON) {
            if(blockloc.getBlock().equals(Factory.getConfigLocation("Spawn.Core.Red.Left", Var.locs).getBlock())) {
                if(Var.team_blue.contains(e.getPlayer())) {
                    Main.main.sqlc.addCoins(e.getPlayer(), Var.coins_core);
                    e.getPlayer().sendMessage(Var.prefix.replace("&", "§") + Var.coins_addedcoins.replace("&", "§").replace("%coins%", Integer.toString(Var.coins_core)));
                    Main.main.sql.addCores(e.getPlayer(), 1);
                    Var.red_left = false;
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.playSound(all.getLocation(), Sound.WITHER_DEATH, 1, 1);
                    }
                    Bukkit.broadcastMessage(Var.prefix.replace("&", "§") + Var.core_redleft_destroy.replace("&", "§"));
                    e.setCancelled(true);
                    e.getBlock().getLocation().getBlock().setType(Material.AIR);

                    checkWinningLater();
                } else {
                    e.setCancelled(true);
                }
            } else if(blockloc.getBlock().equals(Factory.getConfigLocation("Spawn.Core.Red.Right", Var.locs).getBlock())) {
                if(Var.team_blue.contains(e.getPlayer())) {
                    Main.main.sqlc.addCoins(e.getPlayer(), Var.coins_core);
                    e.getPlayer().sendMessage(Var.prefix.replace("&", "§") + Var.coins_addedcoins.replace("&", "§").replace("%coins%", Integer.toString(Var.coins_core)));
                    Main.main.sql.addCores(e.getPlayer(), 1);
                    Var.red_right = false;
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.playSound(all.getLocation(), Sound.WITHER_DEATH, 1, 1);
                    }
                    Bukkit.broadcastMessage(Var.prefix.replace("&", "§") + Var.core_redright_destroy.replace("&", "§"));
                    e.setCancelled(true);
                    e.getBlock().getLocation().getBlock().setType(Material.AIR);
                    checkWinningLater();
                } else {
                    e.setCancelled(true);
                }
            } else if(blockloc.getBlock().equals(Factory.getConfigLocation("Spawn.Core.Blue.Left", Var.locs).getBlock())) {
                if(Var.team_red.contains(e.getPlayer())) {
                    Main.main.sqlc.addCoins(e.getPlayer(), Var.coins_core);
                    e.getPlayer().sendMessage(Var.prefix.replace("&", "§") + Var.coins_addedcoins.replace("&", "§").replace("%coins%", Integer.toString(Var.coins_core)));
                    Main.main.sql.addCores(e.getPlayer(), 1);
                    Var.blue_left = false;
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.playSound(all.getLocation(), Sound.WITHER_DEATH, 1, 1);
                    }
                    Bukkit.broadcastMessage(Var.prefix.replace("&", "§") + Var.core_blueleft_destroy.replace("&", "§"));
                    e.setCancelled(true);
                    e.getBlock().getLocation().getBlock().setType(Material.AIR);
                    checkWinningLater();
                } else {
                    e.setCancelled(true);
                }
            } else if(blockloc.getBlock().equals(Factory.getConfigLocation("Spawn.Core.Blue.Right", Var.locs).getBlock())) {
                if (Var.team_red.contains(e.getPlayer())) {
                    Main.main.sqlc.addCoins(e.getPlayer(), Var.coins_core);
                    e.getPlayer().sendMessage(Var.prefix.replace("&", "§") + Var.coins_addedcoins.replace("&", "§").replace("%coins%", Integer.toString(Var.coins_core)));
                    Main.main.sql.addCores(e.getPlayer(), 1);
                    Var.blue_right = false;
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.playSound(all.getLocation(), Sound.WITHER_DEATH, 1, 1);
                    }
                    Bukkit.broadcastMessage(Var.prefix.replace("&", "§") + Var.core_blueright_destroy.replace("&", "§"));
                    e.setCancelled(true);
                    e.getBlock().getLocation().getBlock().setType(Material.AIR);
                    checkWinningLater();
                } else {
                    e.setCancelled(true);
                }
            }
        } else {
            if (blockloc.distance(Factory.getConfigLocation("Spawn.Core.Red.Right", Var.locs)) < Var.core_build_distance) {
                e.setCancelled(true);
            } else if (blockloc.distance(Factory.getConfigLocation("Spawn.Core.Red.Left", Var.locs)) < Var.core_build_distance) {
                e.setCancelled(true);
            } else if (blockloc.distance(Factory.getConfigLocation("Spawn.Core.Blue.Right", Var.locs)) < Var.core_build_distance) {
                e.setCancelled(true);
            } else if (blockloc.distance(Factory.getConfigLocation("Spawn.Core.Blue.Left", Var.locs)) < Var.core_build_distance) {
                e.setCancelled(true);
            } else if (blockloc.distance(Factory.getConfigLocation("Spawn.spawn.1", Var.locs)) < Var.spawn_build_distance) {
                e.setCancelled(true);
            } else if (blockloc.distance(Factory.getConfigLocation("Spawn.spawn.2", Var.locs)) < Var.spawn_build_distance) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Location blockloc = e.getBlockPlaced().getLocation();
        if(e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
            e.setCancelled(false);
        } else if(Var.canBuild){
            if (blockloc.distance(Factory.getConfigLocation("Spawn.Core.Red.Right", Var.locs)) < Var.core_build_distance) {
                e.setCancelled(true);
            } else if (blockloc.distance(Factory.getConfigLocation("Spawn.Core.Red.Left", Var.locs)) < Var.core_build_distance) {
                e.setCancelled(true);
            } else if (blockloc.distance(Factory.getConfigLocation("Spawn.Core.Blue.Right", Var.locs)) < Var.core_build_distance) {
                e.setCancelled(true);
            } else if (blockloc.distance(Factory.getConfigLocation("Spawn.Core.Blue.Left", Var.locs)) < Var.core_build_distance) {
                e.setCancelled(true);
            } else if (blockloc.distance(Factory.getConfigLocation("Spawn.spawn.1", Var.locs)) < Var.spawn_build_distance) {
                e.setCancelled(true);
            } else if (blockloc.distance(Factory.getConfigLocation("Spawn.spawn.2", Var.locs)) < Var.spawn_build_distance) {
                e.setCancelled(true);
            }
        } else if(!Var.canBuild) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBeaconInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && e.getClickedBlock().getType().equals(Material.BEACON)) {
            e.setCancelled(true);
        }
    }

}
