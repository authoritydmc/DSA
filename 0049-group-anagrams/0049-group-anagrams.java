class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> freq = new HashMap<>();
        for (String s : strs) {
            String key = sortString(s);
            freq.putIfAbsent(key, new LinkedList<>());
            freq.get(key).add(s);
        }
        List<List<String>> rslt = new ArrayList<>();
        for (List<String> val : freq.values()) {
                rslt.add(val);
        }

        return rslt;

    }

      public static String sortString(String str) {
        // Convert the string to a character array
        char[] charArray = str.toCharArray();

        // Sort the character array
        Arrays.sort(charArray);

        // Create and return a new sorted string
        return new String(charArray);
    }
}