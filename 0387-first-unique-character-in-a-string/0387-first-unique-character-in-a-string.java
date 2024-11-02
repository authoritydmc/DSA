class Solution {
    public int firstUniqChar(String s) {
        Map<Character,List<Integer>> map=new LinkedHashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char x=s.charAt(i);
               map.putIfAbsent(x, new ArrayList<>());
            // Add the index of the character to the list
            map.get(x).add(i);
        }

         Optional<Map.Entry<Character, List<Integer>>> rslt =map.entrySet().stream().filter(entry -> entry.getValue().size()==1).findFirst();
        if(rslt.isPresent())
        return rslt.get().getValue().get(0);
        return -1;
    }
}