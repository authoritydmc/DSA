class Solution {
    public int maxScore(String s) {
        int[][] score = new int[s.length()][2];
        if (s.charAt(0) == '0')
            score[0][0] = 1;
        else
            score[0][1] = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                score[i][0] = score[i - 1][0] + 1;
                score[i][1] = score[i - 1][1];
            } else {
                score[i][0] = score[i - 1][0];
                score[i][1] = score[i - 1][1] + 1;
            }
        }

        int res = 0;
        int total_one=score[score.length-1][1];
        // total_one=total_one==0?-1:total_one;
        for(int i=0;i<s.length()-1;i++)
        {
            int zeroes=score[i][0];
            int ones=score[i][1];
            int totalOneOnRight=total_one-ones;
            res=Math.max(res,zeroes+totalOneOnRight);
        }

        return res;
    }
}