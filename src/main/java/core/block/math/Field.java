package core.block.math;

import core.block.XMLNode;

class FieldType {
    public static final int NUM = 1;
    public static final int ADD = 2;
    public static final int SUB = 3;
    public static final int MULTI = 4;
    public static final int DIV = 4;
}

public class Field extends XMLNode {
    public Field(String name, String text){
        super("Field", text);
        this.addAttribute("name", name);
    }

    @Override
    public String toJava() {
        return this.getText();
    }
}
