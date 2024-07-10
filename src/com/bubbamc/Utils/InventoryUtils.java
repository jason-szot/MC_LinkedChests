package com.bubbamc.Utils;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;

public class InventoryUtils {

	
	public static Inventory toInventory(FileConfiguration config, String group) {
		Inventory in = Bukkit.createInventory(null, 27, group);
		for (int i = 0; i < 27; i++) {
			if (config.isItemStack("inventory." + group + "." + i)) {
				in.setItem(i, config.getItemStack("inventory." + group + "." + i));
			}
		}
		return in;
	}
	
	
	public static void saveInventory(Inventory inv, FileConfiguration config, String group) {
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
