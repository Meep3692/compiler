package compiler.tokenizer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTokenReader implements ITokenReader{

    private String type;
    private Pattern regex;

    public RegexTokenReader(String type, String regex){
        if(regex.charAt(0) != '^')
            regex = "^" + regex;
        this.type = type;
        this.regex = Pattern.compile(regex);
    }

    @Override
    public Token readToken(String input) {
        Matcher matcher = regex.matcher(input);
        if (matcher.find()) {
            return new Token(type, matcher.group());
        }else{
            return null;
        }
    }
    
}
