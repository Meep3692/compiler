package compiler.parser.node;

public class InfixExpressionNode extends ExpressionNode {

    ExpressionNode left;
    ExpressionNode right;
    String operator;

    public InfixExpressionNode(ExpressionNode left, ExpressionNode right, String operator) {
        super(operator, 3);
        this.left = left;
        this.right = right;
        this.operator = operator;
        this.children.add(left);
        this.children.add(right);
    }
    
}
