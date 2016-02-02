public class Solution {
    public boolean isValid(String s) {
        Stack<Character> para = new Stack<Character>();
        if(s.length() == 1) return false;
        para.push(s.charAt(0));
        for(int i = 1; i < s.length(); i++)
        {
            char cur = s.charAt(i);
            if(para.empty())  
            para.push(cur);
            else
            {
                char tmp = para.peek();
                if((tmp == '(' && cur == ')') || (tmp == '[' && cur == ']') || (tmp == '{' && cur == '}'))
                para.pop();
                else  
                {
                    para.push(cur);
                }
            }
        }
        if(para.empty())
        return true;
        else
        return false;
    }
}