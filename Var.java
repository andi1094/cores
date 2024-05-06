package net.minecresthd.cores;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Var {

    public static String prefix = "&7[&bCores&7] ";
    public static String map = "YourMapName";
    public static String noperm = "&cYou dont have the permission to do that!";
    public static int minplayers = 2;
    public static int maxplayers = 10;
    public static String world_lobby = "LobbyWorld";
    public static String world_game = "GameWorld";
    public static String motd_lobby = "LOBBY";
    public static String motd_ingame = "INGAME";

    public static String joinmsg = "&7The player %player% joined the round [%current%/%maxplayers%]";
    public static String quitmsg = "&7The player %player% left the round [%current%/%maxplayers%]";
    public static String joinmsg_ingame = "&7The round is already ingame, you are now spectator!";
    public static String quitmsg_ingame = "&7The player %player% left the game!";
    public static String killmsg = "&7The player %player% was killed by %killer%";
    public static String deathmsg = "&7The player %player% died";
    public static boolean instantdeath = false;
    public static String chat_spectator = "&cThe chat is disabled for Spectators";
    public static String ingame_allplayers_teleport = "&7All players will be teleported now!";
    public static String core_redleft_destroy = "&cThe LeftCore of Team Red was destroyed!";
    public static String core_redright_destroy = "&cThe RightCore of Team Red was destroyed!";
    public static String core_blueleft_destroy = "&cThe LeftCore of Team Blue was destroyed!";
    public static String core_blueright_destroy = "&cThe RightCore of Team Blue was destroyed!";
    public static String core_red_nearleft = "&4There is a opponent near your &eLeftCores &4!";
    public static String core_red_nearright = "&4There is a opponent near your &eRightCores &4!";
    public static String core_blue_nearleft = "&4There is a opponent near your &eLeftCores &4!";
    public static String core_blue_nearright = "&4There is a opponent near your &eRightCores &4!";
    public static int core_build_distance = 4;
    public static int spawn_build_distance = 4;

    //TEAM
    public static String teams_joinred = "&7You joined Team Red!";
    public static String teams_joinblue = "&7You joined Team Blue!";
    public static String teams_full = "&cThe team is full!";
    public static String teams_redwon = "&7Team Red successfully won the game!";
    public static String teams_bluewon = "&7Team Blue successfully won the game!";
    public static String teams_title_redwon = "&7Team &4Team";
    public static String teams_subtitle_redwon = "&7won the game!";
    public static String teams_title_bluewon = "&7Team &4Team";
    public static String teams_subtitle_bluewon = "&7won the game!";

    //COINS
    public static int coins_kill = 5;
    public static int coins_win = 20;
    public static int coins_core = 10;
    public static String coins_addedcoins = "&eYou received %coins% Coins!";

    //COMMAND STATS
    public static String stats_line1 = "&cCores Stats %player%";
    public static String stats_line2 = "&cKills: %kills% | Deaths: %deaths%";
    public static String stats_line3 = "&cK/D: %kd%";
    public static String stats_line4 = "&cPlayed games: %pgames%";
    public static String stats_line5 = "&cWon games: %wgames%";
    public static String stats_noround_own = "&cYou haven't played a round";
    public static String stats_noround_other = "&c%player% hasn't played a round";
    public static String stats_usage = "&cPlease use /cores stats (<player>)!";

    //COMMAND START
    public static String start_successfully = "&eYou started the game successfully!";
    public static String start_already = "&cThe game already started!";
    public static String start_missing = "&cThere are missing players!";
    public static String start_usage = "&cPlease use /cores start!";
    public static int start_seconds = 5;

    //COMMAND SETSPAWN
    public static String setspawn_lobbyset = "&eThe Lobby was successfully set!";
    public static String setspawn_specset = "&eThe Spectator was successfully set!";
    public static String setspawn_spawn1red = "&eThe Spawn for Red was successfully set!";
    public static String setspawn_spawn2blue = "&eThe Spawn for Blue was successfully set!";
    public static String setspawn_spawnsetusage = "&cPlease use /cores setspawn spawn <red|blue>";
    public static String setspawn_spawnset = "&eYou successfully set the %spawn% spawn!";
    public static String setspawn_coreredleft = "&eYou successfully set the Red Left Core!";
    public static String setspawn_coreredright = "&eYou successfully set the Red Right Core!";
    public static String setspawn_coreblueleft = "&eYou successfully set the Blue Left Core!";
    public static String setspawn_coreblueright = "&eYou successfully set the Blue Right Core!";
    public static String setspawn_usage = "&cPlease use /cores setspawn <Lobby|Spectator|Spawn|Core> <red|blue> <left|right>";

    //COUNTDOWN LOBBY
    public static int lobbycd_seconds = 60;
    public static String lobbycd_startin_seconds = "&eThe game starts in &a%seconds% &eseconds!";
    public static String lobbycd_startin_second = "&eThe game starts in &a%seconds% &esecond! <- ONE SECOND";
    public static String lobbycd_missingplayers = "&eThere are §a%players% §eplayers missing!";

    //COUNTDOWN SPAWN
    public static int spawncd_seconds = 3;
    public static String spawncd_startin_seconds = "&eThe protection time starts in &a%seconds% &eseconds!";
    public static String spawncd_startin_second = "&eThe protection time starts in &a%seconds% &esecond! <- ONE SECOND";

    //COUNTDOWN GRACE
    public static int gracecd_seconds = 3;
    public static String gracecd_startin_seconds = "&eThe protection time ends in &a%seconds% &eseconds!";
    public static String gracecd_startin_second = "&eThe protection time ends in &a%seconds% &esecond! <- ONE SECOND";
    public static String gracecd_readytofight = "&eThe protection time has ended. Teams can now attack each other!";

    //COUNTDOWN END
    public static int endcd_seconds = 10;
    public static String endcd_startin_seconds = "&eThe server restarts in %seconds% seconds!";
    public static String endcd_startin_second = "&eThe server restarts in %seconds% second! <- ONE SECOND";

    //CHAT
    public static String chat_rank1 = "&eRank1 &7| &e%player%&7: %message%";
    public static String chat_rank2 = "&eRank2 &7| &e%player%&7: %message%";
    public static String chat_rank3 = "&eRank3 &7| &e%player%&7: %message%";
    public static String chat_rank4 = "&eRank4 &7| &e%player%&7: %message%";
    public static String chat_rank5 = "&eRank5 &7| &e%player%&7: %message%";
    public static String chat_rank6 = "&eRank6 &7| &e%player%&7: %message%";
    public static String chat_rank7 = "&eRank7 &7| &e%player%&7: %message%";
    public static String chat_rank8 = "&eRank8 &7| &e%player%&7: %message%";
    public static String chat_rank9 = "&eRank9 &7| &e%player%&7: %message%";
    public static String chat_rank10 = "&eRank10 &7| &e%player%&7: %message%";
    public static String chat_rank11 = "&eRank11 &7| &e%player%&7: %message%";
    public static String chat_rank12 = "&eRank12 &7| &e%player%&7: %message%";
    public static String chat_rank13 = "&eRank13 &7| &e%player%&7: %message%";
    public static String chat_rank14 = "&eRank14 &7| &e%player%&7: %message%";
    public static String chat_rank15 = "&eRank15 &7| &e%player%&7: %message%";
    public static String chat_rank16 = "&eRank16 &7| &e%player%&7: %message%";
    public static String chat_rank17 = "&eRank17 &7| &e%player%&7: %message%";
    public static String chat_rank18 = "&eRank18 &7| &e%player%&7: %message%";
    public static String chat_rank19 = "&eRank19 &7| &e%player%&7: %message%";
    public static String chat_rank20 = "&eRank20 &7| &e%player%&7: %message%";

    //TAB
    public static String sb_rank1 = "&eRank1 &7| ";
    public static String sb_rank2 = "&eRank2 &7| ";
    public static String sb_rank3 = "&eRank3 &7| ";
    public static String sb_rank4 = "&eRank4 &7| ";
    public static String sb_rank5 = "&eRank5 &7| ";
    public static String sb_rank6 = "&eRank6 &7| ";
    public static String sb_rank7 = "&eRank7 &7| ";
    public static String sb_rank8 = "&eRank8 &7| ";
    public static String sb_rank9 = "&eRank9 &7| ";
    public static String sb_rank10 = "&eRank10 &7| ";
    public static String sb_rank11 = "&eRank11 &7| ";
    public static String sb_rank12 = "&eRank12 &7| ";
    public static String sb_rank13 = "&eRank13 &7| ";
    public static String sb_rank14 = "&eRank14 &7| ";
    public static String sb_rank15 = "&eRank15 &7| ";
    public static String sb_rank16 = "&eRank16 &7| ";
    public static String sb_rank17 = "&eRank17 &7| ";
    public static String sb_rank18 = "&eRank18 &7| ";
    public static String sb_rank19 = "&eRank19 &7| ";
    public static String sb_rank20 = "&eRank20 &7| ";

    //SCOREBOARD
    public static String sb_displayname = "&7- &eYourServer.net &7-";

    //SCOREBOARD-LOBBY
    public static boolean sb_line15_s = true;
    public static String sb_line15 = "&cYourServer.com";
    public static boolean sb_line14_s = true;
    public static String sb_line14 = "&eMap: %map%";
    public static boolean sb_line13_s = true;
    public static String sb_line13 = "&b";
    public static boolean sb_line12_s = true;
    public static String sb_line12 = "&cTeamspeak:";
    public static boolean sb_line11_s = true;
    public static String sb_line11 = "&a>> YourTS.com";
    public static boolean sb_line10_s = true;
    public static String sb_line10 = "&c";
    public static boolean sb_line9_s = true;
    public static String sb_line9 = "&aShop:";
    public static boolean sb_line8_s = true;
    public static String sb_line8 = "&a>> YourShop.com";
    public static boolean sb_line7_s = true;
    public static String sb_line7 = "&d";
    public static boolean sb_line6_s = true;
    public static String sb_line6 = "&aExtra Line";
    public static boolean sb_line5_s = true;
    public static String sb_line5 = "&cExtraLine";
    public static boolean sb_line4_s = true;
    public static String sb_line4 = "&eExtraLine";
    public static boolean sb_line3_s = true;
    public static String sb_line3 = "&0Extra Line";
    public static boolean sb_line2_s = true;
    public static String sb_line2 = "&4Extra Line";
    public static boolean sb_line1_s = true;
    public static String sb_line1 = "&f";

    //SCOREBOARD-INGAME
    public static String sb_team_red_size = "&7Team &4Red  &8[%s%]";
    public static String sb_team_blue_size = "&7Team &9Blue  &8[%s%]";

    public static String sb_state_red_left = "%state% &7Leftcore";
    public static String sb_state_red_right = "%state% &7Rightcore";
    public static String sb_state_blue_left = "%state% &7Leftcore";
    public static String sb_state_blue_right = "%state% &7Rightcore";
    public static String sb_current_kills = "&7Kills: &e%kills%";

    //MYSQL
    public static String sql_host = "localhost";
    public static int sql_port = 3306;
    public static String sql_user = "root";
    public static String sql_password = "password";
    public static String sql_database = "database";
    public static String sqlc_host = "localhost";
    public static int sqlc_port = 3306;
    public static String sqlc_user = "root";
    public static String sqlc_password = "password";
    public static String sqlc_database = "database";

    public static boolean canMove = true,
                          canAttack = false,
                          canBuild = false,
                          isWon = false;

    public static boolean red_left = true;
    public static boolean red_right = true;
    public static boolean blue_left = true;
    public static boolean blue_right = true;

    public static File locsFile = new File("plugins/Cores/locs.yml");
    public static YamlConfiguration locs = YamlConfiguration.loadConfiguration(locsFile);

    public static ArrayList<Player> playing = new ArrayList<>();
    public static ArrayList<Player> team_red = new ArrayList<>();
    public static ArrayList<Player> team_blue = new ArrayList<>();
    public static ArrayList<Player> spectating = new ArrayList<>();

    public static HashMap<Player, Integer> currentkills = new HashMap<>();

    public static ItemStack createItem(int id, int subid, String displayname, String lore, int amount, Enchantment enchantment, int enchantment_id) {
        ItemStack item = new ItemStack(id, amount, (short) subid);
        ItemMeta itemmeta = item.getItemMeta();
        ArrayList<String> lorelist = new ArrayList();
        lorelist.add(lore);
        itemmeta.setDisplayName(displayname);
        itemmeta.setLore(lorelist);
        if(enchantment != null) {
            itemmeta.addEnchant(enchantment, enchantment_id, true);
        }
        item.setItemMeta(itemmeta);
        return item;
    }

}
