package studios.ingot.databaseapi.service;

import studios.ingot.databaseapi.DatabaseAPI;
import studios.ingot.databaseapi.model.config.DatabaseConfig;
import studios.ingot.databaseapi.enums.DatabaseType;
import studios.ingot.databaseapi.model.database.handler.MongoDatabaseHandler;
import studios.ingot.databaseapi.model.database.handler.MySQLDatabaseHandler;
import lombok.Getter;
import org.bukkit.Bukkit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class DatabaseService {

    private final ExecutorService executorService = Executors.newFixedThreadPool(8);
    private MySQLDatabaseHandler mySQLDatabaseHandler;
    private MongoDatabaseHandler mongoDatabaseHandler;
    private DatabaseConfig databaseConfig = DatabaseAPI.getInstance().getTestPluginConfig();


    /**
     * init a database, appends on the DatabaseType Enum
     */
    public DatabaseService() {
        if (databaseConfig.getDatabaseType() == DatabaseType.MYSQL) {
            new MySQLDatabaseHandler(databaseConfig.getMySQLDatabaseCredentials().getUser(),
                    databaseConfig.getMySQLDatabaseCredentials().getPassword(),
                    databaseConfig.getMySQLDatabaseCredentials().getHost(),
                    databaseConfig.getMySQLDatabaseCredentials().getPort(),
                    databaseConfig.getMySQLDatabaseCredentials().getDatabase()
            );
        } else if (databaseConfig.getDatabaseType() == DatabaseType.MONGODB) {
            new MongoDatabaseHandler(databaseConfig.getMongoDatabaseCredentials().getUser(),
                    databaseConfig.getMongoDatabaseCredentials().getPassword(),
                    databaseConfig.getMongoDatabaseCredentials().getHost(),
                    databaseConfig.getMongoDatabaseCredentials().getPort(),
                    databaseConfig.getMongoDatabaseCredentials().getDatabase()
            );
        } else {
            DatabaseAPI.getInstance().getServer().getLogger().warning("Couldn't find any Database! plugins/DatabaseAPI/config.json (set databaseType to MONGODB/MYSQL)");
            Bukkit.getPluginManager().disablePlugin(DatabaseAPI.getInstance());
        }
    }

}
