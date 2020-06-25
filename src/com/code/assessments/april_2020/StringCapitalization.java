package code.assessments.april_2020;

import java.util.Objects;

/**
 * 19/4/2020
 *
 * */
public class StringCapitalization {

    public static void main(String[] args) {
        String phrase = args[0]; //"The mascot was blue";

        StringBuilder result = new StringBuilder();

        if (Objects.isNull(phrase) || phrase == "")
            return;

        char[] parsedChars = phrase.toCharArray();
        for (int i=0 ; i< parsedChars.length; i++) {
            if(i == 0 || parsedChars[i-1] == ' '){
                parsedChars[i] = Character.toUpperCase(parsedChars[i]);
            }
        }
        System.out.println(new String(parsedChars));
    }
}
