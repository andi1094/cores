package net.minecresthd.cores.listeners;

import net.minecresthd.cores.Var;
import net.minecresthd.cores.managers.GameStateHandler;
import net.minecresthd.cores.managers.IngameState;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class onScoreboardEvent {

    public static void setScoreboard(Player p) {
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = board.registerNewObjective("Lobby", "Scoreboard");

        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(Var.sb_displayname.replace("&", "§"));

        if(GameStateHandler.getGameState() instanceof IngameState) {
            Team line9 = board.registerNewTeam("line9");
            line9.addEntry("§9");
            String sb_team_red_size_1 = Var.sb_team_red_size.replace("%s%", Integer.toString(Var.team_red.size())).replace("&", "§").substring(0,12);
            line9.setPrefix(sb_team_red_size_1);
            String sb_team_red_size_2 = Var.sb_team_red_size.replace("%s%", Integer.toString(Var.team_red.size())).replace("&", "§").substring(13);
            line9.setSuffix(sb_team_red_size_2);

            Team line8 = board.registerNewTeam("line8");
            line8.addEntry("§8");
            if(Var.red_left) {
                line8.setPrefix(Var.sb_state_red_left.replace("%state%", "§a✔").replace("&", "§"));
            } else {
                line8.setPrefix(Var.sb_state_red_left.replace("%state%", "§c✘").replace("&", "§"));
            }

            Team line7 = board.registerNewTeam("line7");
            line7.addEntry("§7");
            if(Var.red_right) {
                line7.setPrefix(Var.sb_state_red_right.replace("%state%", "§a✔").replace("&", "§"));
            } else {
                line7.setPrefix(Var.sb_state_red_right.replace("%state%", "§c✘").replace("&", "§"));
            }

            Team line5 = board.registerNewTeam("line5");
            line5.addEntry("§5");
            String sb_team_blue_size_1 = Var.sb_team_blue_size.replace("%s%", Integer.toString(Var.team_blue.size())).replace("&", "§").substring(0,13);
            line5.setPrefix(sb_team_blue_size_1);
            String sb_team_blue_size_2 = Var.sb_team_blue_size.replace("%s%", Integer.toString(Var.team_blue.size())).replace("&", "§").substring(14);
            line5.setSuffix(sb_team_blue_size_2);

            Team line4 = board.registerNewTeam("line4");
            line4.addEntry("§4");
            if(Var.blue_left) {
                line4.setPrefix(Var.sb_state_blue_left.replace("%state%", "§a✔").replace("&", "§"));
            } else {
                line4.setPrefix(Var.sb_state_blue_left.replace("%state%", "§c✘").replace("&", "§"));
            }

            Team line3 = board.registerNewTeam("line3");
            line3.addEntry("§3");
            if(Var.blue_right) {
                line3.setPrefix(Var.sb_state_blue_right.replace("%state%", "§a✔").replace("&", "§"));
            } else {
                line3.setPrefix(Var.sb_state_blue_right.replace("%state%", "§c✘").replace("&", "§"));
            }

            Team line1 = board.registerNewTeam("line1");
            line1.addEntry("§1");
            line1.setPrefix(Var.sb_current_kills.replace("%kills%", Integer.toString(Var.currentkills.get(p))).replace("&", "§"));

            obj.getScore("§a").setScore(10);
            obj.getScore("§9").setScore(9);
            obj.getScore("§8").setScore(8);
            obj.getScore("§7").setScore(7);
            obj.getScore("§6").setScore(6);
            obj.getScore("§5").setScore(5);
            obj.getScore("§4").setScore(4);
            obj.getScore("§3").setScore(3);
            obj.getScore("§2").setScore(2);
            obj.getScore("§1").setScore(1);
            obj.getScore("§0").setScore(0);
        } else {
            if(Var.sb_line15_s) {
                String sb_line15 = Var.sb_line15.replace("%map%", Var.map).replace("&", "§");
                obj.getScore(sb_line15).setScore(15);
            }
            if(Var.sb_line14_s) {
                String sb_line14 = Var.sb_line14.replace("%map%", Var.map).replace("&", "§");
                obj.getScore(sb_line14).setScore(14);
            }
            if(Var.sb_line13_s) {
                String sb_line13 = Var.sb_line13.replace("%map%", Var.map).replace("&", "§");
                obj.getScore(sb_line13).setScore(13);
            }
            if(Var.sb_line12_s) {
                String sb_line12 = Var.sb_line12.replace("%map%", Var.map).replace("&", "§");
                obj.getScore(sb_line12).setScore(12);
            }
            if(Var.sb_line11_s) {
                String sb_line11 = Var.sb_line11.replace("%map%", Var.map).replace("&", "§");
                obj.getScore(sb_line11).setScore(11);
            }
            if(Var.sb_line10_s) {
                String sb_line10 = Var.sb_line10.replace("%map%", Var.map).replace("&", "§");
                obj.getScore(sb_line10).setScore(10);
            }
            if(Var.sb_line9_s) {
                String sb_line9 = Var.sb_line9.replace("%map%", Var.map).replace("&", "§");
                obj.getScore(sb_line9).setScore(9);
            }
            if(Var.sb_line8_s) {
                String sb_line8 = Var.sb_line8.replace("%map%", Var.map).replace("&", "§");
                obj.getScore(sb_line8).setScore(8);
            }
            if(Var.sb_line7_s) {
                String sb_line7 = Var.sb_line7.replace("%map%", Var.map).replace("&", "§");
                obj.getScore(sb_line7).setScore(7);
            }
            if(Var.sb_line6_s) {
                String sb_line6 = Var.sb_line6.replace("%map%", Var.map).replace("&", "§");
                obj.getScore(sb_line6).setScore(6);
            }
            if(Var.sb_line5_s) {
                String sb_line5 = Var.sb_line5.replace("%map%", Var.map).replace("&", "§");
                obj.getScore(sb_line5).setScore(5);
            }
            if(Var.sb_line4_s) {
                String sb_line4 = Var.sb_line4.replace("%map%", Var.map).replace("&", "§");
                obj.getScore(sb_line4).setScore(4);
            }
            if(Var.sb_line3_s) {
                String sb_line3 = Var.sb_line3.replace("%map%", Var.map).replace("&", "§");
                obj.getScore(sb_line3).setScore(3);
            }
            if(Var.sb_line2_s) {
                String sb_line2 = Var.sb_line2.replace("%map%", Var.map).replace("&", "§");
                obj.getScore(sb_line2).setScore(2);
            }
            if(Var.sb_line1_s) {
                String sb_line1 = Var.sb_line1.replace("%map%", Var.map).replace("&", "§");
                obj.getScore(sb_line1).setScore(1);
            }

        }

        p.setScoreboard(board);
    }

    public static void updateScoreboard(Player p) {
        if(p.getScoreboard() == null) {
            setScoreboard(p);
        }

        Scoreboard board = p.getScoreboard();

        Team line9 = board.getTeam("line9");
        String sb_team_red_size_1 = Var.sb_team_red_size.replace("%s%", Integer.toString(Var.team_red.size())).replace("&", "§").substring(0,12);
        line9.setPrefix(sb_team_red_size_1);
        String sb_team_red_size_2 = Var.sb_team_red_size.replace("%s%", Integer.toString(Var.team_red.size())).replace("&", "§").substring(13);
        line9.setSuffix(sb_team_red_size_2);

        Team line8 = board.getTeam("line8");
        if(Var.red_left) {
            line8.setPrefix(Var.sb_state_red_left.replace("%state%", "§a✔").replace("&", "§"));
        } else {
            line8.setPrefix(Var.sb_state_red_left.replace("%state%", "§c✘").replace("&", "§"));
        }

        Team line7 = board.getTeam("line7");
        if(Var.red_right) {
            line7.setPrefix(Var.sb_state_red_right.replace("%state%", "§a✔").replace("&", "§"));
        } else {
            line7.setPrefix(Var.sb_state_red_right.replace("%state%", "§c✘").replace("&", "§"));
        }

        Team line5 = board.getTeam("line5");
        String sb_team_blue_size_1 = Var.sb_team_blue_size.replace("%s%", Integer.toString(Var.team_blue.size())).replace("&", "§").substring(0,13);
        line5.setPrefix(sb_team_blue_size_1);
        String sb_team_blue_size_2 = Var.sb_team_blue_size.replace("%s%", Integer.toString(Var.team_blue.size())).replace("&", "§").substring(14);
        line5.setSuffix(sb_team_blue_size_2);

        Team line4 = board.getTeam("line4");
        if(Var.blue_left) {
            line4.setPrefix(Var.sb_state_blue_left.replace("%state%", "§a✔").replace("&", "§"));
        } else {
            line4.setPrefix(Var.sb_state_blue_left.replace("%state%", "§c✘").replace("&", "§"));
        }

        Team line3 = board.getTeam("line3");
        if(Var.blue_right) {
            line3.setPrefix(Var.sb_state_blue_right.replace("%state%", "§a✔").replace("&", "§"));
        } else {
            line3.setPrefix(Var.sb_state_blue_right.replace("%state%", "§c✘").replace("&", "§"));
        }

        Team line1 = board.getTeam("line1");
        line1.setPrefix(Var.sb_current_kills.replace("%kills%", Integer.toString(Var.currentkills.get(p))).replace("&", "§"));
    }

    public static void setTab(Player p) {
        if (p.getScoreboard() == null) {
            setScoreboard(p);
        }

        Scoreboard board = p.getScoreboard();

        Team A = board.registerNewTeam("A");
        Team B = board.registerNewTeam("B");
        Team C = board.registerNewTeam("C");
        Team D = board.registerNewTeam("D");
        Team E = board.registerNewTeam("E");
        Team F = board.registerNewTeam("F");
        Team G = board.registerNewTeam("G");
        Team H = board.registerNewTeam("H");
        Team I = board.registerNewTeam("I");
        Team J = board.registerNewTeam("J");
        Team K = board.registerNewTeam("K");
        Team L = board.registerNewTeam("L");
        Team M = board.registerNewTeam("M");
        Team N = board.registerNewTeam("N");
        Team O = board.registerNewTeam("O");
        Team P = board.registerNewTeam("P");
        Team Q = board.registerNewTeam("Q");
        Team R = board.registerNewTeam("R");
        Team S = board.registerNewTeam("S");
        Team T = board.registerNewTeam("T");
        Team U = board.registerNewTeam("U");
        Team V = board.registerNewTeam("V");

        A.setPrefix("§4");
        A.setAllowFriendlyFire(false);
        B.setPrefix("§9");
        B.setAllowFriendlyFire(false);
        C.setPrefix(Var.sb_rank1.replace("&", "§"));
        D.setPrefix(Var.sb_rank2.replace("&", "§"));
        E.setPrefix(Var.sb_rank3.replace("&", "§"));
        F.setPrefix(Var.sb_rank4.replace("&", "§"));
        G.setPrefix(Var.sb_rank5.replace("&", "§"));
        H.setPrefix(Var.sb_rank6.replace("&", "§"));
        I.setPrefix(Var.sb_rank7.replace("&", "§"));
        J.setPrefix(Var.sb_rank8.replace("&", "§"));
        K.setPrefix(Var.sb_rank9.replace("&", "§"));
        L.setPrefix(Var.sb_rank10.replace("&", "§"));
        M.setPrefix(Var.sb_rank11.replace("&", "§"));
        N.setPrefix(Var.sb_rank12.replace("&", "§"));
        O.setPrefix(Var.sb_rank13.replace("&", "§"));
        P.setPrefix(Var.sb_rank14.replace("&", "§"));
        Q.setPrefix(Var.sb_rank15.replace("&", "§"));
        R.setPrefix(Var.sb_rank16.replace("&", "§"));
        S.setPrefix(Var.sb_rank17.replace("&", "§"));
        T.setPrefix(Var.sb_rank18.replace("&", "§"));
        U.setPrefix(Var.sb_rank19.replace("&", "§"));
        V.setPrefix(Var.sb_rank20.replace("&", "§"));

        for (Player all : Bukkit.getOnlinePlayers()) {
            if (Var.team_red.contains(all)) {
                A.addEntry(all.getName());
                all.setDisplayName("§4" + all.getName());
            } else if (Var.team_blue.contains(all)) {
                B.addEntry(all.getName());
                all.setDisplayName("§9" + all.getName());
            } else if (all.hasPermission("rank.1")) {
                C.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank1.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.2")) {
                D.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank2.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.3")) {
                E.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank3.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.4")) {
                F.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank4.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.5")) {
                G.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank5.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.6")) {
                H.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank6.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.7")) {
                I.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank7.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.8")) {
                J.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank8.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.9")) {
                K.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank9.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.10")) {
                L.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank10.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.11")) {
                M.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank11.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.12")) {
                N.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank12.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.13")) {
                O.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank13.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.14")) {
                P.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank14.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.15")) {
                Q.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank15.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.16")) {
                R.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank16.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.17")) {
                S.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank17.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.18")) {
                T.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank18.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.19")) {
                U.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank19.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.20")) {
                V.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank20.replace("&", "§") + all.getName());
            }
        }
    }

    public static void updateTab(Player p) {
        if (p.getScoreboard() == null) {
            setScoreboard(p);
        }

        Scoreboard board = p.getScoreboard();

        if(board.getTeam("A") == null || board.getTeam("B") == null || board.getTeam("C") == null || board.getTeam("D") == null || board.getTeam("E") == null || board.getTeam("F") == null || board.getTeam("G") == null || board.getTeam("H") == null || board.getTeam("I") == null || board.getTeam("J") == null || board.getTeam("K") == null || board.getTeam("L") == null || board.getTeam("M") == null || board.getTeam("N") == null || board.getTeam("O") == null || board.getTeam("P") == null || board.getTeam("Q") == null || board.getTeam("R") == null || board.getTeam("S") == null || board.getTeam("T") == null || board.getTeam("U") == null || board.getTeam("V") == null) {
            setTab(p);
        }

        Team A = board.getTeam("A");
        Team B = board.getTeam("B");
        Team C = board.getTeam("C");
        Team D = board.getTeam("D");
        Team E = board.getTeam("E");
        Team F = board.getTeam("F");
        Team G = board.getTeam("G");
        Team H = board.getTeam("H");
        Team I = board.getTeam("I");
        Team J = board.getTeam("J");
        Team K = board.getTeam("K");
        Team L = board.getTeam("L");
        Team M = board.getTeam("M");
        Team N = board.getTeam("N");
        Team O = board.getTeam("O");
        Team P = board.getTeam("P");
        Team Q = board.getTeam("Q");
        Team R = board.getTeam("R");
        Team S = board.getTeam("S");
        Team T = board.getTeam("T");
        Team U = board.getTeam("U");
        Team V = board.getTeam("V");

        for (Player all : Bukkit.getOnlinePlayers()) {
            if (Var.team_red.contains(all)) {
                A.addEntry(all.getName());
                all.setDisplayName("§4" + all.getName());
            } else if (Var.team_blue.contains(all)) {
                B.addEntry(all.getName());
                all.setDisplayName("§9" + all.getName());
            } else if (all.hasPermission("rank.1")) {
                C.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank1.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.2")) {
                D.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank2.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.3")) {
                E.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank3.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.4")) {
                F.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank4.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.5")) {
                G.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank5.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.6")) {
                H.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank6.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.7")) {
                I.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank7.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.8")) {
                J.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank8.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.9")) {
                K.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank9.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.10")) {
                L.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank10.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.11")) {
                M.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank11.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.12")) {
                N.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank12.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.13")) {
                O.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank13.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.14")) {
                P.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank14.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.15")) {
                Q.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank15.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.16")) {
                R.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank16.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.17")) {
                S.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank17.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.18")) {
                T.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank18.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.19")) {
                U.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank19.replace("&", "§") + all.getName());
            } else if (all.hasPermission("rank.20")) {
                V.addEntry(all.getName());
                all.setDisplayName(Var.sb_rank20.replace("&", "§") + all.getName());
            }
        }
    }

}
