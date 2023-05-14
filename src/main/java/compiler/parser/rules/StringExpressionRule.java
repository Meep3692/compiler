package compiler.parser.rules;

import compiler.parser.node.Node;
import compiler.parser.node.StringExpressionNode;
import compiler.tokenizer.Token;

public class StringExpressionRule extends LiteralExpressionRule {

    public StringExpressionRule() {
        super("string");
    }

    @Override
    protected Node parse(Token token) {
        return new StringExpressionNode(token.value);
    }

    
}
