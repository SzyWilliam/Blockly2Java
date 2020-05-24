package core.block;

import core.block.math.Field;
import core.block.math.MathArithmetic;
import core.block.utils.MappingParser;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import static org.junit.jupiter.api.Assertions.*;

class XMLCompositeNodeTest {

    @Test
    void parseBasicXML(){
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = null;
        Document document = null;
        try{
            builder = documentBuilderFactory.newDocumentBuilder();
            document = builder.parse("./src/main/resources/test.xml");

        }catch (Exception ex){
            ex.printStackTrace();
        }

        NodeList nodeList = document.getElementsByTagName("block");
        for(int i = 0; i < nodeList.getLength(); i++){
            Node item = nodeList.item(i);
            if(item.getAttributes().getNamedItem("type").getTextContent().equals("math_arithmetic")){
                MathArithmetic mathArithmetic = MappingParser.parseArithmetic(item);
                System.out.println(mathArithmetic.toJava());
            }
        }




    }

}