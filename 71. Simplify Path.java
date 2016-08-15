public class Solution {
    public String simplifyPath(String path) {
        String[] splitString = path.split("/");
        Stack<String> stack = new Stack<String>();
        int length = splitString.length;
        for(int i = 0; i < length; i++) {
            if(!stack.empty() && splitString[i].equals("..")) {
                stack.pop();
                continue;
            }else if (!splitString[i].equals("") && !splitString[i].equals(".")&& !splitString[i].equals("..")){
                stack.push(splitString[i]);
            }
        }
        String sum = "";
        if(stack.empty()) return "/";
        while(!stack.empty()) {
            String tmp = stack.pop();
            //System.out.println(tmp);
            sum = "/" + tmp+ sum;
        }
        return sum;
    }
}

//coner case
// /..    /../   /home//foo/