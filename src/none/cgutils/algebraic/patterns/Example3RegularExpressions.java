package none.cgutils.algebraic.patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example3RegularExpressions {

    // Regular expression to find a 'q'
    private static final String FIND_Q = "(.+)q.*";

    public static void main(String[] args) {

        String allAlphabets = "Amazingly few discotheques provide jukeboxes.";

        // Create a Pattern instance
        Pattern findQPattern = Pattern.compile(FIND_Q);

        // Execute the pattern via a matcher
        Matcher matcher = findQPattern.matcher(allAlphabets);

        if(matcher.find()) {

            String beforeQMatch = matcher.group(1);

            // Get the offset after the match
            int afterQMatchEnd = matcher.end(1);

            // If there are more characters after offset, get them
            String afterQMatch =
                    (afterQMatchEnd < (allAlphabets.length() - 1)) ?
                    allAlphabets.substring(afterQMatchEnd + 1) : "";

            System.out.println("beforeQMatch = [" + beforeQMatch + "]");
            System.out.println("afterQMatch = [" + afterQMatch + "]");
        }
    }
}