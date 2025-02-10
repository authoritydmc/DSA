class Solution {
    public String clearDigits(String s) {
        Stack<Character> stck = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                if (!stck.isEmpty())
                    stck.pop();
            } else
                stck.push(c);

        }
        char[] strs = new char[stck.size()];

        int start = stck.size() - 1;
        while (!stck.isEmpty())
            strs[start--] = stck.pop();

        return new String(strs);
    }
}