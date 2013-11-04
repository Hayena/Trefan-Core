package eu.trefan.chat;

import java.util.HashMap;

import org.bukkit.entity.Player;

import eu.trefan.chat.model.channel.Channel;

public class ChatManager {

	private HashMap<String, Channel> channels = new HashMap<String, Channel>();
	
	public ChatManager() {
		
	}
	
	public void createChannel() {
		
	}
	
	public void joinChannel(String name, Player player) {
		if(channels.containsKey(name)) {
			channels.get(name).addMember(player);
		}
	}

}
