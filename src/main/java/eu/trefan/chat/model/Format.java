package eu.trefan.chat.model;

import org.bukkit.entity.Player;

import de.bananaco.bpermissions.api.ApiLayer;
import de.bananaco.bpermissions.api.CalculableType;
import eu.trefan.chat.model.channel.Channel;
import eu.trefan.model.TrefanException;
import eu.trefan.utils.TownyHandler;

public class Format {

	public static String formatMessage(Player sender, String message, Channel channel) {
		return formatMessage(sender, message, channel, channel.getFormat());
	}

	public static String formatTownyMessage(Player sender, String message,
			Channel channel) {
		String format = channel.getFormat();
		try {
			String playerName = sender.getName();
			format.replace("{towny}", 	TownyHandler.getTownyTag(playerName))
				  .replace("{title}", 	TownyHandler.getTitle(playerName))
			      .replace("{surname}", TownyHandler.getSurname(playerName));
		} catch (TrefanException te) {
			sender.sendMessage(te.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formatMessage(sender, message, channel, format);
	}

	private static String formatMessage(Player sender, String message, Channel channel, String format) {
		if (sender.hasPermission("chat.color"))
			message = colorFormat(message);

		format = format.replace("{channel}", channel.getTag())
				.replace("{prefix}", getInfo(sender, "prefix"))
				.replace("{player}", sender.getName())
				.replace("{suffix}", getInfo(sender, "suffix"))
				.replace("{msg}", message)
				.replace("{chatcolor}", channel.getColor().toString());
		format.replaceAll("\\{.*\\}", "");
		return colorFormat(format);
	}

	private static String getInfo(Player p, String info) {
		String value = ApiLayer.getValue(p.getWorld().getName(),
				CalculableType.USER, p.getName(), info);
		if (value == null || value.equals(""))
			return "";
		return colorFormat(value);
	}

	private static String colorFormat(String format) {
		return format.replaceAll("&([a-z0-9])", "\u00A7$1");
	}

}
