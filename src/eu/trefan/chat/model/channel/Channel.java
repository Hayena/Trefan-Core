package eu.trefan.chat.model.channel;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class Channel {
	protected String name;
	protected String tag;
	protected ArrayList<Player> members = new ArrayList<Player>();
	
	public Channel(String name, String tag) {
		this.name = name;
		this.tag = tag;
	}
	
	public void addMember(Player player) {
		members.add(player);
	}
	
	public void removeMember(Player player) {
		members.remove(player);
	}
	
	public void sendMessage(String message) {
		for(Player player: members) {
			player.sendMessage(message);
		}
	}
	
}
