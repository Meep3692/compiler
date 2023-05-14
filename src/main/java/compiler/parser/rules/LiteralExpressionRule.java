package compiler.parser.rules;

import java.util.List;

import compiler.parser.ConsumeException;
import compiler.parser.RuleHelper;
import compiler.parser.node.Node;
import compiler.tokenizer.Token;

public abstract class LiteralExpressionRule implements IParserRule {

    private String type;

    public LiteralExpressionRule(String type) {
        this.type = type;
    }

    @Override
    public Node parse(List<Object> stack) {
        try{
            RuleHelper helper = new RuleHelper(stack, 1);
            Token token = helper.consume(type);
            Node node = parse(token);
            node.start  = helper.start;
            node.line   = helper.line;
            node.column = helper.column;
            return node;
        }catch (ConsumeException e){
            return null;
        }
    }

    protected abstract Node parse(Token token);
    
}
