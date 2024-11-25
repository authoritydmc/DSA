class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String [] words=s.split(" ");
        System.out.println(Arrays.toString(words));
        StringBuilder str=new StringBuilder();
        for(int i=words.length-1;i>0;i--)
        {
            if(words[i].equals(""))
                continue;
            // System.out.println("adding ->"+words[i]+"<-");
            str.append(words[i]+" ");
        }
        str.append(words[0]);
        return str.toString();
    }
}