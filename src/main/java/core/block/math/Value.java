package core.block.math;

import core.block.XMLCompositeNode;

public class Value extends XMLCompositeNode {

    public Value(String name, String actualVal){
        super("value");
        this.addAttribute("raw_value", actualVal);
    }

    @Override
    public String toJava() {
        return this.getAttribute("raw_value");
    }
}
