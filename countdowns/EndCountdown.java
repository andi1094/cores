package net.minecresthd.cores.countdowns;

import net.minecresthd.cores.Main;
import net.minecresthd.cores.Var;
import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;

public class EndCountdown extends Countdown {

    private int taskID;
    private int seconds = Var.endcd_seconds;

    @Override
    public void start() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {

            @Override
            public void run() {

                switch(seconds) {
                    case 10: case 5: case 4: case 3: case 2:
                        Bukkit.broadcastMessage(Var.prefix.replace("&", "§") + Var.endcd_startin_seconds.replace("&", "§").replace("%seconds%", Integer.toString(seconds)));
                        break;
                    case 1:
                        Bukkit.broadcastMessage(Var.prefix.replace("&", "§") + Var.endcd_startin_second.replace("&", "§").replace("%seconds%", Integer.toString(seconds)));
                        break;
                    case 0:
                        for(Player all : Bukkit.getOnlinePlayers()) {
                            all.kickPlayer("");
                        }
                        Bukkit.getServer().unloadWorld(Var.world_lobby, false);
                        Bukkit.getServer().createWorld(new WorldCreator(Var.world_lobby));
                        Bukkit.getServer().unloadWorld(Var.world_game, false);
                        Bukkit.getServer().createWorld(new WorldCreator(Var.world_game));
                        Bukkit.getServer().shutdown();
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
        Bukkit.getScheduler().cancelTask(taskID);
    }

}
