package net.minecresthd.cores.mysql;

import net.minecresthd.cores.Var;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.*;

public class MySQL {

    public Connection con;

    public void connect() {
        if (!isConnected()) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + Var.sql_host + ":" + Var.sql_port + "/" + Var.sql_database + "?autoReconnect=true", Var.sql_user, Var.sql_password);
                Bukkit.getConsoleSender().sendMessage("§f§l| §7§l-> §eMySQL Stats §7- §asuccessfully loaded...");
            } catch (SQLException e) {
                Bukkit.getConsoleSender().sendMessage("§f§l| §7§l-> §eMySQL Stats §7- §4Could not load ...");
            }
        }
    }

    public void close() {
        if (isConnected()) {
            try {
                con.close();
                con = null;
                Bukkit.getConsoleSender().sendMessage("§f§l| §7§l-> §eMySQL Stats §7- §cConnection successfully closed...");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isConnected() {
        return con != null;
    }

    public void update(String qry) {
        if (isConnected()) {
            try {
                con.createStatement().executeUpdate(qry);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ResultSet getResult(String qry) {
        if (isConnected()) {
            try {
                return con.createStatement().executeQuery(qry);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void createTable() {
        if (isConnected()) {
            try {
                con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS `Cores_Stats` (`player` VARCHAR(25),`uuid` VARCHAR(50),`kills` INT(10),`deaths` INT(10),`kd` INT(10),`cores` INT(10),`played` INT(10),`won` INT(10))");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void registerPlayer(Player p) {
        if(!isPlayerExist(p.getUniqueId().toString())) {
            update("INSERT INTO `Cores_Stats` (`player`,`uuid`,`kills`,`deaths`,`kd`,`cores`,`played`,`won`) VALUES ('"+p.getName()+"','"+p.getUniqueId().toString()+"','0','0','0','0','0','0')");
        }
    }

    public boolean isPlayerExist(String uuid) {
        ResultSet rs = getResult("SELECT * FROM `Cores_Stats` WHERE uuid ='"+uuid+"'");
        try {
            if(rs.next()) {
                return rs.getString("player") != null;
            }
            rs.close();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //KILLS

    public int getKills(Player p) {
        int i = 0;
        try {
            ResultSet rs = getResult("SELECT * FROM `Cores_Stats` WHERE uuid='" + p.getUniqueId().toString() + "'");

            if ((!rs.next()) || (String.valueOf(rs.getString("kills")) == null));

            i = rs.getInt("kills");

        } catch (SQLException e) {

        }
        return i;
    }

    public int getKillsOther(String uuid) {
        int i = 0;
        try {
            ResultSet rs = getResult("SELECT * FROM `Cores_Stats` WHERE uuid='" + uuid + "'");

            if ((!rs.next()) || (String.valueOf(rs.getString("kills")) == null));

            i = rs.getInt("kills");

        } catch (SQLException e) {

        }
        return i;
    }

    public void addKills(Player p, int amount) {
        int ckills = getKills(p);
        amount+=ckills;
        if(isPlayerExist(p.getUniqueId().toString())) {
            update("UPDATE `Cores_Stats` SET kills='"+amount+"' WHERE uuid='" + p.getUniqueId().toString() + "'");
        }
    }

    //DEATHS

    public int getDeaths(Player p) {
        int i = 0;
        try {
            ResultSet rs = getResult("SELECT * FROM `Cores_Stats` WHERE uuid='" + p.getUniqueId().toString() + "'");

            if ((!rs.next()) || (String.valueOf(rs.getString("deaths")) == null));

            i = rs.getInt("deaths");

        } catch (SQLException e) {

        }
        return i;
    }

    public int getDeathsOther(String uuid) {
        int i = 0;
        try {
            ResultSet rs = getResult("SELECT * FROM `Cores_Stats` WHERE uuid='" + uuid + "'");

            if ((!rs.next()) || (String.valueOf(rs.getString("deaths")) == null));

            i = rs.getInt("deaths");

        } catch (SQLException e) {

        }
        return i;
    }

    public void addDeaths(Player p, int amount) {
        int cdeaths = getDeaths(p);
        amount+=cdeaths;
        if(isPlayerExist(p.getUniqueId().toString())) {
            update("UPDATE `Cores_Stats` SET deaths='"+amount+"' WHERE uuid='" + p.getUniqueId().toString() + "'");
        }
    }

    //CORES

    public int getCores(Player p) {
        int i = 0;
        try {
            ResultSet rs = getResult("SELECT * FROM `Cores_Stats` WHERE uuid='" + p.getUniqueId().toString() + "'");

            if ((!rs.next()) || (String.valueOf(rs.getString("cores")) == null));

            i = rs.getInt("cores");

        } catch (SQLException e) {

        }
        return i;
    }

    public int getCoresOther(String uuid) {
        int i = 0;
        try {
            ResultSet rs = getResult("SELECT * FROM `Cores_Stats` WHERE uuid='" + uuid + "'");

            if ((!rs.next()) || (String.valueOf(rs.getString("cores")) == null));

            i = rs.getInt("cores");

        } catch (SQLException e) {

        }
        return i;
    }

    public void addCores(Player p, int amount) {
        int ccores = getCores(p);
        amount+=ccores;
        if(isPlayerExist(p.getUniqueId().toString())) {
            update("UPDATE `Cores_Stats` SET cores='"+amount+"' WHERE uuid='" + p.getUniqueId().toString() + "'");
        }
    }

    //PLAYED

    public int getPlayed(Player p) {
        int i = 0;
        try {
            ResultSet rs = getResult("SELECT * FROM `Cores_Stats` WHERE uuid='" + p.getUniqueId().toString() + "'");

            if ((!rs.next()) || (String.valueOf(rs.getString("played")) == null));

            i = rs.getInt("played");

        } catch (SQLException e) {

        }
        return i;
    }

    public int getPlayedOther(String uuid) {
        int i = 0;
        try {
            ResultSet rs = getResult("SELECT * FROM `Cores_Stats` WHERE uuid='" + uuid + "'");

            if ((!rs.next()) || (String.valueOf(rs.getString("played")) == null));

            i = rs.getInt("played");

        } catch (SQLException e) {

        }
        return i;
    }

    public void addPlayed(Player p, int amount) {
        int cplayed = getPlayed(p);
        amount+=cplayed;
        if(isPlayerExist(p.getUniqueId().toString())) {
            update("UPDATE `Cores_Stats` SET played='"+amount+"' WHERE uuid='" + p.getUniqueId().toString() + "'");
        }
    }

    //WON

    public int getWon(Player p) {
        int i = 0;
        try {
            ResultSet rs = getResult("SELECT * FROM `Cores_Stats` WHERE uuid='" + p.getUniqueId().toString() + "'");

            if ((!rs.next()) || (String.valueOf(rs.getString("won")) == null));

            i = rs.getInt("won");

        } catch (SQLException e) {

        }
        return i;
    }

    public int getWonOther(String uuid) {
        int i = 0;
        try {
            ResultSet rs = getResult("SELECT * FROM `Cores_Stats` WHERE uuid='" + uuid + "'");

            if ((!rs.next()) || (String.valueOf(rs.getString("won")) == null));

            i = rs.getInt("won");

        } catch (SQLException e) {

        }
        return i;
    }

    public void addWon(Player p, int amount) {
        int cwon = getWon(p);
        amount+=cwon;
        if(isPlayerExist(p.getUniqueId().toString())) {
            update("UPDATE `Cores_Stats` SET won='"+amount+"' WHERE uuid='" + p.getUniqueId().toString() + "'");
        }
    }

}
