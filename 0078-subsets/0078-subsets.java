class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rslt = new ArrayList<>();
       
        rslt.add(new ArrayList<>());
        for (int n : nums) {

            List<List<Integer>> tempList = new ArrayList<>();
            for(List<Integer> prevList:rslt)
            {
                List<Integer> t=new ArrayList<>(prevList);
                t.add(n);
                tempList.add(t);
            }
            rslt.addAll(tempList);

        }
        return rslt;
    }
}