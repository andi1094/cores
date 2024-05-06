package net.minecresthd.cores.listeners;

import net.minecresthd.cores.Var;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityShootBowEvent;

public class onAttackEvent implements Listener {

    @EventHandler
    public void onAttack(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player) {
            if ((!Var.canAttack) ||(Var.team_blue.contains(e.getEntity()) && Var.team_blue.contains(e.getDamager())) || (Var.team_red.contains(e.getEntity()) && Var.team_red.contains(e.getDamager()))) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            if (!Var.canAttack) {
                e.setCancelled(true);
            }
        }
    }

}
