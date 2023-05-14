package compiler.parser.node;

/**
 * Special node for consuming tokens without creating a node. This node will
 * never be pushed onto the stack by the parser, but the parser will remove
 * the consumed tokens from the stack.
 * Used by WhitespacesRule.
 */
public class NullNode extends Node {

    public NullNode(int consumed) {
        super("", consumed);
    }
    
}
