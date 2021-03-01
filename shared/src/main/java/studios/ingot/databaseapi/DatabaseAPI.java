package studios.ingot.databaseapi;

import lombok.Getter;
import studios.ingot.databaseapi.model.config.DatabaseConfig;
import studios.ingot.databaseapi.service.DatabaseService;

import java.io.File;

public class DatabaseAPI {

    @Getter
    private static DatabaseAPI instance;
    private DatabaseService databaseService;
    private DatabaseConfig databaseConfig;

    public void onStart() {
        instance = this;
        File directory = new File("plugins/DatabaseAPI/");
        if(!directory.exists())
            directory.mkdirs();
        databaseConfig = new DatabaseConfig(directory, "config");
        databaseService = new DatabaseService();
    }

    public void onStop() {

    }
}
