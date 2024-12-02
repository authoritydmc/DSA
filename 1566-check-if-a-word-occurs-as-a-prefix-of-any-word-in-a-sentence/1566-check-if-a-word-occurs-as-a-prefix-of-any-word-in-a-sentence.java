class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
       Tries trie=new Tries();
        trie.makeTrie(sentence.split(" "));
       return trie.isWordPrefix(searchWord);
    }
}

class Tries {
    private TrieNode root = new TrieNode();

    public void makeTrie(String[] words) {
        int count=1;
        for (String word : words) {
            // System.out.println("Word is "+word);
            TrieNode cur = root;
            if (word == " ")
                continue;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if(cur.children[index]==null)
                {
                    TrieNode temp=new TrieNode();
                    temp.index=count;
                    cur.children[index]=temp;
                }
                cur=cur.children[index];
                cur.index=Math.min(cur.index,count);
            }
            //mark word is complete :
            cur.isWord=true;
            //also set the position ::::
            cur.index=count;
            count++;
        }
    }

    public int isWordPrefix(String prefix) {
 
        TrieNode cur=root;
        for(char c:prefix.toCharArray())
        {
            int index=c-'a';
            if(cur.children[index]==null)
            return -1;
            cur=cur.children[index];
        }
        return cur.index;
    }
}

class TrieNode {
    boolean isWord;
    TrieNode[] children;
    // it denotes which index the word belong too....
    int index;

    public TrieNode() {
        isWord = false;
        children = new TrieNode[26];
        index = -1;
    }
}