package studios.ingot.databaseapi.service;

import lombok.Getter;
import studios.ingot.databaseapi.DatabaseAPI;
import studios.ingot.databaseapi.enums.DatabaseType;
import studios.ingot.databaseapi.model.config.DatabaseConfig;
import studios.ingot.databaseapi.model.database.handler.MongoDatabaseHandler;
import studios.ingot.databaseapi.model.database.handler.MySQLDatabaseHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class DatabaseService {

    private final ExecutorService executorService;
    private final DatabaseAPI databaseAPI;
    private final DatabaseConfig databaseConfig;

    private MySQLDatabaseHandler mySQLDatabaseHandler;
    private MongoDatabaseHandler mongoDatabaseHandler;

    /**
     * init a database, appends on the DatabaseType Enum
     */
    public DatabaseService(DatabaseAPI databaseAPI) {
        this.databaseAPI = databaseAPI;
        this.databaseConfig = databaseAPI.getDatabaseConfig();
        this.executorService = Executors.newFixedThreadPool(8);

        if (databaseConfig.getDatabaseType() == DatabaseType.MYSQL) {
            mySQLDatabaseHandler = new MySQLDatabaseHandler(databaseConfig.getMySQLDatabaseCredentials().getUser(),
                    databaseConfig.getMySQLDatabaseCredentials().getPassword(),
                    databaseConfig.getMySQLDatabaseCredentials().getHost(),
                    databaseConfig.getMySQLDatabaseCredentials().getPort(),
                    databaseConfig.getMySQLDatabaseCredentials().getDatabase()
            );
        } else if (databaseConfig.getDatabaseType() == DatabaseType.MONGODB) {
            mongoDatabaseHandler = new MongoDatabaseHandler(databaseConfig.getMongoDatabaseCredentials().getUser(),
                    databaseConfig.getMongoDatabaseCredentials().getPassword(),
                    databaseConfig.getMongoDatabaseCredentials().getHost(),
                    databaseConfig.getMongoDatabaseCredentials().getPort(),
                    databaseConfig.getMongoDatabaseCredentials().getDatabase()
            );
        } else {
            databaseAPI.log("[WARN] Couldn't find any Database! plugins/DatabaseAPI/config.json (set databaseType to MONGODB/MYSQL)");
            databaseAPI.disable();
        }
    }

}
