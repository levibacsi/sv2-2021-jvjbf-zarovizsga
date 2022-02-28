package sentences;

import java.util.ArrayList;
import java.util.List;

public class SentenceTransformer {
    public String shortenSentence(String sentence){
        String shortSentence = "";

        if (sentence.substring(0, 1).equals(sentence.substring(0, 1).toLowerCase())){
            throw new IllegalArgumentException("Must start with capital letter!");
        }

        if (sentence.charAt(sentence.length()-1) != '.' &&
                sentence.charAt(sentence.length()-1) != '!' &&
                sentence.charAt(sentence.length()-1) != '?'){
            throw new IllegalArgumentException("Must end with . ! or ?");
        }

        if (spaceCounter(sentence) >= 4){
            shortSentence = sentence.substring(0, findSpaceIndexes(sentence).get(0)) +
                    " ... " +
                    sentence.substring(findSpaceIndexes(sentence).get(findSpaceIndexes(sentence).size()-1));
        } else {
            shortSentence = sentence;
        }

        return shortSentence;
    }

    private int spaceCounter(String string){
        int counter = 0;
        for (Character c: string.toCharArray()){
            if (c == ' '){
                counter++;
            }
        }
        return counter;
    }

    private List<Integer> findSpaceIndexes (String string){
        List<Integer> indexes = new ArrayList<>();
        for (int i = 1; i < string.length() - 1; i++){
            if (string.charAt(i) == ' '){
                indexes.add(i);
            }
        }
        return indexes;
    }


}
