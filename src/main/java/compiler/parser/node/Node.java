package compiler.parser.node;

import java.util.ArrayList;
import java.util.List;

public abstract class Node {
    public String value;
    public int consumed;
    
    public int start;
    public int line;
    public int column;

    public List<Node> children = new ArrayList<Node>();
    
    public Node(String value, int consumed) {
        this.value = value;
        this.consumed = consumed;
    }

    public String toStringIndent(int indent) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < indent; i++){
            sb.append("\t");
        }
        sb.append(this.getClass().getSimpleName());
        sb.append(" [");
        sb.append(value);
        sb.append("]");
        if(children.size() > 0){
            sb.append(" {\n");
            for (Node node : children) {
                sb.append(node.toStringIndent(indent + 1));
                sb.append("\n");
            }
            for(int i = 0; i < indent; i++){
                sb.append("\t");
            }
            sb.append("}\n");
        }
        return sb.toString();
    }

    public String toSExp(){
        StringBuilder sb = new StringBuilder();
        if(children.size() == 0){
            sb.append(value);
            return sb.toString();
        }else{
            sb.append("(");
            sb.append(value);
            for (Node node : children) {
                sb.append(" ");
                sb.append(node.toSExp());
            }
            sb.append(")");
            return sb.toString();
        }
    }

    @Override
    public String toString() {
        return toStringIndent(0);
    }
}
