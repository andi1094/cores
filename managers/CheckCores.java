package net.minecresthd.cores.managers;

import net.minecresthd.cores.Main;
import net.minecresthd.cores.Var;
import net.minecresthd.cores.listeners.onScoreboardEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CheckCores {

    public static int bi = 0;
    public static int ri = 0;

    public static Location red_leftcore = Factory.getConfigLocation("Spawn.Core.Red.Left", Var.locs);
    public static Location red_rightcore = Factory.getConfigLocation("Spawn.Core.Red.Right", Var.locs);
    public static Location blue_leftcore = Factory.getConfigLocation("Spawn.Core.Blue.Left", Var.locs);
    public static Location blue_rightcore = Factory.getConfigLocation("Spawn.Core.Blue.Right", Var.locs);

    public static void startCheckCore() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
            @Override
            public void run() {
                for(Player all : Bukkit.getOnlinePlayers()) {
                    onScoreboardEvent.updateScoreboard(all);
                    Location playerloc = all.getLocation();

                    if(Var.team_red.contains(all)) {
                        if(playerloc.distance(blue_leftcore) <= 3) {
                            if(!blue_leftcore.getBlock().isEmpty()) {
                                all.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING,80,0));
                                for (Player blue : Var.team_blue) {
                                    blue.playSound(blue.getLocation(), Sound.NOTE_BASS, 14, 14);
                                    if (bi < 5) {
                                        bi++;
                                        if (bi == 1) {
                                            blue.sendMessage(Var.prefix.replace("&", "§") + Var.core_blue_nearleft.replace("&", "§"));
                                        }
                                    } else {
                                        bi = 0;
                                    }
                                }
                            }
                        } else if(playerloc.distance(blue_rightcore) <= 3) {
                            if(!blue_rightcore.getBlock().isEmpty()) {
                                all.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING,80,0));
                                for (Player blue : Var.team_blue) {
                                    blue.playSound(blue.getLocation(), Sound.NOTE_BASS, 14, 14);
                                    if (bi < 5) {
                                        bi++;
                                        if (bi == 1) {
                                            blue.sendMessage(Var.prefix.replace("&", "§") + Var.core_blue_nearright.replace("&", "§"));
                                        }
                                    } else {
                                        bi = 0;
                                    }
                                }
                            }
                        }
                    } else if(Var.team_blue.contains(all)) {
                        if(playerloc.distance(red_leftcore) <= 3) {
                            if(!red_leftcore.getBlock().isEmpty()) {
                                all.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING,80,0));
                                for (Player red : Var.team_red) {
                                    red.playSound(red.getLocation(), Sound.NOTE_BASS, 14, 14);
                                    if (ri < 5) {
                                        ri++;
                                        if (ri == 1) {
                                            red.sendMessage(Var.prefix.replace("&", "§") + Var.core_red_nearleft.replace("&", "§"));
                                        }
                                    } else {
                                        ri = 0;
                                    }
                                }
                            }
                        } else if(playerloc.distance(red_rightcore) <= 3) {
                            if(!red_rightcore.getBlock().isEmpty()) {
                                all.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING,80,0));
                                for (Player red : Var.team_red) {
                                    red.playSound(red.getLocation(), Sound.NOTE_BASS, 14, 14);
                                    if (ri < 5) {
                                        ri++;
                                        if (ri == 1) {
                                            red.sendMessage(Var.prefix.replace("&", "§") + Var.core_red_nearright.replace("&", "§"));
                                        }
                                    } else {
                                        ri = 0;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }, 0, 40);
    }

}
