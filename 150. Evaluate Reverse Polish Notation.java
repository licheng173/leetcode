public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++) {
            String st = tokens[i];
            if(st.equals("*") ||st.equals("/")||st.equals("+")||st.equals("-")) {
                int second = Integer.valueOf(stack.pop());
                int result = 0;
                int first = Integer.valueOf(stack.pop());
                if(st.equals("*")) result = second * first;
                if(st.equals("/")) result = first / second;
                if(st.equals("+")) result = first + second;
                if(st.equals("-")) result = first - second;
                stack.push(String.valueOf(result));
            }
            else {
                stack.push((st));
            }
        }
        return Integer.valueOf(stack.pop());
    }
}