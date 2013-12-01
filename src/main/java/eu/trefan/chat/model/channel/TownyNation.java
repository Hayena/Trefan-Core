package eu.trefan.chat.model.channel;

import java.util.List;

import org.bukkit.entity.Player;

import eu.trefan.chat.model.Format;
import eu.trefan.model.TrefanException;
import eu.trefan.utils.TownyHandler;

public class TownyNation extends Channel {

	public TownyNation(String name, String tag) {
		super(name, tag);
	}

	@Override
	public void sendMessage(Player sender, String message) {
		try {
			if (TownyHandler.hasNation(sender.getName())) {
				this.removeMember(sender);
				sender.sendMessage("");
				return;
			}
			List<Player> players = TownyHandler.getMembersNation(name);
			String out = Format.formatTownyMessage(sender, message, this);
			for (Player player : players) {
				player.sendMessage(out);
			}
		} catch (TrefanException te) {
			sender.sendMessage(te.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
