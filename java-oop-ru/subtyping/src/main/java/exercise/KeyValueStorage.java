package exercise;

import java.util.Map;

public interface KeyValueStorage {
    KeyValueStorage set(String key, String value);
    KeyValueStorage unset(String key);
    String get(String key, String defaultValue);
    Map<String, String> toMap();
}
