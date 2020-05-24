package core.block.utils;

import core.block.math.Field;
import core.block.math.MathArithmetic;
import core.block.math.Value;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MappingParser {
    public static Field parseField(Node node){
        String type = node.getAttributes().getNamedItem("name").getTextContent();
        Field field = null;
        if(type.equals("NUM")){
            field = new Field("NUM", node.getTextContent());
        }else if(type.equals("OP")){
            String OPDes = node.getTextContent();
            if(OPDes.equals("MULTIPLY")) {
                field = new Field("OP", "*");
            }
            else if(OPDes.equals("EQ")){
                field = new Field("OP", "==");

            }else{
                field = new Field("OP", "OP_NOT_SUPPORT");
            }
        }else if (type.equals("TEXT")){
            String actualText = "\"" + node.getTextContent() + "\"";
            field = new Field("TEXT", actualText);
        }
        return field;
    }


    public static Value parseValue(Node node){
        Value value = null;
        Field wrapped = parseField(node.getFirstChild().getNextSibling().getFirstChild().getNextSibling());
        String typename = wrapped.getAttribute("name");
        value = new Value(typename, wrapped.toJava());
        return value;
    }

    public static MathArithmetic parseArithmetic(Node node){
        NodeList children = node.getChildNodes();
        Field op = null;
        Value oprand1 = null;
        Value oprand2 = null;
        int fir = 0;

        for(int i = 0; i < children.getLength(); i++){
            if(children.item(i).getNodeName().equals("field")){
                 op = parseField(children.item(i));
            }if(children.item(i).getNodeName().equals("value") && fir == 0){
                oprand1 = parseValue(children.item(i));
                fir++;
            }else if(children.item(i).getNodeName().equals("value")){
                oprand2 = parseValue(children.item(i));
            }
        }

        return new MathArithmetic(op, oprand1, oprand2);
    }
}
