class Solution {

    private String bruteSolve(String s, int[][] shifts) {
        char[] ch = s.toCharArray();

        for (int[] shift : shifts)
            for (int i = shift[0]; i <= shift[1]; i++) {
                if (shift[2] == 0) {
                    // shift backwards care for a to z
                    if (ch[i] == 'a')
                        ch[i] = 'z';
                    else
                        ch[i] -= 1;
                } else {
                    // shift forward care for z to a
                    if (ch[i] == 'z')
                        ch[i] = 'a';
                    else
                        ch[i] += 1;
                }

            }
        return new String(ch);
    }

    public String shiftingLetters(String s, int[][] shifts) {
        // return bruteSolve(s, shifts);
        return solveDiffArray(s, shifts);
    }

private String solveDiffArray(String s, int[][] shifts) {
    char[] ch = s.toCharArray();
    int[] diffArray = new int[s.length()];

    // Build the difference array
    for (int[] shift : shifts) {
        diffArray[shift[0]] += shift[2] == 1 ? 1 : -1;
        if (shift[1] + 1 < diffArray.length)
            diffArray[shift[1] + 1] -= shift[2] == 1 ? 1 : -1;
    }

    int cumShift = 0;
    for (int i = 0; i < diffArray.length; i++) {
        cumShift += diffArray[i];
        cumShift = cumShift % 26;  // Normalize shift within -25 to 25

        // Apply cumulative shift using if cases for wrap-around logic
        ch[i] += cumShift;
        if (ch[i] > 'z') {
            ch[i] = (char)('a' + (ch[i] - 'z' - 1));
        } else if (ch[i] < 'a') {
            ch[i] = (char)('z' - ('a' - ch[i] - 1));
        }
    }

    return new String(ch);
}

}