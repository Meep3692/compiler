package compiler.parser.rules;

import java.util.List;

import compiler.parser.ConsumeException;
import compiler.parser.RuleHelper;
import compiler.parser.node.ExpressionNode;
import compiler.parser.node.Node;
import compiler.parser.node.StatementNode;

public class ExpressionStatementRule implements IParserRule {

    @Override
    public Node parse(List<Object> stack) {
        try{
            RuleHelper helper = new RuleHelper(stack, 2);
            ExpressionNode expression =  helper.consume(ExpressionNode.class);
            helper.consume("semicolon");
            Node node = new StatementNode(expression.value, 2);
            node.children.add(expression);
            node.start  = helper.start;
            node.line   = helper.line;
            node.column = helper.column;
            return node;
        }catch (ConsumeException e){
            return null;
        }
    }
    
}
