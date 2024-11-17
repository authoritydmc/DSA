class Solution {

    private int [] lpsArray(char [] needle)
    {
        int length=0;
        int [] lps=new int [needle.length];
        int n=needle.length;
        int i=1;
        while(i<n)
        {
            if(needle[i]==needle[length])
            {
                //we have found matching pattern 
                length++;
                lps[i]=length;
                i++;
            }else
            {
                //mismatch occured .....
                if(length!=0)
                {
                    length=lps[length-1];
                }else
                {
                   
                    lps[i]=0;
                    i++;
                }
            }
        }
         
        // Final LPS array after processing
        System.out.println("Final LPS array: " + java.util.Arrays.toString(lps));
        return lps;
    }
    public int strStr(String haystack, String needle) {
        
        int [] lps=lpsArray(needle.toCharArray());
        int n=needle.length();
        int ind=0;
        for(int i=0;i<haystack.length();i++)
        {
            char ch=haystack.charAt(i);
            char patch=needle.charAt(ind);
            if(ch==patch)
            {
                if(ind==n-1)
                return i-n+1;
                ind++;
            }else
            {   
            System.out.println("wrong mismatch at  i "+i +" index "+ind + " ch :"+ch+" patch "+patch);

                if(ind==0)
                    ind=0;
                else
                {
                    ind=lps[ind-1];
                    i=i-1;
                        System.out.println("as per lps set ind to "+ind);
                }
               
            }
        }
        return -1;
    }
}