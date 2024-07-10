package com.bubbamc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.bubbamc.Listeners.InventoryMoveListener;

public class LinkedChests extends JavaPlugin {

	/* 
	 * config file stores info:
	 * names of linked groups - (linkedGroups.<group name>) - check if the group name exists to avoid conflicts
	 * ChestLocation.linkedGroup - (x,y,z.linkedGroup.<group name>) - will only have one group per x,y,z location (no multiple groups on one chest)
	 * Inventory serialized - (inventory.GroupName.slot.<Item>) - set(inventory." + groupName + "." + i, Item
	*/

	
	
	public void onEnable() {
		
		Bukkit.getServer().getPluginManager().registerEvents(new InventoryMoveListener(), this);
		Bukkit.getServer().getLogger().info("Linked Chests v" + this.getDescription().getVersion() + " enabled!");
	}
	

	public void onDisable() {
		Bukkit.getServer().getLogger().info("Linked Chests v" + this.getDescription().getVersion() + " disabled!");
	}
	
	

	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if ((sender instanceof Player)) {
			
			Player p = (Player) sender;
			
			
			if (cmd.getName().equalsIgnoreCase("chestlink")) {
				if (!(p.getItemInUse().getType().equals(Material.OAK_SIGN))) {
					p.sendMessage("Need an oak sign in your hand");
				}
			}
			
		}else {
			sender.sendMessage(ChatColor.RED + "This command is for players only");
			return true;
		}
		
		
		return false;
		
		
	}
	
}
