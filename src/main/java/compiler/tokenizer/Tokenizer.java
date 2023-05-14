package compiler.tokenizer;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    private List<ITokenReader> readers = new ArrayList<ITokenReader>();

    public Tokenizer() {

    }

    public void addTokenReader(ITokenReader reader) {
        readers.add(reader);
    }

    public List<Token> tokenize(String input){
        List<Token> tokens = new ArrayList<Token>();
        int pos = 0;
        int line = 0;
        int column = 0;
        while (input.length() > 0) {
            List<Token> matches = new ArrayList<Token>();
            for (ITokenReader reader : readers) {
                Token token = reader.readToken(input);
                if (token != null) {
                    matches.add(token);
                }
            }
            if (matches.size() > 0) {
                Token longest = matches.get(0);
                for (Token match : matches) {
                    if (match.value.length() > longest.value.length()) {
                        longest = match;
                    }
                }
                longest.start = pos;
                longest.line = line;
                longest.column = column;
                tokens.add(longest);
                pos += longest.value.length();
                for (int i = 0; i < longest.value.length(); i++) {
                    if (longest.value.charAt(i) == '\n') {
                        line++;
                        column = 0;
                    } else {
                        column++;
                    }
                }
                input = input.substring(longest.value.length());
            } else {
                throw new RuntimeException("Unexpected token on input: " + input);
            }
        }
        return tokens;
    }
}
