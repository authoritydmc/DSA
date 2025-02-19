class Solution {
    String ans = "";
    List<Character> allowed = List.of('a', 'b', 'c');

    private boolean gen(int len, int k, int [] cnt, StringBuilder cur) {

        if(len==cur.length())
        {
            cnt[0]++;
            // System.out.println("Generated of Length "+cur.toString()+ " its pos is "+cnt[0]);
            if(cnt[0]==k)
            {
                ans=cur.toString();
                return true;
            }
            return false;
        }
        

        for(char c:allowed)
        {
            //do()
            if(cur.length()>0 && cur.charAt(cur.length()-1)==c)
            continue;
            cur.append(c);

            //explore
           if( gen(len,k,cnt,cur))
           return true;

            //backtrack
            if(cur.length()>0)
            cur.deleteCharAt(cur.length()-1);
            
        }

        return false;
    }

    public String getHappyString(int n, int k) {
        gen(n,k,new int[1],new StringBuilder());
        return ans;
    }
}