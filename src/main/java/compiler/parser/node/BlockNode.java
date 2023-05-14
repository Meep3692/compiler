package compiler.parser.node;

import java.util.List;

public class BlockNode extends Node {

    public BlockNode(List<StatementNode> statements) {
        super("block", statements.size() + 2);
        this.children.addAll(statements);
    }
    
}
