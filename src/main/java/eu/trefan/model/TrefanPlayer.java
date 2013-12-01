package eu.trefan.model;

import java.util.HashMap;

import eu.trefan.chat.model.channel.Channel;

public class TrefanPlayer {

	private final int id;
	private Channel currentChannel;
	
	
	protected String name;
	
	HashMap<String, String> attributes = new HashMap<String, String>();
	
	public TrefanPlayer(int id, String name, Channel channel) {
		this.id = id;
		this.name = name;
		currentChannel = channel;
	}
	
	public int getId() {
		return id;
	}
	
	public void setChannel(Channel channel) {
		this.currentChannel = channel;
	}
	
	public Channel getChannel() {
		return currentChannel;
	}
	
	
}
