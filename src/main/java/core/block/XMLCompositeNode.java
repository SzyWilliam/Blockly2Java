package core.block;

import java.util.ArrayList;
import java.util.List;

public class XMLCompositeNode extends  XMLNode implements XMLCompositeNode_I {
    public XMLCompositeNode(String tagName){
        super(tagName, null);
        this.children = new ArrayList<XMLCompositeNode_I>();
    }

    public List<XMLCompositeNode_I> getChildren() {
        return children;
    }

    public void appendChild(XMLCompositeNode_I node) {
        this.children.add(node);

    }

    private ArrayList<XMLCompositeNode_I> children;
}
