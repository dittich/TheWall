package de.dittich.TheWall;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class TheWall extends JavaPlugin {

	public static ArrayList<String> rot = new ArrayList<String>();
	public static ArrayList<String> gelb = new ArrayList<String>();
	public static ArrayList<String> gruen = new ArrayList<String>();
	public static ArrayList<String> blau = new ArrayList<String>();
	
	@Override
	public void onEnable() {
		super.onEnable();
		
		String pluginName = this.getDescription().getName();
		String pluginVersion = this.getDescription().getVersion();
		
		new TheWallListener(this);
		
		System.out.println("TheWall Plugin " + pluginName + ", Version " + pluginVersion + " geladen.");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String label, String[] args) {

		//Umwandlung Sender -> Player
		Player p = null;
		if(sender instanceof Player){
			p = (Player)sender;
		}
		
		//Kommando "Test"
		if(cmd.getName().equalsIgnoreCase("test")){
			
			if(p!=null){
				p.setHealth(20);
				p.sendMessage(ChatColor.RED + "Hallo, " + p.getDisplayName());
				p.sendMessage(ChatColor.GREEN + "[Plugin Tutorial]" + ChatColor.WHITE + "geladen");
				p.sendMessage("Eine Idee von " + this.getDescription().getAuthors().get(0));
				return true;
			}
			else{
				sender.sendMessage(ChatColor.GREEN + "[Plugin Tutorial]" + ChatColor.WHITE + "geladen");
				return true;
			}
		}
		return false;
	}
}
