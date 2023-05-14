package compiler.parser.rules;

import java.util.List;

import compiler.parser.node.ExpressionNode;
import compiler.parser.node.InfixExpressionNode;
import compiler.parser.node.Node;
import compiler.tokenizer.Token;

/**
 * Base class for infix expression rules
 */
public class InfixExpressionRule implements IParserRule {

    @Override
    public Node parse(List<Object> tokens) {
        if(tokens.size() < 3) return null;
        Object left = tokens.get(tokens.size() - 3);
        Object op = tokens.get(tokens.size() - 2);
        Object right = tokens.get(tokens.size() - 1);
        if(left instanceof ExpressionNode && op instanceof Token && right instanceof ExpressionNode){
            ExpressionNode leftNode = (ExpressionNode)left;
            Token opToken = (Token)op;
            ExpressionNode rightNode = (ExpressionNode)right;
            if(opToken.type == "infix"){
                Node node =  new InfixExpressionNode(leftNode, rightNode, opToken.value);
                node.start = leftNode.start;
                node.line = leftNode.line;
                node.column = leftNode.column;
                return node;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }
    
}
