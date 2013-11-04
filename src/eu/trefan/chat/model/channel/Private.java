package eu.trefan.chat.model.channel;

import org.bukkit.entity.Player;

public class Private extends Channel {

	protected Player owner;
	
	protected boolean isProtected;
	protected String password;
	
	public Private(String name, Player owner) {
		super(name);
		this.owner = owner;
		isProtected = false;
		super.addMember(owner);
	}
	
	public Private(String name, Player owner, String password) {
		super(name);
		this.owner = owner;
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
