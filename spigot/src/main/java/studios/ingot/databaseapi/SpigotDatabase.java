package studios.ingot.databaseapi;

import org.bukkit.Bukkit;

public class SpigotDatabase extends DatabaseAPI {

    private final SpigotPlugin spigotPlugin;

    public SpigotDatabase(SpigotPlugin spigotPlugin) {
        this.spigotPlugin = spigotPlugin;
    }

    @Override
    public void log(String message) {
        spigotPlugin.getLogger().info(message);
    }

    @Override
    public void disable() {
        Bukkit.getPluginManager().disablePlugin(spigotPlugin);
    }
}
