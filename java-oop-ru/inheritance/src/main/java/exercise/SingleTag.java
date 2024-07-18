package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    String tagName;
    Map<String,String> attributes;
    SingleTag(String tag, Map<String,String> attributes) {
        super(tag,attributes);
        this.tagName = tag;
        this.attributes = attributes;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("<").append(tagName);
        for (Map.Entry<String,String> entry: attributes.entrySet()) {
            builder.append(" ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
        }
        builder.append(">");
        return builder.toString();
    }

}
// END
