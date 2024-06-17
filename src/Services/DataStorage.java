package Services;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author JeanSL
 */
public class DataStorage {
    private static DataStorage instance;
    private Map<String, Object> storage;

    private DataStorage() {
        storage = new HashMap<>();
    }

    public static synchronized DataStorage getInstance() {
        if (instance == null) {
            instance = new DataStorage();
        }
        return instance;
    }

    public void saveData(String key, Object value) {
        storage.put(key, value);
    }

    public Object getData(String key) {
        return storage.get(key);
    }

    public boolean containsKey(String key) {
        return storage.containsKey(key);
    }
    
    public void clearData() {
        storage.clear();
    }
}
