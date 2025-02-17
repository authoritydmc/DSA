import java.util.HashSet;
import java.util.Set;

class Solution {

    private void backtrack(String s, String cur, boolean[] used, Set<String> uniqueWords) {

        for (int i = 0; i < s.length(); i++) {
            if (used[i])
                continue; // Skip used characters

            used[i] = true;
            String newWord = cur + s.charAt(i);

            uniqueWords.add(newWord);

            // Explore further
            backtrack(s, newWord, used, uniqueWords);

            // Backtrack
            used[i] = false;
        }

        return;
    }

    public int numTilePossibilities(String tiles) {
        boolean[] used = new boolean[tiles.length()];
        Set<String> uniqueWords = new HashSet<>(); // To track unique sequences
        backtrack(tiles, "", used, uniqueWords);

        return uniqueWords.size();
    }

}
