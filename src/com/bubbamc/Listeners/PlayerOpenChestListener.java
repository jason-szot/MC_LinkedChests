package com.bubbamc.Listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import com.bubbamc.LinkedChests;
import com.bubbamc.Utils.InventoryUtils;
import com.bubbamc.Utils.LinkedChestUtils;

public class PlayerOpenChestListener implements Listener {

	LinkedChests plugin;
	
	/*
	 * Listens for Players to interact with a chest
	 * checks if chest is linked
	 * if linked, open the group inventory
	 * if not, open the chest clicked
	 * 
	 */
	public PlayerOpenChestListener(LinkedChests plugin) {
		this.plugin = plugin;
	}
	
	
	@EventHandler
	public boolean onChestOpen(PlayerInteractEvent e) {
		Block block = e.getClickedBlock();
		Material mat = block.getType();
		if ( !(mat.equals(Material.CHEST)) ) { // return out of event handler if no chest was clicked (only regular chests will link)
			return false;
		}
		
		// at this point, we know block is a chest, so we can cast it as a chest
		Chest chest = (Chest) block;
		LinkedChestUtils chestUtils = new LinkedChestUtils();
		if (!(chestUtils.isChestLinked(chest.getLocation()))) {
			e.getPlayer().openInventory(chest.getInventory());
			return true;
		} else {
			InventoryUtils invUtils = new InventoryUtils();
			String group = chestUtils.getLinkedGroup(chest.getLocation());
			Inventory inv = invUtils.toInventory(plugin.getConfig(), group);
			e.getPlayer().openInventory(inv);
			return true;
		}
		
	}
	
	@EventHandler
	public boolean onChestClose(InventoryCloseEvent e) {
		
		LinkedChestUtils chestUtils = new LinkedChestUtils();
		InventoryUtils invUtils = new InventoryUtils();
		Block block = e.getInventory().getLocation().getBlock();
		if (chestUtils.isChestLinked(block.getLocation())) {
			String group = chestUtils.getLinkedGroup(block.getLocation());
			invUtils.saveInventory(e.getInventory(), plugin.getConfig(), group);
		}
		
		
		return false;
		
	}
	
}
