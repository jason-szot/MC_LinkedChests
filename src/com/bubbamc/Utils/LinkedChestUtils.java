package com.bubbamc.Utils;

import java.util.List;

import org.bukkit.Location;

import com.bubbamc.LinkedChests;

public class LinkedChestUtils {

	public static boolean isChestLinked(Location location) {
		String coords = String.valueOf(location.getX()) + String.valueOf(location.getY()) + String.valueOf(location.getZ());
		LinkedChests p = new LinkedChests();
		return p.getConfig().getBoolean(coords, false);
	}
	
	public static void setLinkedGroup(Location location, String group) {
		String coords = String.valueOf(location.getX()) + String.valueOf(location.getY()) + String.valueOf(location.getZ());
		LinkedChests p = new LinkedChests();
		p.getConfig().set(coords + ".linkedGroup", group);
	}
	
	public static String getLinkedGroup(Location location) {
		String coords = String.valueOf(location.getX()) + String.valueOf(location.getY()) + String.valueOf(location.getZ());
		LinkedChests p = new LinkedChests();
		return p.getConfig().getString(coords + ".linkedGroup");
	}
	
	
	// get a list of linked group names
	public static List<String> getLinkedGroupList() {
		LinkedChests p = new LinkedChests();
		List<String> list = p.getConfig().getStringList("linkedGroups");
		return list;
	}
	
}
