package interviews;

public class InterleaveStrings {
        /*

        Create a method to interleave two Strings.
        The method will take two Strings as input parameters and will output a String.
        The method will take the first two characters from the first String and append it to one
        character from the second String until one or both Strings no longer have enough characters
        to provide 2 or 1 character and return the String.

        ---------------------------------------------------------------------------
        Example:

        String str1 = "ABCDEFG";
        String str2 = "MNOPQRS";

        Output = "ABMCDNEFO"
        */

    public static void main(String[] args) {

        String str1 = "ABCDEFG";
        String str2 = "MNOPQRS";

        System.out.println(handleStrings(str1, str2));
    }

    public static String handleStrings(String string1, String string2){
        if(string1.length()<2 || string2.length()<1 ){
            return "";
        }

        StringBuilder sb=new StringBuilder();
        int str2Index=0;

        for(int i=0; i<string1.length();i=i+2){
            if(i+2>string1.length() || str2Index>string2.length()-1){
                return sb.toString();
            }

            sb.append(string1.substring(i, i + 2)).append(string2.charAt(str2Index));
            str2Index++;
        }

        return sb.toString();
    }
}
