package eu.trefan.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.palmergames.bukkit.towny.object.Nation;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.TownyUniverse;

import eu.trefan.model.TrefanException;

public class TownyHandler {

	private static Resident getResident(String playerName) throws Exception {
		return TownyUniverse.getDataSource().getResident(playerName);
	}
	
	private static Town getTownByResident(Resident resident) throws Exception {
		if(resident.hasTown()) {
			return resident.getTown();
		}
		throw new TrefanException("You are not a member of a town.");
	}
	
	private static Town getTown(String name) throws Exception {
		return TownyUniverse.getDataSource().getTown(name);
	}
	
	private static Nation getNation(String name) throws Exception {
		return TownyUniverse.getDataSource().getNation(name);
	}
	
	private static String getTownTag(Resident resident) throws Exception {
		Town town = getTownByResident(resident);
		return town.hasTag() ? town.getTag() : town.getName();
	}
	
	private static String getNationTag(Resident resident) throws Exception {
		Nation nation = getTownByResident(resident).getNation();
		return nation.hasTag() ? nation.getTag() : nation.getName();
	}
	
	public static String getTownyTag(String playerName) throws Exception {
		Resident resident = getResident(playerName);
		String townTag = getTownTag(resident);
		if(resident.hasNation()) {
			String nationTag = getNationTag(resident);
			return " [" + ChatColor.GOLD + nationTag + ChatColor.WHITE + "|" + ChatColor.DARK_AQUA + townTag + ChatColor.WHITE + "]";
		} else
			return " [" + ChatColor.DARK_AQUA + townTag + ChatColor.WHITE + "]";
	}
	
	public static String getTitle(String playerName) throws Exception {
		return getResident(playerName).getTitle();
	}
	
	public static String getSurname(String playerName) throws Exception {
		return getResident(playerName).getSurname();
	}
	
	public static List<Player> getMembersTown(String name) throws Exception {
		List<Resident> residents = getTown(name).getResidents();
		return convertListToPlayers(residents);
	}
	
	public static List<Player> getMembersNation(String name) throws Exception {
		List<Resident> residents = getNation(name).getResidents();
		return convertListToPlayers(residents);
	}
	
	private static List<Player> convertListToPlayers(List<Resident> residents) {
		ArrayList<Player> players = new ArrayList<Player>();
		for(Resident resident : residents) {
			Player player = Bukkit.getServer().getPlayer(resident.getName());
			players.add(player);
		}
		return players;
	}
	
	public static boolean hasTown(String playerName) throws Exception {
		return getResident(playerName).hasTown();
	}
	
	public static boolean hasNation(String playerName) throws Exception {
		return getResident(playerName).hasNation();
	}
}