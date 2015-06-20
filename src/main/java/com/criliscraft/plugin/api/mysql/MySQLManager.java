package com.criliscraft.plugin.api.mysql;

import com.criliscraft.plugin.CriLisCraft;
import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import java.util.logging.Level;

public class MySQLManager {

    private final CriLisCraft plugin;
    private MySQL db;

    public MySQLManager(CriLisCraft plugin) {
        this.plugin = plugin;
    }

    public void setupDatabase() throws SQLException {
        String host = plugin.getConfig().getString("mysql.host");
        String port = plugin.getConfig().getString("mysql.port");
        String database = plugin.getConfig().getString("mysql.database");
        String username = plugin.getConfig().getString("mysql.username");
        String password = plugin.getConfig().getString("mysql.password");

        this.db = new MySQL(this.plugin, host, port, database, username, password);

        try {
            this.db.openConnection();
        } catch (ClassNotFoundException e) {
            this.plugin.getLogger().log(Level.SEVERE, "Failed to open MySQL connection.");
            this.plugin.getLogger().log(Level.SEVERE, "Error:" + e);
            this.plugin.getServer().getPluginManager().disablePlugin(plugin);
        }
        Statement statement = this.db.getConnection().createStatement();
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS 'player_info' ('uuid' varchar(200), 'name' varchar(200)");
        statement.close();
    }

    public void closeDatabase() {
        try {
            this.db.closeConnection();
        } catch (SQLException e) {
            this.plugin.getLogger().log(Level.SEVERE, "Failed to close MySQL connection.");
            this.plugin.getLogger().log(Level.SEVERE, "Error:" + e);
        }
    }

    public UUID getUUIDFromName(String name) throws SQLException {
        Statement statement = this.db.getConnection().createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM 'player_info' WHERE 'name' = '" + name + "';");
        if (!rs.next()) {
            return null;
        }
        statement.close();
        rs.close();
        return UUID.fromString(rs.getString("uuid"));
    }

    public void addPlayer(Player player) throws SQLException {
        Statement statement = this.db.getConnection().createStatement();
        UUID uuid = player.getUniqueId();
        String name = player.getName();
        statement.executeUpdate("INSERT INTO 'player_info' ('uuid', 'name') VALUES ('" + uuid.toString() + "', '" + name + "')");
        statement.close();
    }
}
