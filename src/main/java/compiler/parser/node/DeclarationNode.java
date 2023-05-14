package compiler.parser.node;

public class DeclarationNode extends Node {

    String indentifier;
    ExpressionNode initialAssignment;

    public DeclarationNode(int consumed, String indentifier, ExpressionNode initialAssignment) {
        super("let", consumed);
        this.indentifier = indentifier;
        this.initialAssignment = initialAssignment;
    }
    
}
