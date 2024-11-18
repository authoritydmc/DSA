class Solution {
    public String licenseKeyFormatting(String s, int k) {
        char[] keys = s.toUpperCase().toCharArray();
        int index = keys.length - 1;
        Stack<Character> stck = new Stack<>();
        int cnt = 0;
        while (index >=0) {
            char chr = keys[index--];
            if (chr == '-')
                continue;
            stck.push(chr);

            cnt++;
            System.out.println("At "+chr+" count is "+cnt);
            if (cnt == k) {
                // we have reached the breakpoint
                stck.push('-');
                cnt=0;
            }
        }
        if(!stck.isEmpty() && stck.peek()=='-')
        stck.pop();

        StringBuilder str=new StringBuilder();
        while(!stck.isEmpty())
        {
            str.append(stck.pop());
        }
        return str.toString();
    }
}