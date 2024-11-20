class Solution {
    public int takeCharacters(String s, int k) {

        if (k==0)
        return 0;

        int n = s.length();
        int right = 0;
        int left = 0;
        int maxWindowSize = 0;
        int curWinSize = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray())
            map.merge(c, 1, Integer::sum);
        
        if(map.getOrDefault('a',Integer.MIN_VALUE)<k)
            return -1;
                if(map.getOrDefault('b',Integer.MIN_VALUE)<k)
            return -1;
                    if(map.getOrDefault('c',Integer.MIN_VALUE)<k)
            return -1;

        // we will use left and right two pointers
        while (right < n) {
            char c = s.charAt(right);
            // remove the right pointer character .i.e we consider this in our non deleted
            // window so
            int newFrq = map.merge(c, -1, Integer::sum);
            if (newFrq < k) {
                // this means if we decided not to delete this character then we have
                // essentially reduced k count of atleast required deleted character ..
                // hence we have to shrink our window ....
                while (left <=right) {
                    // shrinking means we will delete or take that charcet thus increasing thoier
                    // count
                    char addBak = s.charAt(left++);
                    map.merge(addBak, 1, Integer::sum);
                    // check if for c at right do we have valid
                    if (map.get(c) >= k)
                        break;
                }
            } else {
                curWinSize = right - left+1;
                // System.out.println("at left " + left + " right " + right + " cur Win size " + curWinSize);
                maxWindowSize = Math.max(maxWindowSize, curWinSize);
            }
            // we have increased our window size ...

            right++;

        }
        return  n - maxWindowSize ;
    }
}