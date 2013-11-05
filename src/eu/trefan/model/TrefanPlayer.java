package eu.trefan.model;

import java.util.HashMap;

public class TrefanPlayer {

	private final int id;
	
	protected String name;
	
	HashMap<String, String> attributes = new HashMap<String, String>();
	
	public TrefanPlayer(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getAttribute(String key) throws Exception {
		if(attributes.containsKey(key))
			return attributes.get(key);
		else
			throw new Exception("No such attribute");
	}
	
	public void addAttribute(String key, String value) throws Exception {
		if(attributes.containsKey(key))
			throw new Exception("Key already exists");
		else
			attributes.put(key, value);
	}
	
	public void setAttribute(String key, String value) throws Exception {
		if(attributes.containsKey(key))
			attributes.put(key, value);
		else
			throw new Exception("Key does not exist");
	}
	
	public static boolean exists(String name) {
		return false;
	}
	
	public static void create(String name) {
		
	}
}
