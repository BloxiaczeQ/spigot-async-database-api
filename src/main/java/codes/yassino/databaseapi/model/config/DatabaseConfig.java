package codes.yassino.databaseapi.model.config;

import codes.yassino.databaseapi.abstracts.AbstractConfiguration;
import codes.yassino.databaseapi.enums.DatabaseType;
import codes.yassino.databaseapi.model.database.credentials.MongoDatabaseCredentials;
import codes.yassino.databaseapi.model.database.credentials.MySQLDatabaseCredentials;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Getter @Setter
public class DatabaseConfig extends AbstractConfiguration {


    private DatabaseType databaseType = DatabaseType.NONE;
    private MongoDatabaseCredentials mongoDatabaseCredentials = new MongoDatabaseCredentials();
    private MySQLDatabaseCredentials mySQLDatabaseCredentials = new MySQLDatabaseCredentials();

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
