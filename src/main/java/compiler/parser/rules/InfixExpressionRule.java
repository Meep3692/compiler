package compiler.parser.rules;

import java.util.List;

import compiler.parser.ConsumeException;
import compiler.parser.RuleHelper;
import compiler.parser.node.ExpressionNode;
import compiler.parser.node.InfixExpressionNode;
import compiler.parser.node.Node;
import compiler.tokenizer.Token;

/**
 * Base class for infix expression rules
 */
public class InfixExpressionRule implements IParserRule {

    @Override
    public Node parse(List<Object> stack) {
        try{
            RuleHelper helper = new RuleHelper(stack, 3);
            ExpressionNode left = helper.consume(ExpressionNode.class);
            Token op = helper.consume("infix");
            ExpressionNode right = helper.consume(ExpressionNode.class);
            InfixExpressionNode node = new InfixExpressionNode(left, right, op.value);
            node.start  = helper.start;
            node.line   = helper.line;
            node.column = helper.column;
            return node;
        }catch (ConsumeException e){
            return null;
        }
    }
    
}
