package net.minecresthd.cores.managers;

import net.minecresthd.cores.Main;
import net.minecresthd.cores.Var;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public abstract class GameState {

    public static final int LOBBY_STATE = 0,
            INGAME_STATE = 1;

    public abstract void init();
    public abstract void end();

    @SuppressWarnings({ "deprecation", "static-access" })
    public static void checkWinning() {
        if(GameStateHandler.getGameState() instanceof IngameState) {
            if(Var.isWon==false) {
                if (Var.playing.size() <= 1 || Var.team_red.size() < 1 || Var.team_blue.size() < 1) {
                    if (Var.team_blue.size() < 1) {
                        GameStateHandler.getGameState().end();
                        Bukkit.broadcastMessage(Var.prefix.replace("&", "§") + Var.teams_redwon.replace("&", "§"));
                        for (int i = 0; i < Var.team_red.size(); i++) {
                            Player all = Var.team_red.get(i);
                            Main.main.sql.addWon(all, 1);
                            Main.main.sqlc.addCoins(all, Var.coins_win);
                            all.sendMessage(Var.prefix.replace("&", "§") + Var.coins_addedcoins.replace("&", "§").replace("%coins%", Integer.toString(Var.coins_win)));
                            all.playSound(all.getLocation(), Sound.LEVEL_UP, 1, 1);
                            all.sendTitle(Var.teams_title_redwon.replace("&", "§"), Var.teams_subtitle_redwon.replace("&", "§"));
                        }
                        Var.isWon = true;
                    } else if (Var.team_red.size() < 1) {
                        GameStateHandler.getGameState().end();
                        Bukkit.broadcastMessage(Var.prefix.replace("&", "§") + Var.teams_bluewon.replace("&", "§"));
                        for (int i = 0; i < Var.team_blue.size(); i++) {
                            Player all = Var.team_blue.get(i);
                            Main.main.sql.addWon(all, 1);
                            Main.main.sqlc.addCoins(all, Var.coins_win);
                            all.sendMessage(Var.prefix.replace("&", "§") + Var.coins_addedcoins.replace("&", "§").replace("%coins%", Integer.toString(Var.coins_win)));
                            all.playSound(all.getLocation(), Sound.LEVEL_UP, 1, 1);
                            all.sendTitle(Var.teams_title_bluewon.replace("&", "§"), Var.teams_subtitle_bluewon.replace("&", "§"));
                        }
                        Var.isWon = true;
                    }
                } else if (Factory.getConfigLocation("Spawn.Core.Red.Left", Var.locs).getBlock().isEmpty() && Factory.getConfigLocation("Spawn.Core.Red.Right", Var.locs).getBlock().isEmpty()) {
                    GameStateHandler.getGameState().end();
                    Bukkit.broadcastMessage(Var.prefix.replace("&", "§") + Var.teams_bluewon.replace("&", "§"));
                    for (int i = 0; i < Var.team_blue.size(); i++) {
                        Player all = Var.team_blue.get(i);
                        Main.main.sql.addWon(all, 1);
                        Main.main.sqlc.addCoins(all, Var.coins_win);
                        all.sendMessage(Var.prefix.replace("&", "§") + Var.coins_addedcoins.replace("&", "§").replace("%coins%", Integer.toString(Var.coins_win)));
                        all.playSound(all.getLocation(), Sound.LEVEL_UP, 1, 1);
                        all.sendTitle(Var.teams_title_bluewon.replace("&", "§"), Var.teams_subtitle_bluewon.replace("&", "§"));
                    }
                    Var.isWon = true;
                } else if (Factory.getConfigLocation("Spawn.Core.Blue.Left", Var.locs).getBlock().isEmpty() && Factory.getConfigLocation("Spawn.Core.Blue.Right", Var.locs).getBlock().isEmpty()) {
                    GameStateHandler.getGameState().end();
                    Bukkit.broadcastMessage(Var.prefix.replace("&", "§") + Var.teams_redwon.replace("&", "§"));
                    for (int i = 0; i < Var.team_red.size(); i++) {
                        Player all = Var.team_red.get(i);
                        Main.main.sql.addWon(all, 1);
                        Main.main.sqlc.addCoins(all, Var.coins_win);
                        all.sendMessage(Var.prefix.replace("&", "§") + Var.coins_addedcoins.replace("&", "§").replace("%coins%", Integer.toString(Var.coins_win)));
                        all.playSound(all.getLocation(), Sound.LEVEL_UP, 1, 1);
                        all.sendTitle(Var.teams_title_redwon.replace("&", "§"), Var.teams_subtitle_redwon.replace("&", "§"));
                    }
                    Var.isWon = true;
                }
            }
        }
    }

}
