package studios.ingot.databaseapi.abstracts;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import lombok.Getter;
import studios.ingot.databaseapi.DatabaseAPI;

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

    /**
     * loads a configuration with a filereader
     */
    public void loadConfiguration() {
        try {
            FileReader fileReader = new FileReader(configFile);
            jsonObject = gson.fromJson(fileReader, JsonObject.class);
        } catch (FileNotFoundException e) {
            saveConfiguration();
        }
    }

    /**
     * saves a configuration with a filewriter
     */
    public void saveConfiguration() {
        try {
            FileWriter fileWriter = new FileWriter(configFile);
            fileWriter.write(gson.toJson(jsonObject));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException exception) {
            DatabaseAPI.getInstance().log("[WARN] Fail to save a configuration file -> " + exception.getMessage());
        }
    }

    /**
     * @param key declares a key to check
     * @return retuns a boolean if a key is contained in the jsonobject
     */
    public boolean has(String key) {
        return getJsonObject().has(key);
    }

    /**
     * @param key declares a key that gets added to a jsonobject with a value
     * @param value declares a value that gets added to a jsonobject with a key
     * @param fullUpdate declares a boolean that overwrites a key
     * @param <T> is a type parameter to declare everything
     */
    public <T> void append(String key, T value, boolean fullUpdate) {
        if(fullUpdate) {
            jsonObject.add(key, gson.toJsonTree(value));
        } else {
            if(!has(key)) {
                jsonObject.add(key, gson.toJsonTree(value));
            }
        }
    }

    /**
     * @param key declares a key that is getting the value
     * @param clazz declares a class of the value what should returned
     * @param <T> is a type parameter to declare everything
     * @return returns a value from a class
     */
    public <T> T get(String key, Class<T> clazz) {
        return gson.fromJson(jsonObject.get(key), clazz);
    }

}
