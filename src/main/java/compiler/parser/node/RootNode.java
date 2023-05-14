package compiler.parser.node;

import java.util.List;

import compiler.tokenizer.Token;

public class RootNode extends Node {
    public RootNode(List<Object> nodes) {
        super("", 0);
        for (Object node : nodes) {
            if(node instanceof Node){
                children.add((Node)node);
            }else{
                //TODO: Create parsing error when we encounter an unparsed token
                for(Object nodeprime : nodes){
                    System.err.println(nodeprime.toString());
                }
                throw new RuntimeException("Unparsed token " + ((Token)node).type);
            }
        }
    }

    @Override
    public String toSExp(){
        StringBuilder sb = new StringBuilder();
        for (Node node : children) {
            sb.append(node.toSExp());
        }
        return sb.toString();
    }
}
