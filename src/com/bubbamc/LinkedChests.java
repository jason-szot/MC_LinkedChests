package com.bubbamc;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class LinkedChests extends JavaPlugin {

	public void onEnable() {
		Bukkit.getServer().getLogger().info("Linked Chests v" + this.getDescription().getVersion() + " enabled!");
	}
	
	public void onDisable() {
		Bukkit.getServer().getLogger().info("Linked Chests v" + this.getDescription().getVersion() + " disabled!");
	}
	
}
