package compiler.parser.rules;

import compiler.parser.node.Node;
import compiler.parser.node.NumberExpressionNode;
import compiler.tokenizer.Token;

public class NumberExpressionRule extends LiteralExpressionRule {

    public NumberExpressionRule() {
        super("number");
    }

    @Override
    protected Node parse(Token token) {
        return new NumberExpressionNode(Integer.parseInt(token.value));
    }
    
}
