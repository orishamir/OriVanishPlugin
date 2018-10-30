package MainPack;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class main extends JavaPlugin implements Listener {
	private Commands commands = new Commands();
	
	public void onEnable() {
		

		getCommand(commands.cmd4).setExecutor(commands);

		
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\nOri's Plugin has been Enabled\n\n");
		
	}

	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\nOri's Plugin has been Disabled\n\n");
	}

	
}
