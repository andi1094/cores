package net.minecresthd.cores.managers;

import net.minecresthd.cores.Var;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Config {

    public File file = new File("plugins/Cores/config.yml");
    public YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public void register() {
        cfg.options().copyDefaults(true);
        cfg.addDefault("Config.Prefix", Var.prefix);
        cfg.addDefault("Config.Map", Var.map);
        cfg.addDefault("Config.NoPermission", Var.noperm);
        cfg.addDefault("Config.MinPlayers", Var.minplayers);
        cfg.addDefault("Config.MaxPlayers", Var.maxplayers);
        cfg.addDefault("Config.LobbyWorld", Var.world_lobby);
        cfg.addDefault("Config.GameWorld", Var.world_game);
        cfg.addDefault("Config.MotdContain.Lobby", Var.motd_lobby);
        cfg.addDefault("Config.MotdContain.Ingame", Var.motd_ingame);
        //TEAMS
        cfg.addDefault("Config.Messages.Teams.Red.Join", Var.teams_joinred);
        cfg.addDefault("Config.Messages.Teams.Blue.Join", Var.teams_joinblue);
        cfg.addDefault("Config.Messages.Teams.Full", Var.teams_full);
        cfg.addDefault("Config.Messages.Teams.Red.Win", Var.teams_redwon);
        cfg.addDefault("Config.Messages.Teams.Blue.Win", Var.teams_bluewon);
        cfg.addDefault("Config.Messages.Teams.Red.Title", Var.teams_title_redwon);
        cfg.addDefault("Config.Messages.Teams.Red.SubTitle", Var.teams_subtitle_redwon);
        cfg.addDefault("Config.Messages.Teams.Blue.Title", Var.teams_title_bluewon);
        cfg.addDefault("Config.Messages.Teams.Blue.SubTitle", Var.teams_subtitle_bluewon);
        //COINS
        cfg.addDefault("Config.Coins.Kill", Var.coins_kill);
        cfg.addDefault("Config.Coins.Win", Var.coins_win);
        cfg.addDefault("Config.Coins.Core", Var.coins_core);
        cfg.addDefault("Config.Coins.Messages.AddCoins", Var.coins_addedcoins);
        //MESSAGES
        cfg.addDefault("Config.Messages.Join", Var.joinmsg);
        cfg.addDefault("Config.Messages.Ingame.Quit", Var.joinmsg_ingame);
        cfg.addDefault("Config.Messages.Quit", Var.quitmsg);
        cfg.addDefault("Config.Messages.Ingame.Quit", Var.quitmsg_ingame);
        cfg.addDefault("Config.Messages.Kill", Var.killmsg);
        cfg.addDefault("Config.Messages.Death", Var.deathmsg);
        cfg.addDefault("Config.Settings.InstantDeath", Var.instantdeath);
        cfg.addDefault("Config.Messages.SpectatorChat", Var.chat_spectator);
        cfg.addDefault("Config.Messages.AllPlayersTeleport", Var.ingame_allplayers_teleport);
        cfg.addDefault("Config.Messages.Core.RedLeftDestroyed", Var.core_redleft_destroy);
        cfg.addDefault("Config.Messages.Core.RedRightDestroyed", Var.core_redright_destroy);
        cfg.addDefault("Config.Messages.Core.BlueLeftDestroyed", Var.core_blueleft_destroy);
        cfg.addDefault("Config.Messages.Core.BlueRightDestroyed", Var.core_blueright_destroy);
        cfg.addDefault("Config.Messages.NearRedLeftCore", Var.core_red_nearleft);
        cfg.addDefault("Config.Messages.NearRedRightCore", Var.core_red_nearright);
        cfg.addDefault("Config.Messages.NearBlueLeftCore", Var.core_blue_nearleft);
        cfg.addDefault("Config.Messages.NearBlueRightCore", Var.core_blue_nearright);
        cfg.addDefault("Config.BuildDistance.Core", Var.core_build_distance);
        cfg.addDefault("Config.BuildDistance.Spawn", Var.spawn_build_distance);
        //COMMAND STATS
        cfg.addDefault("Config.Commands.Stats.Messages.Line1", Var.stats_line1);
        cfg.addDefault("Config.Commands.Stats.Messages.Line2", Var.stats_line2);
        cfg.addDefault("Config.Commands.Stats.Messages.Line3", Var.stats_line3);
        cfg.addDefault("Config.Commands.Stats.Messages.Line4", Var.stats_line4);
        cfg.addDefault("Config.Commands.Stats.Messages.Line5", Var.stats_line5);
        cfg.addDefault("Config.Commands.Stats.Messages.NoRoundPlayed.Own", Var.stats_noround_own);
        cfg.addDefault("Config.Commands.Stats.Messages.NoRoundPlayed.Other", Var.stats_noround_other);
        cfg.addDefault("Config.Commands.Stats.Messages.StatsUsage", Var.stats_usage);
        //COMMAND START
        cfg.addDefault("Config.Commands.Start.Messages.StartSuccessfully", Var.start_successfully);
        cfg.addDefault("Config.Commands.Start.Messages.StartAlready", Var.start_already);
        cfg.addDefault("Config.Commands.Start.Messages.StartMissing", Var.start_missing);
        cfg.addDefault("Config.Commands.Start.Messages.StartUsage", Var.start_usage);
        cfg.addDefault("Config.Commands.Start.Settings.StartAtSecond", Var.start_seconds);
        //COMMAND SETSPAWN
        cfg.addDefault("Config.Commands.SetSpawn.Messages.WarpLobby", Var.setspawn_lobbyset);
        cfg.addDefault("Config.Commands.SetSpawn.Messages.WarpSpectator", Var.setspawn_specset);
        cfg.addDefault("Config.Commands.SetSpawn.Messages.Spawn-1-Red", Var.setspawn_spawn1red);
        cfg.addDefault("Config.Commands.SetSpawn.Messages.Spawn-2-Blue", Var.setspawn_spawn2blue);
        cfg.addDefault("Config.Commands.SetSpawn.Messages.SpawnSetUsage", Var.setspawn_spawnsetusage);
        cfg.addDefault("Config.Commands.SetSpawn.Messages.WarpSpawn", Var.setspawn_spawnset);
        cfg.addDefault("Config.Commands.SetSpawn.Messages.Core-Red-Left", Var.setspawn_coreredleft);
        cfg.addDefault("Config.Commands.SetSpawn.Messages.Core-Red-Right", Var.setspawn_coreredright);
        cfg.addDefault("Config.Commands.SetSpawn.Messages.Core-Blue-Left", Var.setspawn_coreblueleft);
        cfg.addDefault("Config.Commands.SetSpawn.Messages.Core-Blue-Right", Var.setspawn_coreblueright);
        cfg.addDefault("Config.Commands.SetSpawn.Messages.SetSpawnUsage", Var.setspawn_usage);
        //COUNTDOWN LOBBY
        cfg.addDefault("Config.Countdowns.Lobby.Seconds", Var.lobbycd_seconds);
        cfg.addDefault("Config.Countdowns.Lobby.StartInSeconds", Var.lobbycd_startin_seconds);
        cfg.addDefault("Config.Countdowns.Lobby.StartInSecond", Var.lobbycd_startin_second);
        cfg.addDefault("Config.Countdowns.Lobby.MissingPlayers", Var.lobbycd_missingplayers);
        //COUNTDOWN SPAWN
        cfg.addDefault("Config.Countdowns.Spawn.Seconds", Var.spawncd_seconds);
        cfg.addDefault("Config.Countdowns.Spawn.StartInSeconds", Var.spawncd_startin_seconds);
        cfg.addDefault("Config.Countdowns.Spawn.StartInSecond", Var.spawncd_startin_second);
        //COUNTDOWN GRACE
        cfg.addDefault("Config.Countdowns.Grace.Seconds", Var.gracecd_seconds);
        cfg.addDefault("Config.Countdowns.Grace.StartInSeconds", Var.gracecd_startin_seconds);
        cfg.addDefault("Config.Countdowns.Grace.StartInSecond", Var.gracecd_startin_second);
        cfg.addDefault("Config.Countdowns.Grace.ReadyToFight", Var.gracecd_readytofight);
        //COUNTDOWN END
        cfg.addDefault("Config.Countdowns.End.Seconds", Var.endcd_seconds);
        cfg.addDefault("Config.Countdowns.End.StartInSeconds", Var.endcd_startin_seconds);
        cfg.addDefault("Config.Countdowns.End.StartInSecond", Var.endcd_startin_second);
        //CHAT
        cfg.addDefault("Config.Chat.Rank1", Var.chat_rank1);
        cfg.addDefault("Config.Chat.Rank2", Var.chat_rank2);
        cfg.addDefault("Config.Chat.Rank3", Var.chat_rank3);
        cfg.addDefault("Config.Chat.Rank4", Var.chat_rank4);
        cfg.addDefault("Config.Chat.Rank5", Var.chat_rank5);
        cfg.addDefault("Config.Chat.Rank6", Var.chat_rank6);
        cfg.addDefault("Config.Chat.Rank7", Var.chat_rank7);
        cfg.addDefault("Config.Chat.Rank8", Var.chat_rank8);
        cfg.addDefault("Config.Chat.Rank9", Var.chat_rank9);
        cfg.addDefault("Config.Chat.Rank10", Var.chat_rank10);
        cfg.addDefault("Config.Chat.Rank11", Var.chat_rank11);
        cfg.addDefault("Config.Chat.Rank12", Var.chat_rank12);
        cfg.addDefault("Config.Chat.Rank13", Var.chat_rank13);
        cfg.addDefault("Config.Chat.Rank14", Var.chat_rank14);
        cfg.addDefault("Config.Chat.Rank15", Var.chat_rank15);
        cfg.addDefault("Config.Chat.Rank16", Var.chat_rank16);
        cfg.addDefault("Config.Chat.Rank17", Var.chat_rank17);
        cfg.addDefault("Config.Chat.Rank18", Var.chat_rank18);
        cfg.addDefault("Config.Chat.Rank19", Var.chat_rank19);
        cfg.addDefault("Config.Chat.Rank20", Var.chat_rank20);
        //TAB
        cfg.addDefault("Config.Tab.Rank1", Var.sb_rank1);
        cfg.addDefault("Config.Tab.Rank2", Var.sb_rank2);
        cfg.addDefault("Config.Tab.Rank3", Var.sb_rank3);
        cfg.addDefault("Config.Tab.Rank4", Var.sb_rank4);
        cfg.addDefault("Config.Tab.Rank5", Var.sb_rank5);
        cfg.addDefault("Config.Tab.Rank6", Var.sb_rank6);
        cfg.addDefault("Config.Tab.Rank7", Var.sb_rank7);
        cfg.addDefault("Config.Tab.Rank8", Var.sb_rank8);
        cfg.addDefault("Config.Tab.Rank9", Var.sb_rank9);
        cfg.addDefault("Config.Tab.Rank10", Var.sb_rank10);
        cfg.addDefault("Config.Tab.Rank11", Var.sb_rank11);
        cfg.addDefault("Config.Tab.Rank12", Var.sb_rank12);
        cfg.addDefault("Config.Tab.Rank13", Var.sb_rank13);
        cfg.addDefault("Config.Tab.Rank14", Var.sb_rank14);
        cfg.addDefault("Config.Tab.Rank15", Var.sb_rank15);
        cfg.addDefault("Config.Tab.Rank16", Var.sb_rank16);
        cfg.addDefault("Config.Tab.Rank17", Var.sb_rank17);
        cfg.addDefault("Config.Tab.Rank18", Var.sb_rank18);
        cfg.addDefault("Config.Tab.Rank19", Var.sb_rank19);
        cfg.addDefault("Config.Tab.Rank20", Var.sb_rank20);
        //SCOREBOARD
        cfg.addDefault("Config.Scoreboard.Displayname", Var.sb_displayname);
        //SCOREBOARD-LOBBY
        cfg.addDefault("Config.Scoreboard.Lobby.Line15.Enabled", Var.sb_line15_s);
        cfg.addDefault("Config.Scoreboard.Lobby.Line15.Text", Var.sb_line15);
        cfg.addDefault("Config.Scoreboard.Lobby.Line14.Enabled", Var.sb_line14_s);
        cfg.addDefault("Config.Scoreboard.Lobby.Line14.Text", Var.sb_line14);
        cfg.addDefault("Config.Scoreboard.Lobby.Line13.Enabled", Var.sb_line13_s);
        cfg.addDefault("Config.Scoreboard.Lobby.Line13.Text", Var.sb_line13);
        cfg.addDefault("Config.Scoreboard.Lobby.Line12.Enabled", Var.sb_line12_s);
        cfg.addDefault("Config.Scoreboard.Lobby.Line12.Text", Var.sb_line12);
        cfg.addDefault("Config.Scoreboard.Lobby.Line11.Enabled", Var.sb_line11_s);
        cfg.addDefault("Config.Scoreboard.Lobby.Line11.Text", Var.sb_line11);
        cfg.addDefault("Config.Scoreboard.Lobby.Line10.Enabled", Var.sb_line10_s);
        cfg.addDefault("Config.Scoreboard.Lobby.Line10.Text", Var.sb_line10);
        cfg.addDefault("Config.Scoreboard.Lobby.Line9.Enabled", Var.sb_line9_s);
        cfg.addDefault("Config.Scoreboard.Lobby.Line9.Text", Var.sb_line9);
        cfg.addDefault("Config.Scoreboard.Lobby.Line8.Enabled", Var.sb_line8_s);
        cfg.addDefault("Config.Scoreboard.Lobby.Line8.Text", Var.sb_line8);
        cfg.addDefault("Config.Scoreboard.Lobby.Line7.Enabled", Var.sb_line7_s);
        cfg.addDefault("Config.Scoreboard.Lobby.Line7.Text", Var.sb_line7);
        cfg.addDefault("Config.Scoreboard.Lobby.Line6.Enabled", Var.sb_line6_s);
        cfg.addDefault("Config.Scoreboard.Lobby.Line6.Text", Var.sb_line6);
        cfg.addDefault("Config.Scoreboard.Lobby.Line5.Enabled", Var.sb_line5_s);
        cfg.addDefault("Config.Scoreboard.Lobby.Line5.Text", Var.sb_line5);
        cfg.addDefault("Config.Scoreboard.Lobby.Line4.Enabled", Var.sb_line4_s);
        cfg.addDefault("Config.Scoreboard.Lobby.Line4.Text", Var.sb_line4);
        cfg.addDefault("Config.Scoreboard.Lobby.Line3.Enabled", Var.sb_line3_s);
        cfg.addDefault("Config.Scoreboard.Lobby.Line3.Text", Var.sb_line3);
        cfg.addDefault("Config.Scoreboard.Lobby.Line2.Enabled", Var.sb_line2_s);
        cfg.addDefault("Config.Scoreboard.Lobby.Line2.Text", Var.sb_line2);
        cfg.addDefault("Config.Scoreboard.Lobby.Line1.Enabled", Var.sb_line1_s);
        cfg.addDefault("Config.Scoreboard.Lobby.Line1.Text", Var.sb_line1);
        //SCOREBOARD-INGAME
        cfg.addDefault("Config.Scoreboard.Ingame.RedLeftCoreState", Var.sb_state_red_left);
        cfg.addDefault("Config.Scoreboard.Ingame.RedRightCoreState", Var.sb_state_red_right);
        cfg.addDefault("Config.Scoreboard.Ingame.BlueLeftCoreState", Var.sb_state_blue_left);
        cfg.addDefault("Config.Scoreboard.Ingame.BlueRightCoreState", Var.sb_state_blue_right);
        cfg.addDefault("Config.Scoreboard.Ingame.CurrentKills", Var.sb_current_kills);
        //MYSQL
        cfg.addDefault("Config.MySQL.Stats.Host", Var.sql_host);
        cfg.addDefault("Config.MySQL.Stats.Port", Var.sql_port);
        cfg.addDefault("Config.MySQL.Stats.User", Var.sql_user);
        cfg.addDefault("Config.MySQL.Stats.Password", Var.sql_password);
        cfg.addDefault("Config.MySQL.Stats.Database", Var.sql_database);
        cfg.addDefault("Config.MySQL.Coins.Host", Var.sqlc_host);
        cfg.addDefault("Config.MySQL.Coins.Port", Var.sqlc_port);
        cfg.addDefault("Config.MySQL.Coins.User", Var.sqlc_user);
        cfg.addDefault("Config.MySQL.Coins.Password", Var.sqlc_password);
        cfg.addDefault("Config.MySQL.Coins.Database", Var.sqlc_database);

        saveCfg();

        Var.prefix = cfg.getString("Config.Prefix");
        Var.map = cfg.getString("Config.Map");
        Var.noperm = cfg.getString("Config.NoPermission");
        Var.minplayers = cfg.getInt("Config.MinPlayers");
        Var.maxplayers = cfg.getInt("Config.MaxPlayers");
        Var.world_lobby = cfg.getString("Config.LobbyWorld");
        Var.world_game = cfg.getString("Config.GameWorld");
        Var.motd_lobby = cfg.getString("Config.MotdContain.Lobby");
        Var.motd_ingame = cfg.getString("Config.MotdContain.Ingame");
        //TEAMS
        Var.teams_joinred = cfg.getString("Config.Messages.Teams.Red.Join");
        Var.teams_joinblue = cfg.getString("Config.Messages.Teams.Blue.Join");
        Var.teams_full = cfg.getString("Config.Messages.Teams.Full");
        Var.teams_redwon = cfg.getString("Config.Messages.Teams.Red.Win");
        Var.teams_bluewon = cfg.getString("Config.Messages.Teams.Blue.Win");
        Var.teams_title_redwon = cfg.getString("Config.Messages.Teams.Red.Title");
        Var.teams_subtitle_redwon = cfg.getString("Config.Messages.Teams.Red.SubTitle");
        Var.teams_title_bluewon = cfg.getString("Config.Messages.Teams.Blue.Title");
        Var.teams_subtitle_bluewon = cfg.getString("Config.Messages.Teams.Blue.SubTitle");
        //COINS
        Var.coins_kill = cfg.getInt("Config.Coins.Kill");
        Var.coins_win = cfg.getInt("Config.Coins.Win");
        Var.coins_core = cfg.getInt("Config.Coins.Core");
        Var.coins_addedcoins = cfg.getString("Config.Coins.Messages.AddCoins");
        //MESSAGES
        Var.joinmsg = cfg.getString("Config.Messages.Join");
        Var.joinmsg_ingame = cfg.getString("Config.Messages.Ingame.Join");
        Var.quitmsg = cfg.getString("Config.Messages.Quit");
        Var.quitmsg_ingame = cfg.getString("Config.Messages.Ingame.Quit");
        Var.killmsg = cfg.getString("Config.Messages.Kill");
        Var.deathmsg = cfg.getString("Config.Messages.Death");
        Var.instantdeath = cfg.getBoolean("Config.Settings.InstantDeath");
        Var.chat_spectator = cfg.getString("Config.Messages.SpectatorChat");
        Var.ingame_allplayers_teleport = cfg.getString("Config.Messages.AllPlayersTeleport");
        Var.core_redleft_destroy = cfg.getString("Config.Messages.Core.RedLeftDestroyed");
        Var.core_redright_destroy = cfg.getString("Config.Messages.Core.RedRightDestroyed");
        Var.core_blueleft_destroy = cfg.getString("Config.Messages.Core.BlueLeftDestroyed");
        Var.core_blueright_destroy = cfg.getString("Config.Messages.Core.BlueRightDestroyed");
        Var.core_red_nearleft = cfg.getString("Config.Messages.NearRedLeftCore");
        Var.core_red_nearright = cfg.getString("Config.Messages.NearRedRightCore");
        Var.core_blue_nearleft = cfg.getString("Config.Messages.NearBlueLeftCore");
        Var.core_blue_nearright = cfg.getString("Config.Messages.NearBlueRightCore");
        Var.core_build_distance = cfg.getInt("Config.BuildDistance.Core");
        Var.spawn_build_distance = cfg.getInt("Config.BuildDistance.Spawn");
        //COMMAND STATS
        Var.stats_line1 = cfg.getString("Config.Commands.Stats.Messages.Line1");
        Var.stats_line2 = cfg.getString("Config.Commands.Stats.Messages.Line2");
        Var.stats_line3 = cfg.getString("Config.Commands.Stats.Messages.Line3");
        Var.stats_line4 = cfg.getString("Config.Commands.Stats.Messages.Line4");
        Var.stats_line5 = cfg.getString("Config.Commands.Stats.Messages.Line5");
        Var.stats_noround_own = cfg.getString("Config.Commands.Stats.Messages.NoRoundPlayed.Own");
        Var.stats_noround_other = cfg.getString("Config.Commands.Stats.Messages.NoRoundPlayed.Other");
        Var.stats_usage = cfg.getString("Config.Commands.Stats.Messages.StatsUsage");
        //COMMAND START
        Var.start_successfully = cfg.getString("Config.Commands.Start.Messages.StartSuccessfully");
        Var.start_already = cfg.getString("Config.Commands.Start.Messages.StartAlready");
        Var.start_missing = cfg.getString("Config.Commands.Start.Messages.StartMissing");
        Var.start_usage = cfg.getString("Config.Commands.Start.Messages.StartUsage");
        Var.start_seconds = cfg.getInt("Config.Commands.Start.Settings.StartAtSecond");
        //COMMAND SETSPAWN
        Var.setspawn_lobbyset = cfg.getString("Config.Commands.SetSpawn.Messages.WarpLobby");
        Var.setspawn_specset = cfg.getString("Config.Commands.SetSpawn.Messages.WarpSpectator");
        Var.setspawn_spawn1red = cfg.getString("Config.Commands.SetSpawn.Messages.Spawn-1-Red");
        Var.setspawn_spawn2blue = cfg.getString("Config.Commands.SetSpawn.Messages.Spawn-2-Blue");
        Var.setspawn_spawnsetusage = cfg.getString("Config.Commands.SetSpawn.Messages.SpawnSetUsage");
        Var.setspawn_spawnset = cfg.getString("Config.Commands.SetSpawn.Messages.WarpSpawn");
        Var.setspawn_coreredleft = cfg.getString("Config.Commands.SetSpawn.Messages.Core-Red-Left");
        Var.setspawn_coreredright = cfg.getString("Config.Commands.SetSpawn.Messages.Core-Red-Right");
        Var.setspawn_coreblueleft = cfg.getString("Config.Commands.SetSpawn.Messages.Core-Blue-Left");
        Var.setspawn_coreblueright = cfg.getString("Config.Commands.SetSpawn.Messages.Core-Blue-Right");
        Var.setspawn_usage = cfg.getString("Config.Commands.SetSpawn.Messages.SetSpawnUsage");
        //COUNTDOWN LOBBY
        Var.lobbycd_seconds = cfg.getInt("Config.Countdowns.Lobby.Seconds");
        Var.lobbycd_startin_seconds = cfg.getString("Config.Countdowns.Lobby.StartInSeconds");
        Var.lobbycd_startin_second = cfg.getString("Config.Countdowns.Lobby.StartInSecond");
        Var.lobbycd_missingplayers = cfg.getString("Config.Countdowns.Lobby.MissingPlayers");
        //COUNTDOWN SPAWN
        Var.spawncd_seconds = cfg.getInt("Config.Countdowns.Spawn.Seconds");
        Var.spawncd_startin_seconds = cfg.getString("Config.Countdowns.Spawn.StartInSeconds");
        Var.spawncd_startin_second = cfg.getString("Config.Countdowns.Spawn.StartInSecond");
        //COUNTDOWN GRACE
        Var.gracecd_seconds = cfg.getInt("Config.Countdowns.Grace.Seconds");
        Var.gracecd_startin_seconds = cfg.getString("Config.Grace.Spawn.StartInSeconds");
        Var.gracecd_startin_second = cfg.getString("Config.Countdowns.Grace.StartInSecond");
        Var.gracecd_readytofight = cfg.getString("Config.Countdowns.Grace.ReadyToFight");
        //COUNTDOWN GRACE
        Var.gracecd_seconds = cfg.getInt("Config.Countdowns.Grace.Seconds");
        Var.gracecd_startin_seconds = cfg.getString("Config.Countdowns.Grace.StartInSeconds");
        Var.gracecd_startin_second = cfg.getString("Config.Countdowns.Grace.StartInSecond");
        Var.gracecd_readytofight = cfg.getString("Config.Countdowns.Grace.ReadyToFight");
        //COUNTDOWN END
        Var.endcd_seconds = cfg.getInt("Config.Countdowns.End.Seconds");
        Var.endcd_startin_seconds = cfg.getString("Config.Countdowns.End.StartInSeconds");
        Var.endcd_startin_second = cfg.getString("Config.Countdowns.End.StartInSecond");
        //CHAT
        Var.chat_rank1 = cfg.getString("Config.Chat.Rank1");
        Var.chat_rank2 = cfg.getString("Config.Chat.Rank2");
        Var.chat_rank3 = cfg.getString("Config.Chat.Rank3");
        Var.chat_rank4 = cfg.getString("Config.Chat.Rank4");
        Var.chat_rank5 = cfg.getString("Config.Chat.Rank5");
        Var.chat_rank6 = cfg.getString("Config.Chat.Rank6");
        Var.chat_rank7 = cfg.getString("Config.Chat.Rank7");
        Var.chat_rank8 = cfg.getString("Config.Chat.Rank8");
        Var.chat_rank9 = cfg.getString("Config.Chat.Rank9");
        Var.chat_rank10 = cfg.getString("Config.Chat.Rank10");
        Var.chat_rank11 = cfg.getString("Config.Chat.Rank11");
        Var.chat_rank12 = cfg.getString("Config.Chat.Rank12");
        Var.chat_rank13 = cfg.getString("Config.Chat.Rank13");
        Var.chat_rank14 = cfg.getString("Config.Chat.Rank14");
        Var.chat_rank15 = cfg.getString("Config.Chat.Rank15");
        Var.chat_rank16 = cfg.getString("Config.Chat.Rank16");
        Var.chat_rank17 = cfg.getString("Config.Chat.Rank17");
        Var.chat_rank18 = cfg.getString("Config.Chat.Rank18");
        Var.chat_rank19 = cfg.getString("Config.Chat.Rank19");
        Var.chat_rank20 = cfg.getString("Config.Chat.Rank20");
        //CHAT
        Var.sb_rank1 = cfg.getString("Config.Tab.Rank1");
        Var.sb_rank2 = cfg.getString("Config.Tab.Rank2");
        Var.sb_rank3 = cfg.getString("Config.Tab.Rank3");
        Var.sb_rank4 = cfg.getString("Config.Tab.Rank4");
        Var.sb_rank5 = cfg.getString("Config.Tab.Rank5");
        Var.sb_rank6 = cfg.getString("Config.Tab.Rank6");
        Var.sb_rank7 = cfg.getString("Config.Tab.Rank7");
        Var.sb_rank8 = cfg.getString("Config.Tab.Rank8");
        Var.sb_rank9 = cfg.getString("Config.Tab.Rank9");
        Var.sb_rank10 = cfg.getString("Config.Tab.Rank10");
        Var.sb_rank11 = cfg.getString("Config.Tab.Rank11");
        Var.sb_rank12 = cfg.getString("Config.Tab.Rank12");
        Var.sb_rank13 = cfg.getString("Config.Tab.Rank13");
        Var.sb_rank14 = cfg.getString("Config.Tab.Rank14");
        Var.sb_rank15 = cfg.getString("Config.Tab.Rank15");
        Var.sb_rank16 = cfg.getString("Config.Tab.Rank16");
        Var.sb_rank17 = cfg.getString("Config.Tab.Rank17");
        Var.sb_rank18 = cfg.getString("Config.Tab.Rank18");
        Var.sb_rank19 = cfg.getString("Config.Tab.Rank19");
        Var.sb_rank20 = cfg.getString("Config.Tab.Rank20");
        //SCOREBOARD
        Var.sb_displayname = cfg.getString("Config.Scoreboard.Displayname");
        //SCOREBOARD-LOBBY
        Var.sb_line15_s = cfg.getBoolean("Config.Scoreboard.Lobby.Line15.Enabled");
        Var.sb_line15 = cfg.getString("Config.Scoreboard.Lobby.Line15.Text");
        Var.sb_line14_s = cfg.getBoolean("Config.Scoreboard.Lobby.Line14.Enabled");
        Var.sb_line14 = cfg.getString("Config.Scoreboard.Lobby.Line14.Text");
        Var.sb_line13_s = cfg.getBoolean("Config.Scoreboard.Lobby.Line13.Enabled");
        Var.sb_line13 = cfg.getString("Config.Scoreboard.Lobby.Line13.Text");
        Var.sb_line12_s = cfg.getBoolean("Config.Scoreboard.Lobby.Line12.Enabled");
        Var.sb_line12 = cfg.getString("Config.Scoreboard.Lobby.Line12.Text");
        Var.sb_line11_s = cfg.getBoolean("Config.Scoreboard.Lobby.Line11.Enabled");
        Var.sb_line11 = cfg.getString("Config.Scoreboard.Lobby.Line11.Text");
        Var.sb_line10_s = cfg.getBoolean("Config.Scoreboard.Lobby.Line10.Enabled");
        Var.sb_line10 = cfg.getString("Config.Scoreboard.Lobby.Line10.Text");
        Var.sb_line9_s = cfg.getBoolean("Config.Scoreboard.Lobby.Line9.Enabled");
        Var.sb_line9 = cfg.getString("Config.Scoreboard.Lobby.Line9.Text");
        Var.sb_line8_s = cfg.getBoolean("Config.Scoreboard.Lobby.Line8.Enabled");
        Var.sb_line8 = cfg.getString("Config.Scoreboard.Lobby.Line8.Text");
        Var.sb_line7_s = cfg.getBoolean("Config.Scoreboard.Lobby.Line7.Enabled");
        Var.sb_line7 = cfg.getString("Config.Scoreboard.Lobby.Line7.Text");
        Var.sb_line6_s = cfg.getBoolean("Config.Scoreboard.Lobby.Line6.Enabled");
        Var.sb_line6 = cfg.getString("Config.Scoreboard.Lobby.Line6.Text");
        Var.sb_line5_s = cfg.getBoolean("Config.Scoreboard.Lobby.Line5.Enabled");
        Var.sb_line5 = cfg.getString("Config.Scoreboard.Lobby.Line5.Text");
        Var.sb_line4_s = cfg.getBoolean("Config.Scoreboard.Lobby.Line4.Enabled");
        Var.sb_line4 = cfg.getString("Config.Scoreboard.Lobby.Line4.Text");
        Var.sb_line3_s = cfg.getBoolean("Config.Scoreboard.Lobby.Line3.Enabled");
        Var.sb_line3 = cfg.getString("Config.Scoreboard.Lobby.Line3.Text");
        Var.sb_line2_s = cfg.getBoolean("Config.Scoreboard.Lobby.Line2.Enabled");
        Var.sb_line2 = cfg.getString("Config.Scoreboard.Lobby.Line2.Text");
        Var.sb_line1_s = cfg.getBoolean("Config.Scoreboard.Lobby.Line1.Enabled");
        Var.sb_line1 = cfg.getString("Config.Scoreboard.Lobby.Line1.Text");
        //SCOREBOARD-LOBBY
        Var.sb_state_red_left = cfg.getString("Config.Scoreboard.Ingame.RedLeftCoreState");
        Var.sb_state_red_right = cfg.getString("Config.Scoreboard.Ingame.RedRightCoreState");
        Var.sb_state_blue_left = cfg.getString("Config.Scoreboard.Ingame.BlueLeftCoreState");
        Var.sb_state_blue_right = cfg.getString("Config.Scoreboard.Ingame.BlueRightCoreState");
        Var.sb_current_kills = cfg.getString("Config.Scoreboard.Ingame.CurrentKills");
        //MYSQL
        Var.sql_host = cfg.getString("Config.MySQL.Stats.Host");
        Var.sql_port = cfg.getInt("Config.MySQL.Stats.Port");
        Var.sql_user = cfg.getString("Config.MySQL.Stats.User");
        Var.sql_password = cfg.getString("Config.MySQL.Stats.Password");
        Var.sql_database = cfg.getString("Config.MySQL.Stats.Database");
        Var.sqlc_host = cfg.getString("Config.MySQL.Coins.Host");
        Var.sqlc_port = cfg.getInt("Config.MySQL.Coins.Port");
        Var.sqlc_user = cfg.getString("Config.MySQL.Coins.User");
        Var.sqlc_password = cfg.getString("Config.MySQL.Coins.Password");
        Var.sqlc_database = cfg.getString("Config.MySQL.Coins.Database");

    }

    public void saveCfg() {
        try {
            cfg.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
