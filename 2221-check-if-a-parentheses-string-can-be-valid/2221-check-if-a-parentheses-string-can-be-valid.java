class Solution {
    private boolean solve(String s, String locked) {
        if (s.length() % 2 != 0)
            return false;
        char[] lck = locked.toCharArray();
        char[] str = s.toCharArray();
        Stack<Integer> fixed = new Stack<>();
        Stack<Integer> dynamic = new Stack<>();

        for (int i = 0; i < str.length; i++) {
            if (lck[i] == '1') {
                // no option to change
                if (str[i] == '(') {
                    fixed.push(i);
                } else {
                    // we need to match this closing to previous open bracked ::
                    // if both stack is empty no way we can fix this
                    if (fixed.isEmpty() && dynamic.isEmpty())
                        return false;

                    if (!fixed.isEmpty()) {
                        fixed.pop();
                        continue;
                    }
                    dynamic.pop();
                }
            } else {
                // dynamic stack >...
                dynamic.add(i);
            }
        }

        while(!dynamic.isEmpty() && !fixed.isEmpty())
        {
            //
            if(fixed.peek()>dynamic.peek())
            return false;
            fixed.pop();
            dynamic.pop();
        }
        return fixed.isEmpty();
    }

    public boolean canBeValid(String s, String locked) {
        return solve(s, locked);
    }
}