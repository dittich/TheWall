package de.dittich.TheWall;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class TheWallListener implements Listener{

	public TheWallListener(JavaPlugin plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerDeath(PlayerDeathEvent event){
		Player p = event.getEntity();
		p.sendMessage("Treffer versenkt");
		p.sendMessage("Du bist aus " + p.getFallDistance() + "m Hoehe gestuerzt");
		
		if(p.getFallDistance() > 20){
			p.setLevel(p.getLevel()+5);
		}
		if(p.getFallDistance() <= 20){
			p.setLevel(p.getLevel()-1);
		}
		if(p.getFallDistance() == 20){
			p.setLevel(p.getLevel()+20);
		}
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerJoin(PlayerJoinEvent event){
		Player p = event.getPlayer();
		p.sendMessage("Willkommen im Event FreeFall");
	}
}
