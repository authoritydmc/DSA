class Solution {
    public String stringHash(String s, int k) {
        StringBuilder rslt = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum+=s.charAt(i)-'a';

            if ((i + 1) % k == 0) {
                // we have reached one set of string
                System.out.println("Reached boundary "+sum);
                int hashedChar=sum%26;
                char chr=(char)('a'+hashedChar);

                rslt.append(chr);
                sum=0;
            }
        }

        return rslt.toString();
    }
}