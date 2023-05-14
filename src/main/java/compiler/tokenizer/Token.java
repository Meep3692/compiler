package compiler.tokenizer;

public class Token {
    public String type;
    public String value;
    public int start;
    public int line;
    public int column;
    public Token(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String toString() {
        return type + ": " + value;
    }
}
