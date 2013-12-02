package eu.trefan.model;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import eu.trefan.Core;

public class MainEventHandler implements Listener {
	
	Core plugin;
	
	public MainEventHandler(Core plugin)  {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onLogin(PlayerLoginEvent event) {
		plugin.addPlayer(event.getPlayer());
	}
	
	@EventHandler
	public void onLogout(PlayerQuitEvent event) {
		plugin.removePlayer(event.getPlayer().getName());
	}
}
