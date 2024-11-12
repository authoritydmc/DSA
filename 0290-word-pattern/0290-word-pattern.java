class Solution {
    public boolean wordPattern(String pattern, String s) {
        int pin=0;
        HashMap<String,Character> bound=new HashMap<>();
        HashSet<Character> pUsed=new HashSet<>();
        for(String str:s.split(" "))
        {
            //pattern is empty hence cant match 
            if(pin>=pattern.length())return false;

            char bounded=bound.getOrDefault(str,'A');
            if(bounded=='A')
            {   
                char patternWord=pattern.charAt(pin++);
                if(pUsed.contains(patternWord)) return false;
                bound.put(str,patternWord);
                pUsed.add(patternWord);
            }
            else
            {
                //we have found previous binding
                char patternWord=pattern.charAt(pin++);

                if(patternWord!=bounded)return false;
            }
        }
        return pin==pattern.length();
    }
}