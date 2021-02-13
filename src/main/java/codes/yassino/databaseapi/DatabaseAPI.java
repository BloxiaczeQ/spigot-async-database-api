package codes.yassino.databaseapi;

import codes.yassino.databaseapi.model.config.DatabaseConfig;
import codes.yassino.databaseapi.service.DatabaseService;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.plugin.java.JavaPlugin;


@Getter @Setter
public class DatabaseAPI extends JavaPlugin {

    @Getter
    private static DatabaseAPI instance;
    private DatabaseService databaseService;
    private DatabaseConfig testPluginConfig;

    @Override
    public void onEnable() {
        instance = this;
        testPluginConfig = new DatabaseConfig(getDataFolder(),"config");
        databaseService = new DatabaseService();
    }

}
