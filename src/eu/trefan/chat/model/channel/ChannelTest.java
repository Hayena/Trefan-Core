package eu.trefan.chat.model.channel;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChannelTest {

	@Test
	public void test() {
		Private channel = new Private("Chat", "chat", null);
		assertFalse(channel.isProtected);
		
		channel = new Private("Chat", "chat", null, "password");
		assertTrue(channel.isProtected);
	}

}
