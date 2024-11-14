class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int mod=(int)(1e9+7);
        long[] fr = new long[26];
        for (char c : s.toCharArray())
            fr[c - 'a'] += 1;


        long ans=0;

        while(t-->0)
        {
            //for each run ...first count how many z are there as they will become a,b's freq

            long z_count=fr[25];
            long a_count=fr[0];

            //now shift all previous freq to freq+1 as they are increased except z's one

            for(int i=25;i>1;i--)
                fr[i]=fr[i-1];

            //now adjust the z's frequency to ab :
            //for a its same as z so

            fr[0]=z_count%mod;
            //for b it can be original a's freq +z_count
            fr[1]=(z_count+a_count)+mod;

        }

        //sum the frequency and return them 


        for(long frq:fr)
        {
            ans+=frq;
            ans=ans%mod;
        }

        return (int) ans%mod;

    }
}