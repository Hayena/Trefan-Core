package eu.trefan.chat.model.channel;

import java.util.ArrayList;

import org.bukkit.Color;
import org.bukkit.entity.Player;

import eu.trefan.chat.model.Format;

public class Channel {
	protected String name;
	protected String tag;
	protected Color color;
	protected String format;
	protected ArrayList<Player> members = new ArrayList<Player>();
	
	public Channel(String name, String tag) {
		this.name = name;
		this.tag = tag;
		color = Color.WHITE;
		format = "";
	}
	
	public Channel(String name, String tag, Color color) {
		this(name, tag);
		this.color = color;
	}
	
	public Channel(String name, String tag, String format) {
		this(name, tag);
		this.format = format;
	}
	
	public void addMember(Player player) {
		members.add(player);
	}
	
	public void removeMember(Player player) {
		members.remove(player);
	}
	
	public void sendMessage(Player sender, String message) {
		String out = Format.formatMessage(sender, message, this);
		for(Player player: members) {
			player.sendMessage(out);
		}
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public String getTag() {
		return tag;
	}
	
	public Color getColor() {
		return color;
	}
	
	public String getFormat() {
		return format;
	}
}
