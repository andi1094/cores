package net.minecresthd.cores.countdowns;

import net.minecresthd.cores.Main;
import net.minecresthd.cores.Var;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class GraceCountdown extends Countdown {

    private int TaskID;
    private int seconds = Var.gracecd_seconds;

    @Override
    public void start() {
        Var.canAttack = false;

        TaskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {

            @Override
            public void run() {
                switch(seconds) {
                    case 30: case 15: case 10: case 5: case 3: case 2:
                        Bukkit.broadcastMessage(Var.prefix.replace("&", "§") + Var.gracecd_startin_seconds.replace("&", "§").replace("%seconds%", Integer.toString(seconds)));
                        break;
                    case 1:
                        Bukkit.broadcastMessage(Var.prefix.replace("&", "§") + Var.gracecd_startin_second.replace("&", "§").replace("%seconds%", Integer.toString(seconds)));
                        break;
                    case 0:
                        stop();
                        Bukkit.broadcastMessage(Var.prefix.replace("&", "§") + Var.gracecd_readytofight.replace("&", "§"));
                        Var.canAttack = true;
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

}
