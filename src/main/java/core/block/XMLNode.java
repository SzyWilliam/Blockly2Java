package core.block;


import java.util.HashMap;
import java.util.Map;

/**
 * The XMLNode class acts as the base class of all xml nodes
 * it implements and provides the basic function of any text xml nodes
 * it is also used to construct complex xml nodes
 *
 * @author SongZiYang
 * Created at 2020.5.21
 *
 * @version demo.0.1
 */
public class XMLNode implements XMLNode_I, XMLNode2Java_I{

    public XMLNode(String tagName, String innerText){
        this.tagName = tagName;
        this.innerText = innerText;
        this.attributes = new HashMap<String, String>();
    }


    public String getTagName() {
        return tagName;
    }

    public String getAttribute(String attributeKey) {
        return attributes.get(attributeKey);
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public String getText() {
        return innerText;
    }

    public void addAttribute(String attributeKey, String attributeValue){
        this.attributes.put(attributeKey, attributeValue);
    }




    private String tagName;
    private HashMap<String, String> attributes;
    private String innerText;

    public String toJava() {
        return null;
    }
}
