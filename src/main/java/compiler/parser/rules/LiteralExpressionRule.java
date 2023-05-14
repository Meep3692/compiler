package compiler.parser.rules;

import java.util.List;

import compiler.parser.node.Node;
import compiler.tokenizer.Token;

public abstract class LiteralExpressionRule implements IParserRule {

    private String type;

    public LiteralExpressionRule(String type) {
        this.type = type;
    }

    @Override
    public Node parse(List<Object> tokens) {
        if(tokens.size() < 1) return null;
        Object top = tokens.get(tokens.size() - 1);
        if(top instanceof Token){
            Token token = (Token)top;
            if(token.type.equals(type)){
                Node node = parse(token);
                node.start = token.start;
                node.line = token.line;
                node.column = token.column;
                return node;
            } else {
                return null;
            }
        }else{
            return null;
        }
    }

    protected abstract Node parse(Token token);
    
}
