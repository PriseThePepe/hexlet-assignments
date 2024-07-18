package exercise;

import java.util.Map;

// BEGIN
public abstract class Tag {
    String tagName;
    Map<String,String> attributes;
    Tag(String tag,Map<String,String> attributes) {
        this.tagName = tag;
        this.attributes = attributes;
    }
    public abstract String toString();
}
// END
