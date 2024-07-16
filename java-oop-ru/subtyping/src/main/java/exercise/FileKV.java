package exercise;

import java.util.HashMap;
import java.util.Map;
// BEGIN
public class FileKV implements KeyValueStorage {
    private String path;
    FileKV(String path, Map<String, String> storage) {
        this.path = path;
        Utils.writeFile(path, Utils.serialize(new HashMap<>(storage)));
    }

    @Override
    public void set(String key, String value) {
        Map<String, String> storage = Utils.unserialize(Utils.readFile(path));
        storage.put(key, value);
        Utils.writeFile(path, Utils.serialize(storage));
    }

    @Override
    public void unset(String key) {
        Map<String, String> storage = Utils.unserialize(Utils.readFile(path));
        storage.remove(key);
        Utils.writeFile(path, Utils.serialize(storage));
    }

    @Override
    public String get(String key, String defaultValue) {
        Map<String, String> storage = Utils.unserialize(Utils.readFile(path));
        return storage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return Utils.unserialize(Utils.readFile(path));
    }

}
// END
