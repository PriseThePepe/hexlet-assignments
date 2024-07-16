package exercise;

import java.util.Map;


// BEGIN
public class App  {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> map = storage.toMap();
        map.keySet().forEach(storage::unset);
        map.forEach((key, value) -> storage.set(value, key));
    }
}
// END
