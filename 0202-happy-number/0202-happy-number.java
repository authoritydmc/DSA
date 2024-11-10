class Solution {

    private int getSum(int n)
    {
        //base cases 
        if (n==0)return 0;

        int rem=n%10;
        rem=rem*rem;
        return rem+getSum(n/10);
    }
    public boolean isHappy(int n) {
        Set<Integer> occuredPrev=new HashSet<>();
        //this is one pass ....
      while(!occuredPrev.contains(n))
      {
        occuredPrev.add(n);
        n=getSum(n);
     
      }
  return n==1;
    }
}