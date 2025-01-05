class Solution {
    public String shiftingLetters(String s, int[] shifts) {

        int cum_sum = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            cum_sum += shifts[i];
            // System.out.println("at present cum_sum is "+cum_sum);
            cum_sum =cum_sum% 26;
            shifts[i] = cum_sum;
        }
        // System.out.println("new " + Arrays.toString(shifts));
        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            // System.out.println("before applying "+ch[i]);
            ch[i]+=shifts[i];
            // System.out.println("After applying "+ch[i]+" code "+(int)ch[i]);
            if(ch[i]>'z')
            {
                int diff=ch[i]-'z';
                // System.out.println(" diff is "+diff);
                ch[i]=(char)('a'+(ch[i]-'z')-1);

            }
        }

        return new String(ch);
    }
}