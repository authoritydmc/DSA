import java.util.HashSet;
import java.util.Set;

class Solution {

    private void backtrack(String s, StringBuilder cur, boolean[] used, Set<String> uniqueWords) {

        for (int i = 0; i < s.length(); i++) {
            if (used[i])
                continue; // Skip used characters

            used[i] = true;
            cur.append(s.charAt(i));

            uniqueWords.add(cur.toString());

            // Explore further
            backtrack(s, cur, used, uniqueWords);

            // Backtrack
            used[i] = false;
            cur.deleteCharAt(cur.length() - 1);
        }

        return;
    }

    public int numTilePossibilities(String tiles) {
        boolean[] used = new boolean[tiles.length()];
        Set<String> uniqueWords = new HashSet<>(); // To track unique sequences
        backtrack(tiles, new StringBuilder(), used, uniqueWords);

        return uniqueWords.size();
    }

}
