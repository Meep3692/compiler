package compiler.parser.rules;

import java.util.List;

import compiler.parser.ConsumeException;
import compiler.parser.RuleHelper;
import compiler.parser.node.DeclarationNode;
import compiler.parser.node.Node;
import compiler.tokenizer.Token;

public class DeclarationRule implements IParserRule{

    @Override
    public Node parse(List<Object> stack) {
        try{
            RuleHelper helper = new RuleHelper(stack, 3);
            helper.consume("identifier");
            Token identifier = helper.consume("identifier");
            helper.consume("semicolon");
            DeclarationNode node = new DeclarationNode(helper.getConsumed(), identifier.value, null);
            node.start  = helper.start;
            node.line   = helper.line;
            node.column = helper.column;
            return node;
        }catch (ConsumeException e){
            return null;
        }
    }
    
}
