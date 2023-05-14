package compiler.parser.rules;

import java.util.List;

import compiler.parser.node.Node;

public interface IParserRule {
    public Node parse(List<Object> stack);
}
