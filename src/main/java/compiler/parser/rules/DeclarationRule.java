package compiler.parser.rules;

import java.util.List;

import compiler.parser.node.DeclarationNode;
import compiler.parser.node.Node;
import compiler.tokenizer.Token;

public class DeclarationRule implements IParserRule{

    @Override
    public Node parse(List<Object> tokens) {
        if(tokens.size() < 3) return null;
        Object tok1 = tokens.get(tokens.size() - 3);
        Object tok2 = tokens.get(tokens.size() - 2);
        Object tok3 = tokens.get(tokens.size() - 1);
        if(tok1 instanceof Token && tok2 instanceof Token && tok3 instanceof Token){
            Token let =       (Token)tok1;
            Token id =        (Token)tok2;
            Token semicolon = (Token)tok3;
            if(let.type.equals("identifier") && let.value.equals("let") && id.type.equals("identifier") && semicolon.type.equals("semicolon")){
                Node node = new DeclarationNode(3, id.value, null);
                node.start = let.start;
                node.line = let.line;
                node.column = let.column;
                return node;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }
    
}
