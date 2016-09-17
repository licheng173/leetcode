public class Solution {
    public List<String> generateParenthesis(int n){
            Stack<String> stack = new Stack<String>();
            //stack.push("(");
            String start = "";
            List<String> l = new ArrayList<String>();
            generate(l, stack, start, 0, n);
            return l;
        }

    public void generate(List<String> list, Stack<String> stack, String str, int count, int n) {
        if(count == n && stack.isEmpty()) {
            list.add(str);
            return;
        }
        if(count < n) {
            String s = str + "(";
            stack.push("(");
            Stack<String> copy = new Stack<>();
            copy.addAll(stack);
            generate(list, copy, s, count + 1, n);
            stack.pop();
        }
        String p = "";
        if(!stack.isEmpty()) {
            p = str + ")";
            stack.pop();
        }
        if(p != "") {
            generate(list, stack, p, count, n);
        }
    }
}