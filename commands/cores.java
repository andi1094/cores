package net.minecresthd.cores.commands;

import net.minecresthd.cores.Main;
import net.minecresthd.cores.Var;
import net.minecresthd.cores.managers.Factory;
import net.minecresthd.cores.managers.GameStateHandler;
import net.minecresthd.cores.managers.LobbyState;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.text.DecimalFormat;

public class cores implements CommandExecutor {

    public String getKD(Player p) {
        double kd = ((double) Main.main.sql.getKills(p)) / ((double)Main.main.sql.getDeaths(p));
        kd = ((double)((int)(kd*100))) / 100;
        return Double.valueOf(kd).toString();
    }

    public String getKDOther(String uuid) {
        double kd = ((double) Main.main.sql.getKillsOther(uuid)) / ((double)Main.main.sql.getDeathsOther(uuid));
        kd = ((double)((int)(kd*100))) / 100;
        return Double.valueOf(kd).toString();
    }

    public void helpMessage(Player p) {
        p.sendMessage("§7§m§l┏---------------------------┓");
        p.sendMessage("§7§m§l┠ §b§l Cores §7- §c§lby MineCrestHD");
        p.sendMessage("§7§m§l┠---------------------------┨");
        p.sendMessage("§7§m§l┠ §r§6§l Standart Commands:");
        p.sendMessage("§7§m§l┠ §r§e  /cores help");
        p.sendMessage("§7§m§l┠ §r§e  /cores start");
        p.sendMessage("§7§m§l┠ §r§e  /cores stats");
        p.sendMessage("§7§m§l┠ §r§6§l Setup Commands:");
        p.sendMessage("§7§m§l┠ §r§e  /cores setspawn lobby");
        p.sendMessage("§7§m§l┠ §r§e  /cores setspawn spectator");
        p.sendMessage("§7§m§l┠ §r§e  /cores setspawn spawn red");
        p.sendMessage("§7§m§l┠ §r§e  /cores setspawn spawn blue");
        p.sendMessage("§7§m§l┠ §r§e  /cores setspawn core red left");
        p.sendMessage("§7§m§l┠ §r§e  /cores setspawn core red right");
        p.sendMessage("§7§m§l┠ §r§e  /cores setspawn core blue left");
        p.sendMessage("§7§m§l┠ §r§e  /cores setspawn core blue right");
        p.sendMessage("§7§m§l┗---------------------------┛");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        File file = Var.locsFile;
        YamlConfiguration cfg = Var.locs;

        if (sender instanceof Player) {
            if (args.length==1 && args[0].equalsIgnoreCase("start")) {
                if (p.hasPermission("cores.start")) {
                    if (args.length == 1) {
                        if (GameStateHandler.getGameState() instanceof LobbyState) {
                            LobbyState ls = (LobbyState) GameStateHandler.getGameState();
                            if ((ls.getCountdown().getSeconds() > Var.start_seconds) && (Var.playing.size() == 2)) {
                                ls.getCountdown().setSeconds(Var.start_seconds);
                                p.sendMessage(Var.prefix.replace("&", "§") + Var.start_successfully.replace("&", "§"));
                            } else if (Var.playing.size() == 1) {
                                p.sendMessage(Var.prefix.replace("&", "§") + Var.start_missing.replace("&", "§"));
                            } else {
                                p.sendMessage(Var.prefix.replace("&", "§") + Var.start_already.replace("&", "§"));
                            }
                        } else {
                            p.sendMessage(Var.prefix.replace("&", "§") + Var.start_already.replace("&", "§"));
                        }
                    } else {
                        p.sendMessage(Var.prefix.replace("&", "§") + Var.start_usage.replace("&", "§"));
                    }
                } else {
                    p.sendMessage(Var.prefix.replace("&", "§") + Var.noperm.replace("&", "§"));
                }
            } else if ((args.length==1 || args.length==2) && args[0].equalsIgnoreCase("stats")) {
                if (args.length == 1) {
                    if (Main.main.sql.isPlayerExist(p.getUniqueId().toString())) {
                        p.sendMessage(" ");
                        p.sendMessage(Var.stats_line1.replace("&", "§").replace("%player%", p.getName()).replace("%kills%", Integer.toString(Main.main.sql.getKills(p))).replace("%deaths%", Integer.toString(Main.main.sql.getDeaths(p))).replace("%kd%", getKD(p)).replace("%pgames%", Integer.toString(Main.main.sql.getPlayed(p))).replace("%wgames%", Integer.toString(Main.main.sql.getWon(p))));
                        p.sendMessage(Var.stats_line2.replace("&", "§").replace("%player%", p.getName()).replace("%kills%", Integer.toString(Main.main.sql.getKills(p))).replace("%deaths%", Integer.toString(Main.main.sql.getDeaths(p))).replace("%kd%", getKD(p)).replace("%pgames%", Integer.toString(Main.main.sql.getPlayed(p))).replace("%wgames%", Integer.toString(Main.main.sql.getWon(p))));
                        p.sendMessage(Var.stats_line3.replace("&", "§").replace("%player%", p.getName()).replace("%kills%", Integer.toString(Main.main.sql.getKills(p))).replace("%deaths%", Integer.toString(Main.main.sql.getDeaths(p))).replace("%kd%", getKD(p)).replace("%pgames%", Integer.toString(Main.main.sql.getPlayed(p))).replace("%wgames%", Integer.toString(Main.main.sql.getWon(p))));
                        p.sendMessage(Var.stats_line4.replace("&", "§").replace("%player%", p.getName()).replace("%kills%", Integer.toString(Main.main.sql.getKills(p))).replace("%deaths%", Integer.toString(Main.main.sql.getDeaths(p))).replace("%kd%", getKD(p)).replace("%pgames%", Integer.toString(Main.main.sql.getPlayed(p))).replace("%wgames%", Integer.toString(Main.main.sql.getWon(p))));
                        p.sendMessage(Var.stats_line5.replace("&", "§").replace("%player%", p.getName()).replace("%kills%", Integer.toString(Main.main.sql.getKills(p))).replace("%deaths%", Integer.toString(Main.main.sql.getDeaths(p))).replace("%kd%", getKD(p)).replace("%pgames%", Integer.toString(Main.main.sql.getPlayed(p))).replace("%wgames%", Integer.toString(Main.main.sql.getWon(p))));
                        p.sendMessage(" ");
                    } else {
                        p.sendMessage(Var.prefix.replace("&", "§") + Var.stats_noround_own.replace("&", "§").replace("%player%", p.getName()));
                    }
                } else if (args.length == 2) {
                    String p2 = Bukkit.getOfflinePlayer(args[1]).getUniqueId().toString();
                    if (Main.main.sql.isPlayerExist(p2)) {
                        p.sendMessage(" ");
                        p.sendMessage(Var.stats_line1.replace("&", "§").replace("%player%", args[1]).replace("%kills%", Integer.toString(Main.main.sql.getKillsOther(p2))).replace("%deaths%", Integer.toString(Main.main.sql.getDeathsOther(p2))).replace("%kd%", getKDOther(p2)).replace("%pgames%", Integer.toString(Main.main.sql.getPlayedOther(p2))).replace("%wgames%", Integer.toString(Main.main.sql.getWonOther(p2))));
                        p.sendMessage(Var.stats_line2.replace("&", "§").replace("%player%", args[1]).replace("%kills%", Integer.toString(Main.main.sql.getKillsOther(p2))).replace("%deaths%", Integer.toString(Main.main.sql.getDeathsOther(p2))).replace("%kd%", getKDOther(p2)).replace("%pgames%", Integer.toString(Main.main.sql.getPlayedOther(p2))).replace("%wgames%", Integer.toString(Main.main.sql.getWonOther(p2))));
                        p.sendMessage(Var.stats_line3.replace("&", "§").replace("%player%", args[1]).replace("%kills%", Integer.toString(Main.main.sql.getKillsOther(p2))).replace("%deaths%", Integer.toString(Main.main.sql.getDeathsOther(p2))).replace("%kd%", getKDOther(p2)).replace("%pgames%", Integer.toString(Main.main.sql.getPlayedOther(p2))).replace("%wgames%", Integer.toString(Main.main.sql.getWonOther(p2))));
                        p.sendMessage(Var.stats_line4.replace("&", "§").replace("%player%", args[1]).replace("%kills%", Integer.toString(Main.main.sql.getKillsOther(p2))).replace("%deaths%", Integer.toString(Main.main.sql.getDeathsOther(p2))).replace("%kd%", getKDOther(p2)).replace("%pgames%", Integer.toString(Main.main.sql.getPlayedOther(p2))).replace("%wgames%", Integer.toString(Main.main.sql.getWonOther(p2))));
                        p.sendMessage(Var.stats_line5.replace("&", "§").replace("%player%", args[1]).replace("%kills%", Integer.toString(Main.main.sql.getKillsOther(p2))).replace("%deaths%", Integer.toString(Main.main.sql.getDeathsOther(p2))).replace("%kd%", getKDOther(p2)).replace("%pgames%", Integer.toString(Main.main.sql.getPlayedOther(p2))).replace("%wgames%", Integer.toString(Main.main.sql.getWonOther(p2))));
                        p.sendMessage(" ");
                    } else {
                        p.sendMessage(Var.prefix.replace("&", "§") + Var.stats_noround_other.replace("&", "§").replace("%player%", args[1]));
                    }
                } else {
                    p.sendMessage(Var.prefix.replace("&", "§") + Var.stats_usage.replace("&", "§"));
                }
            } else if (p.hasPermission("cores.setup")) {
                if (args.length == 0) {
                    helpMessage(p);
                } else if (args[0].equalsIgnoreCase("help")) {
                    helpMessage(p);
                } else if (args[0].equalsIgnoreCase("setspawn")) {
                    if (args.length == 2) {
                        if (args[1].equalsIgnoreCase("lobby")) {
                            Factory.createConfigLocation(p.getLocation(), "Spawn.Lobby", file, cfg);
                            p.sendMessage(Var.prefix.replace("&", "§") + Var.setspawn_lobbyset.replace("&", "§"));
                        } else if (args[1].equalsIgnoreCase("spectator")) {
                            Factory.createConfigLocation(p.getLocation(), "Spawn.Spectator", file, cfg);
                            p.sendMessage(Var.prefix.replace("&", "§") + Var.setspawn_specset.replace("&", "§"));
                        } else if (args[1].equalsIgnoreCase("spawn")) {
                            p.sendMessage(Var.prefix.replace("&", "§") + Var.setspawn_spawnsetusage.replace("&", "§"));
                        }
                    } else if (args.length == 3) {
                        if (args[1].equalsIgnoreCase("spawn")) {
                            if ((args[2].equalsIgnoreCase("red"))) {
                                Factory.createConfigLocation(p.getLocation(), "Spawn.spawn." + 1, file, cfg);
                                p.sendMessage(Var.prefix.replace("&", "§") + Var.setspawn_spawnset.replace("&", "§").replace("%spawn%", "1"));
                            } else if ((args[2].equalsIgnoreCase("blue"))) {
                                Factory.createConfigLocation(p.getLocation(), "Spawn.spawn." + 2, file, cfg);
                                p.sendMessage(Var.prefix.replace("&", "§") + Var.setspawn_spawnset.replace("&", "§").replace("%spawn%", "2"));
                            } else {
                                p.sendMessage(Var.prefix.replace("&", "§") + Var.setspawn_spawnsetusage.replace("&", "§"));
                            }
                        } else {
                            p.sendMessage(Var.prefix.replace("&", "§") + Var.setspawn_usage.replace("&", "§"));
                        }
                    } else if (args.length == 4) {
                        if (args[1].equalsIgnoreCase("core")) {
                            if (args[2].equalsIgnoreCase("red")) {
                                if (args[3].equalsIgnoreCase("left")) {
                                    Factory.createConfigLocation(p.getLocation(), "Spawn.Core.Red.Left", file, cfg);
                                    p.sendMessage(Var.prefix.replace("&", "§") + Var.setspawn_coreredleft.replace("&", "§"));
                                } else if (args[3].equalsIgnoreCase("right")) {
                                    Factory.createConfigLocation(p.getLocation(), "Spawn.Core.Red.Right", file, cfg);
                                    p.sendMessage(Var.prefix.replace("&", "§") + Var.setspawn_coreredright.replace("&", "§"));
                                } else {
                                    p.sendMessage(Var.prefix.replace("&", "§") + Var.setspawn_usage.replace("&", "§"));
                                }
                            } else if (args[2].equalsIgnoreCase("blue")) {
                                if (args[3].equalsIgnoreCase("left")) {
                                    Factory.createConfigLocation(p.getLocation(), "Spawn.Core.Blue.Left", file, cfg);
                                    p.sendMessage(Var.prefix.replace("&", "§") + Var.setspawn_coreblueleft.replace("&", "§"));
                                } else if (args[3].equalsIgnoreCase("right")) {
                                    Factory.createConfigLocation(p.getLocation(), "Spawn.Core.Blue.Right", file, cfg);
                                    p.sendMessage(Var.prefix.replace("&", "§") + Var.setspawn_coreblueright.replace("&", "§"));
                                } else {
                                    p.sendMessage(Var.prefix.replace("&", "§") + Var.setspawn_usage.replace("&", "§"));
                                }
                            } else {
                                p.sendMessage(Var.prefix.replace("&", "§") + Var.setspawn_usage.replace("&", "§"));
                            }
                        } else {
                            p.sendMessage(Var.prefix.replace("&", "§") + Var.setspawn_usage.replace("&", "§"));
                        }
                    } else {
                        p.sendMessage(Var.prefix.replace("&", "§") + Var.setspawn_usage.replace("&", "§"));
                    }
                } else {
                    helpMessage(p);
                }
            } else {
                p.sendMessage(Var.prefix.replace("&", "§") + Var.noperm.replace("&", "§"));
            }
        }

        return false;
    }

}
