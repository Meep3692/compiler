package compiler.parser.node;

public class DeclarationNode extends StatementNode {

    String indentifier;
    ExpressionNode initialAssignment;

    public DeclarationNode(int consumed, String indentifier, ExpressionNode initialAssignment) {
        super("let", consumed);
        this.indentifier = indentifier;
        this.initialAssignment = initialAssignment;
        if(initialAssignment != null){
            this.children.add(initialAssignment);
        }
    }
    
    @Override
    public String toSExp() {
        return "(let " + indentifier + (initialAssignment == null ? "" : " " + initialAssignment.toSExp()) + ")";
    }

}
