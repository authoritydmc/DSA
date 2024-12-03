class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder str=new StringBuilder();

        int index=0;
        for(int i=0;i<s.length();i++)
        {
            if(index <spaces.length && spaces[index]==i)
            {
                str.append(" ");
                index++;
            }
            str.append(s.charAt(i));
        }

        return str.toString();

    }
}