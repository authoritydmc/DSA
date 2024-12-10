class Solution {
    public int maximumLength(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder str=new StringBuilder();
            for(int j=i;j<s.length();j++)
            {
            if(str.isEmpty() || str.charAt(str.length()-1)==s.charAt(j)){
            str.append(s.charAt(j));
            map.merge(str.toString(),1,Integer::sum);
            }else
            break;
        }
        }
        // now find the length of 3 plus above valued keys::
        int answer=-1;
        for(String key:map.keySet())
        {
            //valid candidates
            if(map.get(key)>2)
            {
                answer=Math.max(answer,key.length());
            }
        }
        return answer;
    }
}
