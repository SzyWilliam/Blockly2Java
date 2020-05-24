package core.block;

import java.util.Map;


/**
 * Interface for XMLNode
 * this interface defines the basic functions of a basic XML node
 * note that the base node only includes three important attributes:
 * 1. node name
 * 2. attributes
 * 3. innerText
 *
 * @author SonfZiYang
 * Create at 2020.5.21
 *
 * @version demo.0.1
 */
public interface XMLNode_I {

    public String getTagName();

    public String getAttribute(String attributeKey);

    public Map<String, String> getAttributes();

    public String getText();
}
