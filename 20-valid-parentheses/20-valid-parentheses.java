class Solution {
    
      public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();
        //System.out.println("heyyy");
        for (char c : s.toCharArray()) {
           // System.out.println("processing " + c);

            if ('{' == c || '[' == c || '(' == c ) {
                //System.out.println("hert " + c);
                stack.push(c);
            } else {
                if(stack.empty())
                    return false;
                Character last = stack.pop();

                if ( last.equals('{') &&  '}' != c) {
                    return false;
                } else  if ( last.equals('[') &&   ']' != c) {
                    return false;
                }  else if ( last.equals('(') &&  ')' != c) {
                    return false;
                }

            }


        }
          return stack.empty();

    }
}