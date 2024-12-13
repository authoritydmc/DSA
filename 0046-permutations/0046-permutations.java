class Solution {
    private void solve(int[] nums,  List<List<Integer>> lst, List<Integer> tempList,boolean[] used ) {

        // base case :: when goal is met
        if (tempList.size() == nums.length) {
            //
            lst.add(new LinkedList<>(tempList));
            // tempList.clear();
            return;
        }
        for (int index = 0; index < nums.length; index++) {
            // make choice

            if(used[index])
            continue;
            used[index]=true;
            tempList.add(nums[index]);
            // backtrack
            solve(nums,  lst, tempList,used);
            // undo choice
            tempList.remove(tempList.size() - 1);
            used[index]=false;
        }

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lst = new LinkedList<>();
        boolean[] used = new boolean[nums.length];

        solve(nums, lst, new LinkedList<Integer>(),used);

        return lst;
    }
}