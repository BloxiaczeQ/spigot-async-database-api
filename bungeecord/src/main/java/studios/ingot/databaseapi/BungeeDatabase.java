package studios.ingot.databaseapi;

public class BungeeDatabase extends DatabaseAPI {

    private final BungeePlugin bungeePlugin;

    public BungeeDatabase(BungeePlugin bungeePlugin) {
        this.bungeePlugin = bungeePlugin;
    }

    @Override
    public void log(String message) {
        this.bungeePlugin.getLogger().info(message);
    }

    @Override
    public void disable() {
        this.bungeePlugin.onDisable();
    }
}
