class Solution {

    private int bitCount(int n) {
        int cnt = 0;
        while (n > 0) {
            if ((n & 1) == 1)
                cnt++;
            n = n >> 1;
        }
        return cnt;
    }

    public int minimizeXor(int num1, int num2) {
        int ans = num1;
        int bitCnt = bitCount(num2);
        // System.out.println(" No of set bit in num2 is " + bitCnt + " compare " + Integer.bitCount(num2));

        if (bitCount(ans) > bitCnt) {
            // unset from LSB
            int i=0;
            while(bitCount(ans)!=bitCnt)
            {
                int x=1<<i;
                x=~x;
                ans=ans&x;
                i++;
            }
        } else {
            // set from LSB
            int i=0;
             while(bitCount(ans)!=bitCnt)
            {
                int x=1<<i;
                ans=ans|x;
                i++;
                
            }
        }

        return ans;
    }
}