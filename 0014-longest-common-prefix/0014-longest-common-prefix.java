class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder str = new StringBuilder();
        int index = 0;
        char c;
        while(true)
        {   
            if(index>=strs[0].length())return str.toString();
            c=strs[0].charAt(index);
        for (int i =1;i<strs.length;i++) {
            //if current string ends that means we can no longer find common prefixes as one of the string is fully consumed
            if(index>=strs[i].length() )return str.toString();
           if(c!=strs[i].charAt(index))
           return str.toString();
           

        }
        str.append(c);
        index++;
        }


    }
}