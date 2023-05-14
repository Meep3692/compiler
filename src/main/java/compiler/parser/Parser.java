package compiler.parser;

import java.util.LinkedList;
import java.util.List;

import compiler.parser.node.Node;
import compiler.parser.node.NullNode;
import compiler.parser.node.RootNode;
import compiler.parser.rules.IParserRule;
import compiler.tokenizer.Token;

public class Parser {

    private List<IParserRule> rules = new LinkedList<>();

    public Parser() {
    }

    public void addRule(IParserRule rule) {
        rules.add(rule);
    }

    public Node parse(List<Token> tokens) {
        List<Object> stack = new LinkedList<>();
        while(true){
            //System.out.println("Stack: " + stack.toString());
            Node longestNode = null;
            for (IParserRule rule : rules) {
                Node node = rule.parse(stack);
                if(node != null){
                    for(int i = 0; i < node.consumed; i++){
                        stack.remove(stack.size() - 1);
                    }
                    if(!(node instanceof NullNode)){
                        if(longestNode == null || node.consumed > longestNode.consumed){
                            longestNode = node;
                        }
                    }
                    break;
                }
            }
            if(longestNode != null) stack.add(longestNode);
            else{
                if(tokens.size() == 0) break;
                Token token = tokens.remove(0);
                stack.add(token);
            }
        }
        return new RootNode(stack);
    }
}
