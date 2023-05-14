package compiler.parser.rules;

import java.util.ArrayList;
import java.util.List;

import compiler.parser.node.BlockNode;
import compiler.parser.node.Node;
import compiler.parser.node.StatementNode;
import compiler.tokenizer.Token;

public class BlockRule implements IParserRule{

    @Override
    public Node parse(List<Object> stack) {
        if(stack.size() == 0){
            return null;
        }
        //Look for closing brace on top of stack
        Object top = stack.get(stack.size() - 1);
        if(top instanceof Token){
            Token token = (Token) top;
            if(token.type.equals("close-brace")){
                //Collect statements
                List<StatementNode> statements = new ArrayList<StatementNode>();
                int collected = 1;
                while(true){
                    if(stack.size() < collected){
                        return null;
                    }
                    Object next = stack.get(stack.size() - collected - 1);
                    if(next instanceof StatementNode){
                        statements.add(0, (StatementNode) next);
                        collected++;
                    }else if(next instanceof Token){
                        Token nextToken = (Token) next;
                        if(nextToken.type.equals("open-brace")){
                            return new BlockNode(statements);
                        }else{
                            return null;
                        }
                    }else{
                        return null;
                    }
                }
            }else{
                return null;
            }
        }else{
            return null;
        }
    }
    
}
