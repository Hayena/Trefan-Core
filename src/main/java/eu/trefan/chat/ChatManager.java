package eu.trefan.chat;

import java.util.HashMap;

import org.bukkit.entity.Player;

import eu.trefan.Core;
import eu.trefan.chat.model.channel.Channel;
import eu.trefan.chat.model.channel.Private;

public class ChatManager {

	private HashMap<String, Channel> channels = new HashMap<String, Channel>();
	private Core plugin;
	
	
	
	public ChatManager(Core plugin) { 
		this.plugin = plugin;
		Channel global = new Channel("global", "G", plugin.getConfig().getString("chat.global.format"));
		channels.put("global", global);
		
	}
	
	public void createPrivateChannel(String name, String tag, Player player) {
		Channel channel = new Private(name, tag, player);
		channels.put(name, channel);
	}
	
	public void createPrivateChannel(String name, String tag, Player player, String password) {
		Channel channel = new Private(name, tag, player, password);
		channels.put(name, channel);
	}
	
	public void joinChannel(String name, Player player) {
		if(channels.containsKey(name)) {
			channels.get(name).addMember(player);
		}
	}
	
	public Channel getPlayerChannel(String playerName) {
		return plugin.getPlayer(playerName).getChannel();
	}
	
	public Channel getDefaultChannel() {
		return channels.get("global");
	}

}
