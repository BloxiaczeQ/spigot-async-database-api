package studios.ingot.databaseapi;

import lombok.Getter;
import studios.ingot.databaseapi.model.config.DatabaseConfig;
import studios.ingot.databaseapi.service.DatabaseService;

import java.io.File;

public abstract class DatabaseAPI {

    @Getter
    private static DatabaseAPI instance;
    @Getter
    private DatabaseService databaseService;
    @Getter
    private DatabaseConfig databaseConfig;

    public void onStart() {
        instance = this;
        File directory = new File("plugins/DatabaseAPI/");
        if(!directory.exists())
            directory.mkdirs();
        databaseConfig = new DatabaseConfig(directory, "config");
        databaseService = new DatabaseService(this);
    }

    public void onStop() {

    }

    public static DatabaseAPI getInstance() {
        return instance;
    }

    public static DatabaseAPI getAPI() {
        return getInstance();
    }

    public abstract void log(String message);

    public abstract void disable();
}
