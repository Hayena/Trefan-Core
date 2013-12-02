package eu.trefan.chat.model;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import eu.trefan.chat.ChatManager;
import eu.trefan.chat.model.channel.Channel;

public class ChatEventHandler implements Listener {

	private ChatManager chatManager;
	
	public ChatEventHandler(ChatManager chatManager) {
		this.chatManager = chatManager;
	}

	
	
	@EventHandler
	public void onLogin(PlayerLoginEvent event) {
		chatManager.getDefaultChannel().addMember(event.getPlayer());
	}
	
	@EventHandler
	public void onLogout(PlayerQuitEvent event) {
		chatManager.getDefaultChannel().removeMember(event.getPlayer());
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		Channel channel = chatManager.getPlayerChannel(player.getName());
		channel.sendMessage(player, event.getMessage());
		event.setCancelled(false);
	}
}
