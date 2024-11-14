class Solution {

    private long solve(int[] eA, int[] eB, int hrs, char cur, int n, long[][] memo) {
        // base case
        if (hrs >= n)
            return 0;
        long energy = 0;
        int drinkIndex = cur == 'A' ? 0 : 1;
        if (memo[drinkIndex][hrs] != -1)
            return memo[drinkIndex][hrs];
        if (cur == 'A') {
            energy = eA[hrs] +
                    Math.max(
                            solve(eA, eB, hrs + 1, 'A', n, memo), solve(eA, eB, hrs + 2, 'B', n, memo));
        } else {
            energy = eB[hrs] +
                    Math.max(
                            solve(eA, eB, hrs + 1, 'B', n, memo), solve(eA, eB, hrs + 2, 'A', n, memo));
        }

        memo[drinkIndex][hrs] = energy;

        return energy;
    }

    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        long[][] memo = new long[2][n];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(memo[i], -1);
        }
        return Math.max(solve(energyDrinkA, energyDrinkB, 0, 'A', n, memo),
                solve(energyDrinkA, energyDrinkB, 0, 'B', n, memo));
    }
}