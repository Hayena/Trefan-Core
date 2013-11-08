package eu.trefan.chat.model.channel;

import org.bukkit.entity.Player;

public class Private extends Channel {

	protected Player owner;
	
	protected boolean isProtected;
	protected String password;
	
	public Private(String name, String tag, Player owner) {
		super(name, tag);
		this.owner = owner;
		isProtected = false;
		addMember(owner);
	}
	
	public Private(String name, String tag, Player owner, String password) {
		this(name, tag, owner);
		this.password = password;
		isProtected = true;
	}
	
	@Override
	public void addMember(Player player) {
		if(isProtected) {
			
		} else {
			super.addMember(player);
		}
	}
	
	

}
