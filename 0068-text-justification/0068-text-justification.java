import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int count = 0;
        List<String> result = new ArrayList<>();
        List<String> tempList = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            count += word.length() + 1; // Add word length and a space

            if (count > maxWidth + 1) { // Overshoot check
                count -= word.length() + 1; // Remove the current word length and space
                result.add(formatLine(tempList, count - tempList.size(), maxWidth)); // Format the previous line
                tempList = new ArrayList<>(); // Reset temporary list for next line
                count = word.length() + 1; // Reset count for current word
            }
            tempList.add(word); // Add current word to temporary list
        }

        // Handle the last line
        if (!tempList.isEmpty()) {
            result.add(formatLastLine(tempList, maxWidth));
        }

        return result;
    }

  
    private String formatLine(List<String> words, int size, int maxWidth) {
        int spacesNeeded = maxWidth - size; // Remaining spaces to distribute
        int gaps = words.size() - 1; // Number of gaps between words

        if (gaps == 0) { // Single word, left-justify
            return words.get(0) + " ".repeat(spacesNeeded);
        }

        // Distribute spaces evenly and handle extra spaces
        int spacesPerGap = spacesNeeded / gaps;
        int extraSpaces = spacesNeeded % gaps;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            sb.append(words.get(i));
            if (i < gaps) { // Add spaces after each word except the last
                sb.append(" ".repeat(spacesPerGap));
                if (extraSpaces > 0) {
                    sb.append(" "); // Add an extra space for uneven distribution
                    extraSpaces--;
                }
            }
        }

        return sb.toString();
    }

  
    private String formatLastLine(List<String> words, int maxWidth) {
        StringBuilder sb = new StringBuilder(String.join(" ", words)); // Join words with single spaces
        while (sb.length() < maxWidth) {
            sb.append(" "); // Pad with spaces to the right
        }
        return sb.toString();
    }


}
