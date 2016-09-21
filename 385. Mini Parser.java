/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        if(s.isEmpty()) return null;
        if(s.charAt(0) == '[') {
            NestedInteger nes = new NestedInteger();
            if(s.length() > 2) {
            Stack<String> stack = new Stack<String>();
            int start = 0;
            int end = 1;
            for(start = 0; start < s.length(); start++) {
                if(stack.size() == 1 && stack.peek() == "[") {
                    if(s.charAt(start) == ',') {
                        nes.add(deserialize(s.substring(end, start)));
                        end = start + 1;
                    }
                }
                if(s.charAt(start) == '[') 
                    stack.push("[");
                else if(s.charAt(start) == ']' && !stack.isEmpty()) 
                    stack.pop();
            }
            nes.add(deserialize(s.substring(end, start - 1)));
            }
            return nes;
        }
        else {
            return new NestedInteger(Integer.valueOf(s));
        }
    }
}