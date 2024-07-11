package com.bubbamc.Utils;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;

public class InventoryUtils {

	/*
	 * method to create an inventory with the items stored by group
	 *  creates a virtual inventory with the group name as he inventory name
	 *  loads the items from config:
	 *  
	 * inventory:
	 *     <group>:
	 *         0: <itemstack info>
	 *         1: <itemstack info>
	 */
	public Inventory toInventory(FileConfiguration config, String group) {
		Inventory in = Bukkit.createInventory(null, 27, group);
		for (int i = 0; i < 27; i++) {
			if (config.isItemStack("inventory." + group + "." + i)) {
				in.setItem(i, config.getItemStack("inventory." + group + "." + i));
			}
		}
		
		return in;
	}
	
	
	/* 
	 * method to save inventory to config file:
	 * 
	 * inventory:
	 *     <group>:
	 *         0: <itemstack info>
	 *         1: <itemstack info>
	*/
	public void saveInventory(Inventory inv, FileConfiguration config, String group) {
		for (int i = 0; i < inv.getSize(); i++) {
			if (inv.getItem(i) != null) {
				config.set("inventory." + group + "." + i, inv.getItem(i));
			} else {
				if (config.isItemStack("inventory." + group + "." + i)) {
					config.set("inventory." + group + "." + i, null);
				}
			}
		}
	}
	
}
