package net.minecresthd.cores.mysql;

import net.minecresthd.cores.Var;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL_coins {

    public Connection con;

    public void connect() {
        if (!isConnected()) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + Var.sqlc_host + ":" + Var.sqlc_port + "/" + Var.sqlc_database + "?autoReconnect=true", Var.sqlc_user, Var.sqlc_password);
                Bukkit.getConsoleSender().sendMessage("§f§l| §7§l-> §eMySQL Coins §7- §asuccessfully loaded...");
            } catch (SQLException e) {
                Bukkit.getConsoleSender().sendMessage("§f§l| §7§l-> §eMySQL Coins §7- §4Could not load ...");
            }
        }
    }

    public void close() {
        if (isConnected()) {
            try {
                con.close();
                con = null;
                Bukkit.getConsoleSender().sendMessage("§f§l| §7§l-> §eMySQL Coins §7- §cConnection successfully closed...");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isConnected() {
        return con != null;
    }

    public void createTable() {
        if (isConnected()) {
            try
            {
                con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS `Coins` (`player` VARCHAR(50),`uuid` VARCHAR(50),`coins` INT(50))");
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void registerPlayer(Player p) {
        if(!isPlayerExist(p.getUniqueId().toString())) {
            update("INSERT INTO `Coins` (`player`,`uuid`,`coins`) VALUES ('"+p.getName()+"','"+p.getUniqueId().toString()+"','0')");
        }
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

    public boolean isPlayerExist(String uuid) {
        ResultSet rs = getResult("SELECT * FROM `Coins` WHERE uuid ='"+uuid+"'");
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

    public void addCoins(Player p, int amount) {
        int ccoins = getCoins(p);
        amount+=ccoins;
        if(isPlayerExist(p.getUniqueId().toString())) {
            update("UPDATE `Coins` SET coins='"+amount+"' WHERE uuid='" + p.getUniqueId().toString() + "'");
        }
    }

    public void removeCoins(Player p, int amount) {
        int ccoins = getCoins(p);
        amount-=ccoins;
        if(isPlayerExist(p.getUniqueId().toString())) {
            update("UPDATE `Coins` SET coins='"+amount+"' WHERE uuid='" + p.getUniqueId().toString() + "'");
        }
    }

    public int getCoins(Player p) {
        int i = 0;
        try {
            ResultSet rs = getResult("SELECT * FROM `Coins` WHERE uuid='" + p.getUniqueId().toString() + "'");

            if ((!rs.next()) || (String.valueOf(rs.getString("coins")) == null));

            i = rs.getInt("coins");

        } catch (SQLException e) {

        }
        return i;
    }

}
