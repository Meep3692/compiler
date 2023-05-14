package compiler.tokenizer;

public class RegexTokenBuilder {
    
    private Tokenizer tokenizer;

    public RegexTokenBuilder(Tokenizer tokenizer){
        this.tokenizer = tokenizer;
    }

    public RegexTokenBuilder add(String type, String regex){
        this.tokenizer.addTokenReader(new RegexTokenReader(type, regex));
        return this;
    }
}
