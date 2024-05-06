package net.minecresthd.cores.countdowns;

import net.minecresthd.cores.Main;
import net.minecresthd.cores.Var;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class SpawnCountdown extends Countdown {

    private int TaskID;
    private int seconds = Var.spawncd_seconds;
    private GraceCountdown gracecd;

    public SpawnCountdown() {
        gracecd = new GraceCountdown();
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

    @Override
    public void start() {
        Var.canAttack = false;
        Var.canBuild = false;
        Var.canMove = false;

        TaskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {

            @Override
            public void run() {
                switch(seconds) {
                    case 10: case 5: case 3: case 2:
                        Bukkit.broadcastMessage(Var.prefix.replace("&", "§") + Var.spawncd_startin_seconds.replace("&", "§").replace("%seconds%", Integer.toString(seconds)));
                        break;
                    case 1:
                        Bukkit.broadcastMessage(Var.prefix.replace("&", "§") + Var.spawncd_startin_second.replace("&", "§").replace("%seconds%", Integer.toString(seconds)));
                        break;
                    case 0:
                        stop();
                        Var.canMove = true;
                        Var.canBuild = true;
                        for(Player all : Bukkit.getOnlinePlayers()) {
                            Main.main.sql.addPlayed(all, 1);
                            all.getInventory().addItem(Var.createItem(272,0,"","",1,null,0));
                            all.getInventory().addItem(Var.createItem(261,0,"","",1,null,0));
                            all.getInventory().addItem(Var.createItem(257,0,"","",1,null,0));
                            all.getInventory().addItem(Var.createItem(258,0,"","",1,null,0));
                            all.getInventory().addItem(Var.createItem(322,0,"","",16,null,0));
                            all.getInventory().setItem(6, Var.createItem(262,0,"","",16,null,0));
                            all.getInventory().setItem(7, Var.createItem(297,0,"","",64,null,0));
                            all.getInventory().setItem(8, Var.createItem(17,0,"","",64,null,0));
                            all.getInventory().setHelmet(Helmet(all));
                            all.getInventory().setChestplate(Chestplate(all));
                            all.getInventory().setLeggings(Leggings(all));
                            all.getInventory().setBoots(Boots(all));
                        }
                        gracecd.start();
                        break;
                    default:
                        break;
                }
                seconds--;
            }

        }, 0, 20);
    }

    @Override
    public void stop() {
        Bukkit.getScheduler().cancelTask(TaskID);
    }

    public GraceCountdown getGracecd() {
        return gracecd;
    }

}
