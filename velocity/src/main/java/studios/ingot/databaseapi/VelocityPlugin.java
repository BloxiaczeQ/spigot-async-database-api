package studios.ingot.databaseapi;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import lombok.Getter;

import javax.inject.Inject;
import java.util.logging.Logger;

@Plugin(id = "async-database-api",
        name = "DatabaseAPI",
        version = "1.0-SNAPSHOT",
        authors = {"Yassino", "gusosasi", "Koboo"})
public class VelocityPlugin {

    @Getter
    private final ProxyServer proxyServer;
    @Getter
    private final Logger logger;
    private final DatabaseAPI velocityDatabase;

    @Inject
    public VelocityPlugin(ProxyServer proxyServer, Logger logger) {
        this.proxyServer = proxyServer;
        this.logger = logger;
        this.velocityDatabase = new VelocityDatabase(this);
    }

    @Subscribe
    public void onInit(ProxyInitializeEvent event) {
        this.velocityDatabase.onStart();
    }

    @Subscribe
    public void onShutdown(ProxyShutdownEvent event) {
        this.velocityDatabase.onStop();
    }
}
