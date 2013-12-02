package eu.trefan;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import eu.trefan.chat.ChatCommandHandler;
import eu.trefan.chat.ChatManager;
import eu.trefan.chat.model.ChatEventHandler;
import eu.trefan.model.MainEventHandler;
import eu.trefan.model.TrefanPlayer;


public class Core extends JavaPlugin {
	
	protected ChatManager chatManager;
	protected HashMap<String, TrefanPlayer> players = new HashMap<String, TrefanPlayer>();

	public void onDisable() {

	}

	public void onEnable() {
		
		
		chatManager = new ChatManager(this);
		this.getCommand("chat").setExecutor(new ChatCommandHandler(chatManager));
		
		getServer().getPluginManager().registerEvents(new ChatEventHandler(chatManager), this);
		getServer().getPluginManager().registerEvents(new MainEventHandler(this), this);
	}
	
	public void addPlayer(Player player) {
		TrefanPlayer tPlayer = new TrefanPlayer(0, player.getName(), chatManager.getDefaultChannel());
		players.put(player.getName(), tPlayer);
	}
	
	public void removePlayer(String playerName) {
		players.remove(playerName);
	}
	
	public TrefanPlayer getPlayer(String playerName) {
		return players.get(playerName);
	}
}