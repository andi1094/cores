package net.minecresthd.cores.listeners;

import net.minecresthd.cores.Main;
import net.minecresthd.cores.Var;
import net.minecresthd.cores.managers.Factory;
import net.minecresthd.cores.managers.GameStateHandler;
import net.minecresthd.cores.managers.IngameState;
import net.minecresthd.cores.managers.LobbyState;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.Plugin;

public class onDeathEvent implements Listener {

    public void respawn(Player p) {
        Bukkit.getScheduler().runTaskLater((Plugin) Main.main, () -> {
            p.spigot().respawn();
        }, (long)10);
    }

    public void giveItems(Player p) {
        Bukkit.getScheduler().runTaskLater(Main.main, () -> {
            p.spigot().respawn();
            p.getInventory().addItem(Var.createItem(272,0,"","",1,null,0));
            p.getInventory().addItem(Var.createItem(261,0,"","",1,null,0));
            p.getInventory().addItem(Var.createItem(257,0,"","",1,null,0));
            p.getInventory().addItem(Var.createItem(258,0,"","",1,null,0));
            p.getInventory().addItem(Var.createItem(322,0,"","",16,null,0));
            p.getInventory().setItem(6, Var.createItem(262,0,"","",16,null,0));
            p.getInventory().setItem(7, Var.createItem(297,0,"","",64,null,0));
            p.getInventory().setItem(8, Var.createItem(17,0,"","",64,null,0));
            p.getInventory().setHelmet(Helmet(p));
            p.getInventory().setChestplate(Chestplate(p));
            p.getInventory().setLeggings(Leggings(p));
            p.getInventory().setBoots(Boots(p));
        }, 20);
    }

    private ItemStack Helmet(Player p) {
        ItemStack item = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta imeta = (LeatherArmorMeta)item.getItemMeta();
        if(Var.team_red.contains(p)) {
            imeta.setColor(Color.RED);
        } else if(Var.team_blue.contains(p)) {
            imeta.setColor(Color.BLUE);
        }
        item.setItemMeta(imeta);
        return item;
    }

    private ItemStack Chestplate(Player p) {
        ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta imeta = (LeatherArmorMeta)item.getItemMeta();
        if(Var.team_red.contains(p)) {
            imeta.setColor(Color.RED);
        } else if(Var.team_blue.contains(p)) {
            imeta.setColor(Color.BLUE);
        }
        item.setItemMeta(imeta);
        return item;
    }

    private ItemStack Leggings(Player p) {
        ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta imeta = (LeatherArmorMeta)item.getItemMeta();
        if(Var.team_red.contains(p)) {
            imeta.setColor(Color.RED);
        } else if(Var.team_blue.contains(p)) {
            imeta.setColor(Color.BLUE);
        }
        item.setItemMeta(imeta);
        return item;
    }

    private ItemStack Boots(Player p) {
        ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta imeta = (LeatherArmorMeta)item.getItemMeta();
        if(Var.team_red.contains(p)) {
            imeta.setColor(Color.RED);
        } else if(Var.team_blue.contains(p)) {
            imeta.setColor(Color.BLUE);
        }
        item.setItemMeta(imeta);
        return item;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        e.setDeathMessage(null);
        e.getDrops().clear();
        if(Var.instantdeath) {
            respawn(p);
        }
        if (p.getKiller() != null) {
            Player killer = p.getKiller();
            killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1, 1);
            Var.currentkills.put(killer, Var.currentkills.get(killer)+1);
            killer.sendMessage(Var.prefix.replace("&", "§") + Var.coins_addedcoins.replace("&", "§").replace("%coins%", Integer.toString(Var.coins_kill)));
            Main.main.sqlc.addCoins(killer, Var.coins_kill);
            Main.main.sql.addKills(killer, 1);
            Main.main.sql.addDeaths(p, 1);
            Bukkit.broadcastMessage(Var.prefix.replace("&", "§") + Var.killmsg.replace("&", "§").replace("%player%", p.getName()).replace("%killer%", killer.getName()));
            giveItems(p);
            return;
        }
        Bukkit.broadcastMessage(Var.prefix.replace("&", "§") + Var.deathmsg.replace("&", "§").replace("%player%", p.getName()));
        Main.main.sql.addDeaths(p, 1);
        giveItems(p);
        return;
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if(e.getEntity() instanceof Player) {
            Player p = ((Player) e.getEntity()).getPlayer();
            if (e.getCause() == EntityDamageEvent.DamageCause.VOID) {
                if (GameStateHandler.getGameState() instanceof LobbyState) {
                    e.setCancelled(true);
                    e.getEntity().teleport(Factory.getConfigLocation("Spawn.Lobby", Var.locs));
                } else if (GameStateHandler.getGameState() instanceof IngameState && Var.instantdeath) {
                    p.setHealth(0.5);
                }
            }
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        if(Var.team_red.contains(p)) {
            e.setRespawnLocation(Factory.getConfigLocation("Spawn.spawn.1", Var.locs));
        } else if(Var.team_blue.contains(p)) {
            e.setRespawnLocation(Factory.getConfigLocation("Spawn.spawn.2", Var.locs));
        }
    }

}
