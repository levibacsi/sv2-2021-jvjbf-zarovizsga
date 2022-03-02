package sentences;

import java.util.HashSet;
import java.util.Set;

public class SentenceTransformer {
    public String shortenSentence(String sentence){
        char[] chars = sentence.toCharArray();

        if (Character.isLowerCase(chars[0])){
            throw new IllegalArgumentException("Must start with capital letter!");
        }

        if (chars[chars.length -1] != '.' &&
                chars[chars.length -1] != '?' &&
                chars[chars.length -1] != '!'){
            throw new IllegalArgumentException("Must end with . ! or ?");
        }

        String[] words = sentence.split(" ");
        if (words.length >= 5) {
            return words[0] + " ... " + words[words.length - 1];
        } else {
            return sentence;
        }
    }
}
