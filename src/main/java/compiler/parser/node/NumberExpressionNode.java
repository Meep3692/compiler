package compiler.parser.node;

public class NumberExpressionNode extends ExpressionNode {

    public int number;

    public NumberExpressionNode(int number) {
        super(Integer.toString(number), 1);
        this.number = number;
    }
    
}
