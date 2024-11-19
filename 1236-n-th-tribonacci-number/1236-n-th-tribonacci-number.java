class Solution {
    public int tribonacci(int n) {
        if(n<3)
        {
            return n==0?0:1;
        }
        int first=1;
        int second=1;
        int third=0;
        int temp;
        for(int i=3;i<=n;i++)
        {

            temp=first;
            first=first+second+third;
            third=second;
            second=temp;
        }
        return first;
    }
}