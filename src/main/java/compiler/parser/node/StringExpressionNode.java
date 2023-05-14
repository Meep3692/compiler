package compiler.parser.node;

public class StringExpressionNode extends ExpressionNode{

    String parsedValue;

    public StringExpressionNode(String value) {
        super(value, 1);
        parsedValue = value.substring(1, value.length() - 1)
                           .replace("\\\"", "\"")
                           .replace("\\n",  "\n")
                           .replace("\\t",  "\t")
                           .replace("\\\\", "\\")
                           .replace("\\r",  "\r");
    }
    
}
