package eu.trefan.model;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class EventHandlerImpl implements Listener {
	
	public EventHandlerImpl()  { }
	
	@EventHandler
	public void onLogin(PlayerLoginEvent event) {
		String name = event.getPlayer().getDisplayName();
		if(TrefanPlayer.exists(name)) {
			
		} else {
			TrefanPlayer.create(name);
		}
	}
}
