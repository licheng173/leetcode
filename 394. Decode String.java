public class Solution {
    public String decodeString(String s) {
        Queue<String> q = new LinkedList<>();
        q.add(s);
        while(!q.isEmpty()) {
            String top = q.remove();
            StringBuilder build = new StringBuilder();
            int i = 0;
            while(i < top.length()) {
                if(!Character.isLetter(top.charAt(i))) {
                    int first = top.indexOf("[", i);
                    
                    int num = Integer.valueOf(top.substring(i, first));
                    
                    int index = findSub(top.substring(first, top.length()));
                    String chuck = top.substring(first + 1, index + first);
                    //System.out.println(chuck);
                    for(int j = 0; j < num; j++) {
                        build.append(chuck);
                    }
                    i = index + first + 1;
                    //System.out.println(i);
                }
                else {
                    build.append(top.charAt(i));
                    i++;
                }
            }
            if(build.indexOf("[") > 0) {
                q.add(build.toString());
            }
            else {
                return build.toString();
            }
        }
        return "";
    }
    
    public int findSub(String s) {
        Stack<Character> stack = new Stack<>();
        //char[] ar = s.toCharArray();
        stack.push('[');
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }
            if(s.charAt(i) == ']') {
                stack.pop();
                if(stack.size() == 0) {
                    return i;
                }
            }
        }
        return  -1;
    }
}