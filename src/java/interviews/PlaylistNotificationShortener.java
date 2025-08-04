package interviews;
/**
 * Codility exercise for playlist .com
 * ---------------------------------------------------------------------------
 * Given a message string and an integer K, return a shortened version of the message:
 *
 * If the message fits in K characters, return it as is.
 *
 * Otherwise, cut the message by full words, and append " ..." (with a space) so that the total length is ≤ K.
 *
 * If no word fits, return "...".
 * ---------------------------------------------------------------------------*
 * Example 1:
 * <p>
 * For message = "And now here is my secret" and K = 15, the function should return
 * "And now ..." as explained above.
 * ---------------------------------------------------------------------------*
 * Example 2:
 * <p>
 * For message = "There is an animal with four legs" and K = 15, the function should return
 * "There is an ...".
 * ---------------------------------------------------------------------------*
 * Example 3:
 * <p>
 * For message = "super dog" and K = 4, the function should return "...".
 * ---------------------------------------------------------------------------*
 * Example 4:
 * <p>
 * For message = "how are you" and K = 20, the function should return "how are you".
 * ---------------------------------------------------------------------------*

 * Assume that:
 * -K is an integer within the range [3..500];
 * -The length of string message is within the range [1..500];
 * -String message is made of English letters ('a'–'z', 'A'–'Z') and spaces (' ');
 * -message does not contain spaces at the beginning or at the end;
 * -Words are separated by a single space (there are never two or more consecutive spaces).
 */
public class PlaylistNotificationShortener {
    public static void main(String[] args){
        System.out.println(solution2("And now here is my secret", 15));  // And now ...
        System.out.println(solution2("There is an animal with four legs", 15)); // There is an ...
        System.out.println(solution2("super dog", 4)); // ...
        System.out.println(solution2("how are you", 20)); // how are you
        System.out.println(solution2("a aa aaa", 6)); // a ...
        System.out.println(solution2("a a a a a a", 5)); //a ... <--breaks my solution

    }

    //code sent, wrong approach... Unknown test cases failed
    // according to chad, my code breaks with this case... because of replace
    // which replaces all coincidences... so having repeated words breaks it
    public static String solution(String message, int K) {
        String[] words=message.split(" ");

        StringBuilder sb=new StringBuilder(words[0]);

        if(sb.length()>K){
            return "...";
        }

        for (int i=1; i<words.length;i++){
            sb.append(" ").append(words[i]);

            int reverseIndex=i;
            while(sb.length()>K){
                String temp=sb.toString();
                String temp1=sb.toString().replace(" ...","");
                String temp2=temp1.replace(words[reverseIndex],"...");

                sb=new StringBuilder(temp2);
                reverseIndex--;
            }

        }

        return sb.toString();
    }

    //solution provided for chad
    public static String solution2(String message, int K) {
        if (message.length() <= K) {
            return message;
        }

        String[] words = message.split(" ");
        StringBuilder result = new StringBuilder();
        int currentLength=0;

        for (String word : words) {
            int projectedLength= ((currentLength==0? "":" ") + word+" ...").length();
            int totalLength= projectedLength+currentLength;
            if (totalLength > K) {
                break;
            }

            result.append(currentLength==0? "":" ");
            result.append(word);
            currentLength=result.length();
        }

        if (result.length() == 0) {
            return "...";
        }

        return result + " ...";
    }


}
