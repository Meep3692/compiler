package compiler.parser.rules;

import java.util.List;

import compiler.parser.node.Node;
import compiler.parser.node.NullNode;
import compiler.tokenizer.Token;

/**
 * Whitespace has no meaning in this language so this rule is used to ignore it.
 */
public class WhitespaceRule implements IParserRule {

    @Override
    public Node parse(List<Object> tokens) {
        if(tokens.size() < 1) return null;
        Object top = tokens.get(tokens.size() - 1);
        if(top instanceof Token){
            Token token = (Token)top;
            if(token.type.equals("whitespace")){
                return new NullNode(1);
            }
        }
        return null;
    }
    
}
