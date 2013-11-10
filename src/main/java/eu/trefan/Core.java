package eu.trefan;

import org.bukkit.plugin.java.JavaPlugin;

import eu.trefan.chat.ChatCommandHandler;


public class Core extends JavaPlugin {

	public void onDisable() {

	}

	public void onEnable() {
		
		
		
		this.getCommand("chat").setExecutor(new ChatCommandHandler());
	}
}