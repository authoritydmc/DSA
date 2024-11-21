class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int [] points=new int[101];

        for(List<Integer> num:nums)
        {
            for(int i=num.get(0);i<=num.get(1);i++)
                points[i]=1;
        }
        int count =0;
        for(int i=1;i<101;i++)
        {
            if(points[i]==1)    count++;
        }

        return count;
    }
}