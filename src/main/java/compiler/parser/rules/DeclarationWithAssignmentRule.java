package compiler.parser.rules;

import java.util.List;

import compiler.parser.ConsumeException;
import compiler.parser.RuleHelper;
import compiler.parser.node.DeclarationNode;
import compiler.parser.node.ExpressionNode;
import compiler.parser.node.Node;
import compiler.tokenizer.Token;

public class DeclarationWithAssignmentRule implements IParserRule {

    @Override
    public Node parse(List<Object> stack) {
        
        try{
            RuleHelper helper = new RuleHelper(stack, 5);
            helper.consume("identifier");
            Token identifier = helper.consume("identifier");
            helper.consume("assignment");
            ExpressionNode expression = helper.consume(ExpressionNode.class);
            helper.consume("semicolon");
            DeclarationNode node = new DeclarationNode(helper.getConsumed(), identifier.value, expression);
            node.start  = helper.start;
            node.line   = helper.line;
            node.column = helper.column;
            return node;
        }catch (ConsumeException e){
            return null;
        }
    }
    
}
