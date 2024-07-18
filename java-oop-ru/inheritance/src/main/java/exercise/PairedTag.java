package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

// BEGIN
public class PairedTag extends Tag{
    String tagName;
    Map<String,String> attributes;
    String tagBody;
    List<Tag> singleTags;

    PairedTag(String tag, Map<String, String> attributes, String tagBody,List<Tag> singleTags) {
        super(tag, attributes);
        this.tagName = tag;
        this.attributes = attributes;
        this.tagBody = tagBody;
        this.singleTags = singleTags;
    }
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("<").append(tagName);
        for (Map.Entry<String,String> entry: attributes.entrySet()) {
            builder.append(" ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
        }
        builder.append(">").append(tagBody);
        for(Tag tag:singleTags) {
            builder.append(tag.toString());
        }
        builder.append("</").append(tagName).append(">");
        return builder.toString();

    }
}
// END
