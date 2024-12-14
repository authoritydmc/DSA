class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] res = new int[temperatures.length];

        // monotonic stack to be used ::
        Stack<Integer> stack = new Stack<>();
        int index=temperatures.length-1;

        while(index>=0)
        {
            int curTemp=temperatures[index];
            while(!stack.isEmpty() && curTemp>=temperatures[stack.peek()])
            {
                stack.pop();
            }


            res[index]=stack.isEmpty()?0:stack.peek()-index;
            stack.push(index);
            index--;
        }
        return res;
    }
}