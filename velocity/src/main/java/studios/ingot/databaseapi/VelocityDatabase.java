package studios.ingot.databaseapi;

public class VelocityDatabase extends DatabaseAPI {

    private final VelocityPlugin velocityPlugin;

    public VelocityDatabase(VelocityPlugin velocityPlugin) {
        this.velocityPlugin = velocityPlugin;
    }

    @Override
    public void log(String message) {
        this.velocityPlugin.getLogger().info(message);
    }

    @Override
    public void disable() {
        onStop();
    }
}
