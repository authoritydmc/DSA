class Solution {

    private int solve(int index, int[] days, int[] costs,int [] memo) {
        // Base case: if all days are processed, return 0
        if (index >= days.length) {
            return 0;
        }
        if(memo[index]!=-1)
        return memo[index];

        // Option 1: Buy a one-day pass
        int oneDay = costs[0] + solve(index + 1, days, costs,memo);

        // Option 2: Buy a weekly pass
        int nextIndex = index;
        while (nextIndex < days.length && days[nextIndex] < days[index] + 7) {
            nextIndex++;
        }
        int weekly = costs[1] + solve(nextIndex, days, costs,memo);

        // Option 3: Buy a monthly pass
        nextIndex = index;
        while (nextIndex < days.length && days[nextIndex] < days[index] + 30) {
            nextIndex++;
        }
        int monthly = costs[2] + solve(nextIndex, days, costs,memo);

        // Return the minimum of all three options
        int lowestCost= Math.min(oneDay, Math.min(weekly, monthly));
        memo[index]=lowestCost;
        return lowestCost;
    }

    public int mincostTickets(int[] days, int[] costs) {
        int [] memo=new int[days.length+19];
        Arrays.fill(memo,-1);
        return solve(0, days, costs,memo);
    }
}
