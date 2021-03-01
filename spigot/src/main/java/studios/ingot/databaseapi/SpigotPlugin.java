package studios.ingot.databaseapi;

import org.bukkit.plugin.java.JavaPlugin;

public class SpigotPlugin extends JavaPlugin {

    private final SpigotDatabase databaseAPI;

    public SpigotPlugin() {
        this.databaseAPI = new SpigotDatabase(this);
    }

    @Override
    public void onEnable() {
        if (this.databaseAPI != null)
            this.databaseAPI.onStart();
        super.onEnable();
    }

    @Override
    public void onDisable() {
        if (this.databaseAPI != null)
            this.databaseAPI.onStop();
        super.onDisable();
    }
}
