class Solution {
    public String sortVowels(String s) {
        StringBuilder rslt = new StringBuilder();
        List<Integer> vowelIndex=new ArrayList<>();
        List<Character> vowelList=new ArrayList<>();
        Set<Character> vowels=Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        for(int i =0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(vowels.contains(c))
            {
                vowelIndex.add(i);
                vowelList.add(c);
                rslt.append('#');
            }else
            {
                rslt.append(c);
            }
        }
        Collections.sort(vowelList);
        int i=0;
        for(int index:vowelIndex)
        {
            rslt.setCharAt(index,vowelList.get(i++));
        }
        return rslt.toString();
    }
}