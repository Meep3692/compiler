package compiler.parser.rules;

import java.util.List;

import compiler.parser.ConsumeException;
import compiler.parser.RuleHelper;
import compiler.parser.node.Node;
import compiler.parser.node.NullNode;

/**
 * Whitespace has no meaning in this language so this rule is used to ignore it.
 */
public class WhitespaceRule implements IParserRule {

    @Override
    public Node parse(List<Object> stack) {
        try{
            RuleHelper helper = new RuleHelper(stack, 1);
            helper.consume("whitespace");
            Node node = new NullNode(1);
            node.start  = helper.start;
            node.line   = helper.line;
            node.column = helper.column;
            return node;
        }catch (ConsumeException e){
            return null;
        }
    }
    
}
