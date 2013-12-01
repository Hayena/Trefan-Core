package eu.trefan.chat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ChatCommandHandler implements CommandExecutor {

	private ChatManager chatManager;
	
	public ChatCommandHandler(ChatManager chatManager) {
		this.chatManager = chatManager;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		return false;
	}

}
