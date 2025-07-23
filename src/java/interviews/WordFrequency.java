package interviews;

import java.util.HashMap;

public class WordFrequency {
    /*
    Calculate the frequency of each word in a given string

    For simplicity sake, you may assume:

    Each word must consist of lowercase characters only.
    Ignore puntuaction characters and only take alphanumeric characters.
    Words are separated by one or more whitespace characters.

    String:
    Hello world from Mexico #23. Sometimes all you need is love, welcome from all the world.
    Just clean up this !$string of invalid characters. All you need is coding56.

     */

    public static void main(String[] args) {
        String s = "Hello world from Mexico #23. Sometimes all you need is love, welcome from all the world. Just clean up this !$string of invalid characters. All you need is coding 56 lines.";

        System.out.println(wordFrequency(s));

    }

    public static HashMap<String, Integer> wordFrequency(String s) {
        HashMap<String, Integer> wordMap = new HashMap<>();

        String lowercase = s.toLowerCase();
        String replaced = lowercase.replace("\s", " ");
        String replaced2 = replaced.replace("\t", " ");
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < replaced2.length(); i++) {
            Character character = replaced2.charAt(i);

            if (Character.isLetterOrDigit(character) || Character.isSpaceChar(character)) {
                sb.append(character);
            }
        }

        String[] words = sb.toString().split(" ");
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }

        return wordMap;
    }
}
