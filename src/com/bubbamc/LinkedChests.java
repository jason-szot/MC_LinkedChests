package com.bubbamc;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.bubbamc.Listeners.InventoryMoveListener;
import com.bubbamc.Listeners.PlayerOpenChestListener;

public class LinkedChests extends JavaPlugin {

	ArrayList<String> groups;
	ArrayList<Location> locations;
	ArrayList<LinkedChestObject> linkedChests;
	
	public void onEnable() {
		
		Bukkit.getServer().getPluginManager().registerEvents(new InventoryMoveListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerOpenChestListener(this), this);
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
	
	public ArrayList<String> getGroups(){
		return this.groups;
	}
	
}
