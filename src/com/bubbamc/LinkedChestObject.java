package com.bubbamc;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.inventory.Inventory;

public class LinkedChestObject {

	private ArrayList<Location> LinkedLocations;
	private Inventory inventory;
	private String InventoryName;
	
	public LinkedChestObject(Inventory inv, Location location, String group) {
		if (LinkedLocations == null) {
			LinkedLocations = new ArrayList<Location>();
		}
		LinkedLocations.add(location);
		inventory = inv;
		InventoryName = group;
	}
	
	public LinkedChestObject(Inventory inv, ArrayList<Location> locationList, String group) {
		LinkedLocations = locationList;
		inventory = inv;
		InventoryName = group;
	}
	
	public void addLocation(Location location) {
		LinkedLocations.add(location);
	}
	
	public ArrayList<Location> getLocations(){
		return LinkedLocations;
	}
	
	public Inventory getInventory() {
		return inventory;
	}
	
	public String getGroupName() {
		return InventoryName;
	}
	
	public void removeLocation(Location location) {
		ArrayList<Location> holding = new ArrayList<Location>();
		for (Location loc : LinkedLocations) {
			if (compareLocations(location, loc)) {
				holding.add(loc);
			}
		}
		LinkedLocations = holding;
	}
	
	public boolean findLocation(Location location) {
		for (Location loc : LinkedLocations) {
			if (compareLocations(location, loc)) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean compareLocations(Location a, Location b) {
		return (a.getX() == b.getX()) && (a.getY() == b.getY()) && (a.getZ() == b.getZ());
	}
}
