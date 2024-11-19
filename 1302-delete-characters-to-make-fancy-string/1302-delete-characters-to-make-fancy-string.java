class Solution {
    public String makeFancyString(String s) {
        StringBuilder str=new StringBuilder();

        int count=0;
        char prev='-';
        for(char ch:s.toCharArray())
        {
            //case ch and prev are same
            if(ch==prev)
            {
                 count++;

                //if count is less than 3 then only insert 
                if(count<3)
                 {
                    str.append(ch);
                 }
            }else
            {
                str.append(ch);
                count=1;
            }


            prev=ch;
        }


        return str.toString();
    }
}