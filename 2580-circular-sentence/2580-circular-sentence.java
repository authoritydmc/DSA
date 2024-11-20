class Solution {
    public boolean isCircularSentence(String sentence) {

        int n = sentence.length();

        if (sentence.charAt(0) != sentence.charAt(n - 1))
            return false;

        char prev = '-';
        boolean shouldMatch = false;

        for (char c : sentence.toCharArray()) {

            // System.out.println(c + " should match " + shouldMatch + " with  " + prev);
            if (shouldMatch) {

                if (c != prev)
                    return false;
                shouldMatch = false;
            }
            if (c == ' ') {
                // we have to match next word .....
                shouldMatch = true;
            }else

            prev = c;

        }

        return true;
    }
}