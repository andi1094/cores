package net.minecresthd.cores.countdowns;

import net.minecresthd.cores.Main;
import net.minecresthd.cores.Var;
import net.minecresthd.cores.managers.GameState;
import net.minecresthd.cores.managers.GameStateHandler;
import net.minecresthd.cores.managers.LobbyState;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.Random;

public class LobbyCountdown extends Countdown {

    private int seconds = Var.lobbycd_seconds;
    private int TaskID, IdleID;
    public boolean isIdling = false, isRunning = false;

    @Override
    public void start() {
        isRunning = true;
        TaskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {

            @SuppressWarnings("deprecation")
            @Override
            public void run() {
                for(Player all : Bukkit.getOnlinePlayers()) {
                    all.setLevel(seconds);
                }
                switch(seconds) {
                    case 60: case 30: case 15: case 10: case 5: case 4: case 3: case 2:
                        Bukkit.broadcastMessage(Var.prefix.replace("&", "§") + Var.lobbycd_startin_seconds.replace("&", "§").replace("%seconds%", Integer.toString(seconds)));
                        for(Player all : Var.playing) {
                            all.playSound(all.getLocation(), Sound.LEVEL_UP, 1, 1);
                            all.sendTitle("§e" + seconds, "");
                        }
                        break;
                    case 1:
                        Bukkit.broadcastMessage(Var.prefix.replace("&", "§") + Var.lobbycd_startin_second.replace("&", "§").replace("%seconds%", Integer.toString(seconds)));
                        for(Player all : Bukkit.getOnlinePlayers()) {
                            all.playSound(all.getLocation(), Sound.LEVEL_UP, 1, 1);
                            all.sendTitle("§e" + seconds, "");
                            if(!Var.team_red.contains(all) && !Var.team_blue.contains(all)){
                                if(Var.team_red.size() < Var.team_blue.size()) {
                                    Var.team_red.add(all);
                                } else if(Var.team_red.size() > Var.team_blue.size()) {
                                    Var.team_blue.add(all);
                                } else if(Var.team_red.size() == Var.team_blue.size()) {
                                    int rnd = (int)(Math.random() * 2 + 1);
                                    if(rnd == 1) {
                                        Var.team_red.add(all);
                                    } else if(rnd == 2) {
                                        Var.team_blue.add(all);
                                    }
                                }
                            }
                        }
                        break;
                    case 0:
                        GameStateHandler.setGameState(GameState.INGAME_STATE);
                        break;
                    default:
                        break;
                }
                seconds--;
            }

        }, 0, 20*1);
    }

    public void idle() {
        isIdling = true;
        IdleID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {

            @Override
            public void run() {

                int missing = Var.minplayers - Var.playing.size();
                Bukkit.broadcastMessage(Var.prefix.replace("&", "§") + Var.lobbycd_missingplayers.replace("&", "§").replace("%players%", Integer.toString(missing)));

            }

        }, 0, 20*10);
    }

    public void stopIdle() {
        if(isIdling) {
            isIdling = false;
            Bukkit.getScheduler().cancelTask(IdleID);
        }
    }

    public void stopCountdown() {
        if(isRunning) {
            isRunning = false;
            Bukkit.getScheduler().cancelTask(TaskID);
            seconds = Var.lobbycd_seconds;
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.setLevel(0);
            }
        }
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public void stop() {
        isIdling = false;
        isRunning = false;
        seconds = Var.lobbycd_seconds;
        Bukkit.getScheduler().cancelTask(TaskID);
        Bukkit.getScheduler().cancelTask(IdleID);
    }

}

