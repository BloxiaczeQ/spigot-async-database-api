package studios.ingot.databaseapi;

import net.md_5.bungee.api.plugin.Plugin;

public class BungeePlugin extends Plugin {

    private final DatabaseAPI databaseAPI;

    public BungeePlugin() {
        this.databaseAPI = new BungeeDatabase(this);
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
