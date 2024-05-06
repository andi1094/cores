package net.minecresthd.cores;

import net.minecresthd.cores.commands.cores;
import net.minecresthd.cores.listeners.*;
import net.minecresthd.cores.managers.Config;
import net.minecresthd.cores.managers.GameState;
import net.minecresthd.cores.managers.GameStateHandler;
import net.minecresthd.cores.mysql.MySQL;
import net.minecresthd.cores.mysql.MySQL_coins;
import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main plugin;
    public static Main main;
    public MySQL sql;
    public MySQL_coins sqlc;
    public Config cfg;

    @Override
    public void onEnable() {
        cfg = new Config();
        cfg.register();
        Bukkit.getServer().createWorld(new WorldCreator(Var.world_lobby));
        Bukkit.getServer().createWorld(new WorldCreator(Var.world_game));
        Bukkit.getConsoleSender().sendMessage("§f§l[-----------------------------------]");
        Bukkit.getConsoleSender().sendMessage("§f§l| §7§l-> §bCores §7- §8" + this.getDescription().getVersion());
        Bukkit.getConsoleSender().sendMessage("§f§l| §7§l-> §8by §oMineCrestHD");
        Bukkit.getConsoleSender().sendMessage("§f§l|");
        plugin = this;
        main = this;
        sql = new MySQL();
        sqlc = new MySQL_coins();
        new GameStateHandler();
        GameStateHandler.setGameState(GameState.LOBBY_STATE);
        init();
        Bukkit.getConsoleSender().sendMessage("§f§l|");
        Bukkit.getConsoleSender().sendMessage("§f§l[-----------------------------------]");
    }

    @Override
    public void onDisable() {
        sql = new MySQL();
        sqlc = new MySQL_coins();
        Bukkit.getConsoleSender().sendMessage("§f§l[-----------------------------------]");
        Bukkit.getConsoleSender().sendMessage("§f§l| §7§l-> §bCores §7- §8" + this.getDescription().getVersion());
        Bukkit.getConsoleSender().sendMessage("§f§l| §7§l-> §8by §oMineCrestHD");
        sql.close();
        sqlc.close();
        Bukkit.getConsoleSender().sendMessage("§f§l[-----------------------------------]");
    }

    private void init() {
        sqlc.connect();
        sqlc.createTable();
        sql.connect();
        sql.createTable();

        this.getCommand("cores").setExecutor(new cores());

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new onJoinEvent(), this);
        pm.registerEvents(new onQuitEvent(), this);
        pm.registerEvents(new onServerPingEvent(), this);
        pm.registerEvents(new onBuildEvent(), this);
        pm.registerEvents(new onMoveEvent(), this);
        pm.registerEvents(new onAttackEvent(), this);
        pm.registerEvents(new onDeathEvent(), this);
        pm.registerEvents(new onTeamsEvent(), this);
        pm.registerEvents(new onFoodEvent(), this);
        pm.registerEvents(new onChatEvent(), this);
        pm.registerEvents(new onWeatherEvent(), this);
        pm.registerEvents(new onDropEvent(), this);

        Bukkit.getWorld(Var.world_lobby).setStorm(false);
        Bukkit.getWorld(Var.world_lobby).setThundering(false);
        Bukkit.getWorld(Var.world_lobby).setTime(6000);
        Bukkit.getWorld(Var.world_lobby).setGameRuleValue("doDayLightCycle", "false");
        Bukkit.getWorld(Var.world_game).setStorm(false);
        Bukkit.getWorld(Var.world_game).setThundering(false);
        Bukkit.getWorld(Var.world_game).setTime(6000);
        Bukkit.getWorld(Var.world_game).setGameRuleValue("doDayLightCycle", "false");
    }

    public static Main getPlugin() {
        return plugin;
    }

}
