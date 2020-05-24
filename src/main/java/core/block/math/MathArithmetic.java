package core.block.math;

import core.block.XMLCompositeNode;

public class MathArithmetic extends XMLCompositeNode {

    public MathArithmetic(Field op, Value oprandFirst, Value oprandSecond){
        super("block");
        this.Op = op;
        this.OprandFirst = oprandFirst;
        this.OprandSecond = oprandSecond;

    }

    @Override
    public String toJava() {
        return OprandFirst.toJava() + " " + Op.toJava() + " " + OprandSecond.toJava();
    }

    private Field Op;
    private Value OprandFirst;
    private Value OprandSecond;
}
