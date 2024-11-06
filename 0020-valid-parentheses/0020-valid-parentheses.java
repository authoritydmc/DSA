class Solution {
    public boolean isValid(String s) {
        Stack <Character> stck=new Stack<>();
        for (char c:s.toCharArray())
        {
            System.out.println(c);
            if(c=='(' || c=='{' || c=='[')
            stck.push(c);
            else
            {

                if(stck.isEmpty())
                return false;
                char out=stck.pop();
                System.out.println("comparing "+out+" with "+c);
                if((out=='[' && c!=']'))
                return false;
                  if((out=='(' && c!=')'))
                return false;
                  if((out=='{' && c!='}'))
                return false;

            }

        }
        System.out.println("is stck empty"+stck.isEmpty());
        stck.stream().forEach(System.out::println);
            return stck.isEmpty();

    }
}