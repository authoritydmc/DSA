class Solution {
    public int findChampion(int n, int[][] edges) {
        boolean[] nodes = new boolean[n];
        for (int[] edge : edges) {
            nodes[edge[1]] = true;
        }
        int count = 0;
        int team = -1;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == false) {
                count++;
                team = i;
            }
            if (count > 1) {
                return -1;
            }
        }
        return team;
    }
}