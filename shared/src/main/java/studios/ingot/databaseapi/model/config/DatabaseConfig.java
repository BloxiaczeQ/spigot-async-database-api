package studios.ingot.databaseapi.model.config;

import studios.ingot.databaseapi.abstracts.AbstractConfiguration;
import studios.ingot.databaseapi.enums.DatabaseType;
import studios.ingot.databaseapi.model.database.credentials.MongoDatabaseCredentials;
import studios.ingot.databaseapi.model.database.credentials.MySQLDatabaseCredentials;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Getter @Setter
public class DatabaseConfig extends AbstractConfiguration {


    private DatabaseType databaseType = DatabaseType.NONE;
    private MongoDatabaseCredentials mongoDatabaseCredentials = new MongoDatabaseCredentials();
    private MySQLDatabaseCredentials mySQLDatabaseCredentials = new MySQLDatabaseCredentials();

    /**
     *
     * @param rootpath declares the path to the .json file
     * @param name declares the name of the .json file
     */
    public DatabaseConfig(File rootpath, String name) {
        super(rootpath,name);

        loadConfiguration();

        append("databaseType", databaseType ,false);
        append("mongodb", mongoDatabaseCredentials,false);
        append("mysql",mySQLDatabaseCredentials,false);

        setMongoDatabaseCredentials(get("mongodb", MongoDatabaseCredentials.class));
        setMySQLDatabaseCredentials(get("mysql", MySQLDatabaseCredentials.class));
        setDatabaseType(get("databaseType", DatabaseType.class));
        saveConfiguration();
    }

}
