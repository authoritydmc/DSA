class Solution {

    public int numWays(String[] words, String target) {
        int wordLength = words[0].length();
        int targetLength = target.length();
        final int MOD = 1000000007;

        int[][] charFrequency = new int[wordLength][26];
        for (String word : words) {
            for (int j = 0; j < wordLength; ++j) {
                charFrequency[j][word.charAt(j) - 'a']++;
            }
        }

        Long[][] memo = new Long[wordLength][targetLength];
        return (int) countWays(0, 0, charFrequency, target, memo, MOD);
    }

    private long countWays(int currWord, int currTarget, int[][] charFrequency, String target, Long[][] memo, int MOD) {
        if (currTarget == target.length()) {
            return 1;
        }

        if (currWord == charFrequency.length) {
            return 0;
        }

        if (memo[currWord][currTarget] != null) {
            return memo[currWord][currTarget];
        }

        long ways = countWays(currWord + 1, currTarget, charFrequency, target, memo, MOD);
        int curPos = target.charAt(currTarget) - 'a';
        ways += (charFrequency[currWord][curPos] * countWays(currWord + 1, currTarget + 1, charFrequency, target, memo, MOD)) % MOD;
        ways %= MOD;

        return memo[currWord][currTarget] = ways;
    }
}
