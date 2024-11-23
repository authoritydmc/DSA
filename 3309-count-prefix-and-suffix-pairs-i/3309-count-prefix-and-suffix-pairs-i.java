class Solution {

    private TrieNode getPrefix(String word) {

        TrieNode root = new TrieNode();
        TrieNode current = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                TrieNode node = new TrieNode();
                current.children[index] = node;
            }
            current = current.children[index];
        }
        current.isWord = true;
        return root;
    }

    private TrieNode getSuffix(String word) {
        TrieNode root = new TrieNode();
        TrieNode current = root;

        for (int i = word.length() - 1; i >= 0; i--) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                TrieNode node = new TrieNode();
                current.children[index] = node;
            }
            current = current.children[index];
        }
        current.isWord = true;
        return root;
    }

    private boolean validatePrefix(TrieNode root,String word)
    {
        TrieNode current=root;
        for(char c:word.toCharArray())
        {
            int index=c-'a';
            if(current.children[index]==null)
             return false;
            current=current.children[index];
        }
        return true;
    }

     private boolean validateSuffix(TrieNode root,String word)
    {
        TrieNode current=root;
        for(int i=word.length()-1;i>=0;i--)
        {   

            int index=word.charAt(i)-'a';
            if(current.children[index]==null)
             return false;
            current=current.children[index];
        }
        return true;
    }

    private boolean isPrefixAndSuffix(String word1, String word2, Map<String, TrieNode[]> triesMap) {
        TrieNode prefixTrie=triesMap.get(word2)[0];
        TrieNode suffixTrie=triesMap.get(word2)[1];
        boolean res= validatePrefix(prefixTrie,word1)&&validateSuffix(suffixTrie,word1);
        // System.out.println("Currently validating "+word1+" against "+word2+" res "+res);
        return res;

    }

    public int countPrefixSuffixPairs(String[] words) {
        Map<String, TrieNode[]> triesMap = new HashMap<>();
        // for each word build thier both prefix and suffix tries
        for (String word : words) {
            TrieNode prefixTrie = getPrefix(word);
            TrieNode suffixTrie = getSuffix(word);
            TrieNode[] tries = new TrieNode[2];
            tries[0] = prefixTrie;
            tries[1] = suffixTrie;
            triesMap.put(word, tries);
        }

        // now n^2 comparison for comparing and count all valids pairs

        int valid_pairs = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j], triesMap))
                    valid_pairs += 1;
            }
        }

        return valid_pairs;
    }

}

class TrieNode {
    TrieNode[] children;
    boolean isWord = false;

    public TrieNode() {
        children = new TrieNode[26];
    }
}