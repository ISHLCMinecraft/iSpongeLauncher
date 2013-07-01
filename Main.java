package ISHLC.iplugins;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

  Logger logger = Logger.getLogger("Minecraft");

	@Override
	public void onEnable() {
		PluginDescriptionFile pdf = this.getDescription();
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new pListener(this), this);
		this.logger.info("[" + pdf.getName() + "] " + pdf.getName() + " v"
				+ pdf.getVersion() + " has been Enabled!");
	}

	@Override
	public void onDisable() {
		PluginDescriptionFile pdf = this.getDescription();
		this.logger.info("[" + pdf.getName() + "] " + pdf.getName()
				+ " has been Disabled!");
	}
}
