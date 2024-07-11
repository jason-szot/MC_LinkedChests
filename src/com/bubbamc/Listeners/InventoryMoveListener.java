package com.bubbamc.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;

public class InventoryMoveListener implements Listener{

	public InventoryMoveListener() {
		
	}
	
	
	@EventHandler
	public void onInventoryMove(InventoryMoveItemEvent e) {
		//TODO: hopper pushing to and pulling from a chest
	}
	
}
