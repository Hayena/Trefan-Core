package eu.trefan.model;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

import org.bukkit.configuration.file.FileConfiguration;



public class Database {

	private String url;
	private String username;
	private String password;
	
	public Database(FileConfiguration config) { 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			url = String.format("jdbc:mysql://%ss:%s/%s",
								config.getString("database.address"),
								config.getString("database.port"),
								config.getString("database.name"));
			username = config.getString("database.username");
			password = config.getString("database.password");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	protected void storePlayer(TrefanPlayer player) { 
		
	}
	
	protected TrefanPlayer loadPlayer(String name) {
		return null;
	}
	
}
