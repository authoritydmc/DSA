class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> map=new HashMap<>();

        List<String> rslt=new ArrayList<>();
        for(String domain:cpdomains)
        {
            String [] splt=domain.split(" ");
            int addCount=Integer.parseInt(splt[0]);
            // System.out.println("domain "+domain+" add "+addCount+" "+splt[1]);
            String [] alldomains=splt[1].split("\\.");

            

            for(int i=0;i<alldomains.length;i++)
            {
                StringBuilder str=new StringBuilder(alldomains[i]);
                for(int j=i+1;j<alldomains.length;j++)
                {
                    str.append("."+alldomains[j]);
                }
                map.put(str.toString(),map.getOrDefault(str.toString(),0)+addCount);
            }
        }

        for(Map.Entry<String,Integer> me : map.entrySet())
        {
            rslt.add(me.getValue()+" "+me.getKey());

        }
        return rslt;

    }
}