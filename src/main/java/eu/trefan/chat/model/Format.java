package eu.trefan.chat.model;

public class Format {

	public static String formatMessage(String message) {
		return colorFormat(message);
	}
	
	private static String colorFormat(String format) {
		return format.replaceAll("&([a-z0-9])", "\u00A7$1");
	}
}
