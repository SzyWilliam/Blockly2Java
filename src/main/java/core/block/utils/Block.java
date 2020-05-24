package core.block.utils;

import core.block.XMLCompositeNode;


class BlockType {
    static final int MATH_NUMBER = 7;
    static final int MATH_ARITHMETIC = 8;
    static final int LOGIC_COMPARE = 11;
    static final int CONDITIONS_IF = 17;
}

public class Block extends XMLCompositeNode {

    public Block() {
        super("block");
    }
}
