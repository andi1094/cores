package net.minecresthd.cores.listeners;

import net.minecresthd.cores.Var;
import net.minecresthd.cores.managers.GameStateHandler;
import net.minecresthd.cores.managers.IngameState;
import net.minecresthd.cores.managers.LobbyState;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class onTeamsEvent implements Listener {

    private ItemStack redChoise() {
        ItemStack item = new ItemStack(Material.WOOL, 1, (short) 14);
        ItemMeta imeta = item.getItemMeta();
        imeta.setDisplayName("§7Team §4Red");
        List<String> lore = new ArrayList<String>();
        lore.add("§e" + Var.team_red.size() + "§7/" + Var.maxplayers/2);
        imeta.setLore(lore);
        item.setItemMeta(imeta);
        return item;
    }

    private ItemStack blueChoise() {
        ItemStack item = new ItemStack(Material.WOOL, 1, (short) 11);
        ItemMeta imeta = item.getItemMeta();
        imeta.setDisplayName("§7Team §9Blue");
        List<String> lore = new ArrayList<String>();
        lore.add("§e" + Var.team_blue.size() + "§7/" + Var.maxplayers/2);
        imeta.setLore(lore);
        item.setItemMeta(imeta);
        return item;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            if(GameStateHandler.getGameState() instanceof LobbyState) {
                if(e.getPlayer().getItemInHand().getType() == Material.BED) {
                    Inventory inv = Bukkit.createInventory(e.getPlayer(), 9, "§eTeams");
                    inv.setItem(2, redChoise());
                    inv.setItem(6, blueChoise());
                    e.getPlayer().openInventory(inv);
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if(GameStateHandler.getGameState() instanceof LobbyState && p.getGameMode() != GameMode.CREATIVE) {
            if(e.getCurrentItem().getType() == Material.WOOL) {
                if(e.getCurrentItem().getItemMeta().getDisplayName() == "§7Team §4Red"){
                    if(Var.team_red.size() < (Var.maxplayers/2)) {
                        if(Var.team_blue.contains(p)) {
                            Var.team_blue.remove(p);
                        }
                        if(Var.team_red.contains(p)) {
                            Var.team_red.remove(p);
                        }
                        Var.team_red.add(p);
                        e.setCancelled(true);
                        p.closeInventory();
                        p.sendMessage(Var.prefix.replace("&", "§") + Var.teams_joinred.replace("&", "§"));
                    } else {
                        p.sendMessage(Var.prefix.replace("&", "§") + Var.teams_full.replace("&", "§"));
                    }
                } else if(e.getCurrentItem().getItemMeta().getDisplayName() == "§7Team §9Blue") {
                    if (Var.team_blue.size() < (Var.maxplayers / 2)) {
                        if(Var.team_red.contains(p)) {
                            Var.team_red.remove(p);
                        }
                        if(Var.team_blue.contains(p)) {
                            Var.team_blue.remove(p);
                        }
                        Var.team_blue.add(p);
                        e.setCancelled(true);
                        p.closeInventory();
                        p.sendMessage(Var.prefix.replace("&", "§") + Var.teams_joinblue.replace("&", "§"));
                    } else {
                        p.sendMessage(Var.prefix.replace("&", "§") + Var.teams_full.replace("&", "§"));
                    }
                }
            } else {
                e.setCancelled(true);
            }
        }
    }

}
