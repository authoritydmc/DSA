class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> seenSet = new HashSet<>();

        // have a list to hold all subsets possible ...
        List<List<Integer>> rslt = new ArrayList<>();
        // initially add a empty list
        List<Integer> emptyList = new ArrayList<>();
        rslt.add(emptyList);
        seenSet.add(emptyList);
        // now for each number :::
        for (Integer n : nums) {
            // create a Temporary List to hold to all intermediate subsets ..as adding
            // directly to result list will cause below loop to not function properly...
            List<List<Integer>> tempList = new ArrayList<>();
            for (List<Integer> prevList : rslt) {
                // do not modify the prevList for the same reason ..instead we are creating new
                // subset possible
                List<Integer> t = new ArrayList<>(prevList);
                // add the number
                t.add(n);
                // add this subset to temporary list
                if (seenSet.contains(t))
                    continue;
                seenSet.add(t);

                tempList.add(t);
            }
            // finally once all possible subset for this number is generated we can safely
            // add it to result ..
            rslt.addAll(tempList);

        }
        return rslt;
    }
}