package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    String value;
    TagInterface tag;
    LabelTag(String value, TagInterface tag) {
        this.value = value;
        this.tag = tag;
    }
    @Override
    public String render() {
        return "<label>" + this.value + tag.render() + "</label>";
    }

    public static void main(String[] args) {
        TagInterface tag = new InputTag("submit", "Save");
        System.out.println(tag.render()); // <input type="submit" value="Save">

        TagInterface inputTag = new InputTag("submit", "Save");
        TagInterface labelTag = new LabelTag("Press Submit", inputTag);
        System.out.println(labelTag.render());
// <label>Press Submit<input type="submit" value="Save"></label>
    }
}
// END
