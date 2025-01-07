class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> res = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int strLen = word.length();
            for (int j = i + 1; j < words.length; j++) {

                if (isSubstring(word, words[j])) {
                    res.add(strLen<=words[j].length()?word:words[j]);
                    continue;
                }
            }

        }

        return new ArrayList<>(res);
    }

    private boolean isSubstring(String word, String word2) {
        return word.contains(word2) || word2.contains(word);
    }
}