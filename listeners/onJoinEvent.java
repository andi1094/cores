package net.minecresthd.cores.listeners;

import net.minecresthd.cores.Main;
import net.minecresthd.cores.Var;
import net.minecresthd.cores.managers.Factory;
import net.minecresthd.cores.managers.GameStateHandler;
import net.minecresthd.cores.managers.LobbyState;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;

public class onJoinEvent implements Listener {

    private ItemStack teamChoise() {
        ItemStack item = new ItemStack(Material.BED);
        ItemMeta imeta = item.getItemMeta();
        imeta.setDisplayName("§eTeams");
        item.setItemMeta(imeta);
        return item;
    }

    public void checkSetup(Player p) {
        YamlConfiguration cfg = Var.locs;
        if(!cfg.contains("Spawn.Lobby")) {
            p.sendMessage(Var.prefix.replace("&", "§") + "§cYou have to set the Lobby");
        }
        if(!cfg.contains("Spawn.Spectator")) {
            p.sendMessage(Var.prefix.replace("&", "§") + "§cYou have to set the Spectator Spawn");
        }
        if(!cfg.contains("Spawn.spawn.1")) {
            p.sendMessage(Var.prefix.replace("&", "§") + "§cYou have to set the Red Spawn");
        }
        if(!cfg.contains("Spawn.spawn.2")) {
            p.sendMessage(Var.prefix.replace("&", "§") + "§cYou have to set the Blue Spawn");
        }
        if(!cfg.contains("Spawn.Core.Red.Left")) {
            p.sendMessage(Var.prefix.replace("&", "§") + "§cYou have to set the Red Left Core");
        }
        if(!cfg.contains("Spawn.Core.Red.Right")) {
            p.sendMessage(Var.prefix.replace("&", "§") + "§cYou have to set the Red Right Core");
        }
        if(!cfg.contains("Spawn.Core.Blue.Left")) {
            p.sendMessage(Var.prefix.replace("&", "§") + "§cYou have to set the Blue Left Core");
        }
        if(!cfg.contains("Spawn.Core.Blue.Right")) {
            p.sendMessage(Var.prefix.replace("&", "§") + "§cYou have to set the Blue Right Core");
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        Main.main.sql.registerPlayer(p);
        Main.main.sqlc.registerPlayer(p);
        e.setJoinMessage(null);
        if(p.hasPermission("cores.setup")) {
            checkSetup(p);
        }
        if(GameStateHandler.getGameState() instanceof LobbyState) {
            Var.playing.add(p);
            p.getInventory().clear();
            p.getInventory().setHelmet(null);
            p.getInventory().setChestplate(null);
            p.getInventory().setLeggings(null);
            p.getInventory().setBoots(null);

            p.setMaxHealth(20);
            p.setHealth(20);
            p.setFoodLevel(20);
            p.setGameMode(GameMode.ADVENTURE);
            p.setLevel(0);
            p.getInventory().setItem(0, teamChoise());

            p.teleport(Factory.getConfigLocation("Spawn.Lobby", Var.locs));
            Bukkit.broadcastMessage(Var.prefix.replace("&", "§") + Var.joinmsg.replace("&", "§").replace("%player%", p.getName()).replace("%current%", Integer.toString(Var.playing.size())).replace("%maxplayers%", Integer.toString(Var.maxplayers)));
            LobbyState ls = (LobbyState) GameStateHandler.getGameState();
            if(Var.playing.size() >= Var.minplayers) {
                if(ls.getCountdown().isRunning == false) {
                    ls.getCountdown().stopIdle();
                    ls.getCountdown().start();
                }
            }
            if(Var.playing.size() < Var.minplayers) {
                if(ls.getCountdown().isIdling == false) {
                    ls.getCountdown().idle();
                }
            }
        } else {
            Var.spectating.add(p);
            p.teleport(Factory.getConfigLocation("Spawn.Spectator", Var.locs));
            p.setGameMode(GameMode.SPECTATOR);
            p.sendMessage(Var.prefix.replace("&", "§") + Var.joinmsg_ingame.replace("&", "§"));
        }

        onScoreboardEvent.setScoreboard(p);
        onScoreboardEvent.setTab(p);
        for(Player all : Bukkit.getOnlinePlayers()) {
            onScoreboardEvent.updateTab(all);
        }
    }

}
