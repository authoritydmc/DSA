class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();

        // process and count each word occurence
        for (String word : paragraph.split("[\\s,\\.!?';]")) {
            if(word=="")
            continue;
          String  inWord=word.toLowerCase();
          System.out.println("for "+inWord);
            map.put(inWord, map.getOrDefault(inWord, 0) + 1);
        }
        // store in list and sort in descending order
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

    list.stream().forEach(e->System.out.println(e.getKey()+"->"+e.getValue()));
    // Convert array to HashSet for fast lookups
        Set<String> bannedWordSet = new HashSet<>(Arrays.asList(banned));
        for (Map.Entry<String, Integer> entry : list) {
            if(!bannedWordSet.contains(entry.getKey()))
            return entry.getKey();
        }
    return "";
    }
}