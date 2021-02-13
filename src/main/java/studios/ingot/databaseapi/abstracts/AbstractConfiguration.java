package studios.ingot.databaseapi.abstracts;

import studios.ingot.databaseapi.DatabaseAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import lombok.Getter;

import java.io.*;
@Getter
public abstract class AbstractConfiguration {

    private JsonObject jsonObject = new JsonObject();
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final File rootPath;
    private final File configFile;

    public AbstractConfiguration(File rootPath, String name) {
        this.rootPath = rootPath;
        this.rootPath.mkdirs();
        this.configFile = new File(rootPath, name+".json");
    }

    public void loadConfiguration() {
        try {
            FileReader fileReader = new FileReader(configFile);
            jsonObject = gson.fromJson(fileReader, JsonObject.class);
        } catch (FileNotFoundException e) {
            saveConfiguration();
        }
    }


    public void saveConfiguration() {
        try {
            FileWriter fileWriter = new FileWriter(configFile);
            fileWriter.write(gson.toJson(jsonObject));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException exception) {
            DatabaseAPI.getInstance().getServer().getLogger().warning("Fail to save the configuration file -> " + exception.getMessage());
        }
    }

    public boolean has(String key) {
        return getJsonObject().has(key);
    }

    public <T> void append(String key, T value, boolean fullUpdate) {
        if(fullUpdate) {
            jsonObject.add(key, gson.toJsonTree(value));
        } else {
            if(!has(key)) {
                jsonObject.add(key, gson.toJsonTree(value));
            }
        }
    }

    public <T> T get(String key, Class<T> clazz) {
        return gson.fromJson(jsonObject.get(key), clazz);
    }

}
