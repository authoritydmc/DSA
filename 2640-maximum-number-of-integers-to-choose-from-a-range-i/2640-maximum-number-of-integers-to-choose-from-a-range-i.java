class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        
        int cnt=0;
        Set<Integer> s=Arrays.stream(banned).boxed().collect(Collectors.toSet());
        int sum=0;
        for(int i=1;i<=n;i++)
        {
            if(s.contains(i))
                continue;
            if(sum+i>maxSum)
            break;
            sum+=i;
            cnt++;
        }
        return cnt;
    }
}