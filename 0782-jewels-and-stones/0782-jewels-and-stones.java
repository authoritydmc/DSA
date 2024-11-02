class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : stones.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int ans = 0;
        for (char j : jewels.toCharArray()) {
            ans += map.getOrDefault(j,0);
        }

        return ans;
    }
}