package MainPack;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.CommandExecute;

public class Commands extends CommandExecute implements Listener, CommandExecutor {


	public boolean isVanished = false;

	public String cmd4 = "vanish";


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			//-----------------------------------------------------------------------------------
			//-                                 VANISH 
			if(cmd.getName().equalsIgnoreCase(cmd4)) {
				Player player = ((Player)sender);
				isVanished = !isVanished;

				if(!isVanished) {
					player.sendMessage(ChatColor.GREEN + "You are now SHOWN to everyone.");
					for(Player online : Bukkit.getOnlinePlayers()) {
						online.showPlayer(player);
						online.sendMessage(ChatColor.YELLOW + sender.getName() + " joined the game");
					}

					return true;
				}else {
					player.sendMessage(ChatColor.RED + "You are now HIDDEN to everyone.");
					for(Player online : Bukkit.getOnlinePlayers()) {
						online.hidePlayer(player);
						online.sendMessage(ChatColor.YELLOW + sender.getName() + " left the game");
					}
					return true;
				}
				
			}
	} 


	else {
		sender.sendMessage(ChatColor.RED + "only players can use this command");
		return true;
	}

	return false;
}

}