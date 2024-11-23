class Trie {

    TrieNode root;

    public Trie() {
        root=new TrieNode();
    }

    public void insert(String word) {

        // word=word.toLowerCase();
        // System.out.println(word);
        TrieNode current=root;
        for(char c:word.toCharArray())
        {
            int index=c-'a';
            if(current.children[index]==null)
            {
                //this is null we need to create and assign new node here
                TrieNode node=new TrieNode();
                current.children[index]=node;
            }
            current=current.children[index];
        }
        //mark end of word
        current.isWord=true;
    }

    public boolean search(String word) {
        TrieNode current=root;
        for(char c:word.toCharArray())
        {
            int index=c-'a';
            if(current.children[index]==null)
            {
                //we dont have valid prefix here break
                return false;
            }
            current=current.children[index];

        }

        return current.isWord;
    }

    public boolean startsWith(String prefix) {
             TrieNode current=root;
        for(char c:prefix.toCharArray())
        {
            int index=c-'a';
            if(current.children[index]==null)
            {
                //we dont have valid prefix here break
                return false;
            }
            current=current.children[index];

        }

        return true;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isWord = false;

    public TrieNode()

    {
        children = new TrieNode[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */