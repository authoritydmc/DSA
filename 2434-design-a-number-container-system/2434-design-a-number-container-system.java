class NumberContainers {
    Map<Integer, TreeSet<Integer>> numMap;
    Map<Integer, Integer> indexMap;

    public NumberContainers() {
        numMap = new HashMap<>();
        indexMap = new HashMap<>();

    }

    public void change(int index, int number) {
        if (indexMap.containsKey(index)) {
            // index is not empty replacement required:
            int prevNum = indexMap.get(index);
            // remove it from previous number map
            numMap.get(prevNum).remove(index);
        }
        indexMap.put(index, number);
        numMap.putIfAbsent(number, new TreeSet<>());
        numMap.get(number).add(index);
    }

    public int find(int number) {
         if (numMap.containsKey(number) && !numMap.get(number).isEmpty()) {
            return numMap.get(number).first(); // Retrieve smallest index in O(1)
        }
    
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */