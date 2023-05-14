package compiler.parser.node;

public class AddExpressionNode extends ExpressionNode {

    ExpressionNode left;
    ExpressionNode right;

    public AddExpressionNode(ExpressionNode left, ExpressionNode right) {
        super("(" + left.value + " + " + right.value + ")", 3);
        this.left = left;
        this.right = right;
        this.children.add(left);
        this.children.add(right);
    }
    
}
