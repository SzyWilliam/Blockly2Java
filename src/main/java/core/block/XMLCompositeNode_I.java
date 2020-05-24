package core.block;

import java.util.List;

public interface XMLCompositeNode_I extends XMLNode_I{

    public List<XMLCompositeNode_I> getChildren();

    public void appendChild(XMLCompositeNode_I node);
}
