package eu.trefan.chat.model;

import org.bukkit.entity.Player;

import de.bananaco.bpermissions.api.ApiLayer;
import de.bananaco.bpermissions.api.CalculableType;

import eu.trefan.chat.model.channel.Channel;

public class Format {

	public static String formatMessage(Player sender, Channel channel, String message) {
		
		String format = "";
		
		if(sender.hasPermission("chat.color"))
			message = colorFormat(message);
		
		format = format.replace("{channel}", channel.getTag())
					   .replace("{prefix}", getInfo(sender, "prefix"))
					   .replace("{player}", sender.getName())
					   .replace("{suffix}", getInfo(sender, "suffix"))
					   .replace("{msg}", message)
					   .replace("{chatcolor}", channel.getColor().toString());
		
		
		return colorFormat(message);
	}
	
	private static String getInfo(Player p, String info) {
		String value = ApiLayer.getValue(p.getWorld().getName(), CalculableType.USER, p.getName(), info);
		if(value == null || value.equals(""))
			return "";
		return colorFormat(value);
	}
	
	private static String colorFormat(String format) {
		return format.replaceAll("&([a-z0-9])", "\u00A7$1");
	}
}
