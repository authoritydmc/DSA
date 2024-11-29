class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // have a list to hold all subsets possible ...
        List<List<Integer>> rslt = new ArrayList<>();
        // initially add a empty list
        rslt.add(new ArrayList<>());
        // now for each number :::
        for (int n : nums) {
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
                tempList.add(t);
            }
            // finally once all possible subset for this number is generated we can safely
            // add it to result ..
            rslt.addAll(tempList);

        }
        return rslt;
    }
}