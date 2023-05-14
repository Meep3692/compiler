package compiler.parser;

import java.util.List;

import compiler.parser.node.Node;
import compiler.tokenizer.Token;

public class RuleHelper {
    private List<Object> stack;
    private int consumed;
    private final int toConsume;
    public int start;
    public int line;
    public int column;

    public RuleHelper(List<Object> stack, int toConsume) throws ConsumeException {
        this.stack = stack;
        this.consumed = 0;
        this.toConsume = toConsume;
        if(stack.size() < toConsume){
            throw new ConsumeException("Not enough tokens to consume");
        }else{
            Object obj = stack.get(stack.size() - toConsume);
            if(obj instanceof Token){
                Token token = (Token) obj;
                this.start = token.start;
                this.line = token.line;
                this.column = token.column;
            }else if(obj instanceof Node){
                Node node = (Node) obj;
                this.start = node.start;
                this.line = node.line;
                this.column = node.column;
            }else{
                throw new ConsumeException("Expected Token or Node but got " + obj.getClass().getName() + " (this should be impossible)");
            }
        }
    }

    public <T> T consume(Class<T> type) throws ConsumeException {
        Object consumed = this.stack.get(this.stack.size() - this.toConsume + this.consumed);
        this.consumed++;
        //Check that type of consumed is T
        if (type.isInstance(consumed)) {
            return (T) consumed;
        } else {
            throw new ConsumeException("Expected " + type.getName() + " but got " + consumed.getClass().getName());
        }
    }

    public Token consume(String type) throws ConsumeException {
        Object consumed = this.stack.get(this.stack.size() - this.toConsume + this.consumed);
        this.consumed++;
        if (consumed instanceof Token) {
            Token token = (Token) consumed;
            if (token.type == type){
                return (Token) consumed;
            }  else {
                throw new ConsumeException("Expected Token of type " + type + " but got " + token.type);
            }
        } else {
            throw new ConsumeException("Expected Token but got " + consumed.getClass().getName());
        }
    }

    public int getConsumed() {
        return this.consumed;
    }
}
