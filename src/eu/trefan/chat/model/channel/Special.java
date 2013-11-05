package eu.trefan.chat.model.channel;

import org.bukkit.entity.Player;

public class Special extends Channel {

	protected String permissionNode;
	
	public Special(String name, String tag, String permissionNode) {
		super(name, tag);
		this.permissionNode = permissionNode;
	}
	
	@Override
	public void addMember(Player player) {
		if(player.hasPermission(permissionNode)) {
			super.addMember(player);
		}
	}

}
