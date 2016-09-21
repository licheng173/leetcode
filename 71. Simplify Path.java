public class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.substring(1).split("/+");
        Stack<String> stack = new Stack<String>();
        for(int i = 0; i < arr.length; i++) {
            if(!arr[i].equals("..") && !arr[i].equals(".") && !arr[i].equals("")) {
                stack.push("/" + arr[i]);
            }
            else if(arr[i].equals("..") && !stack.isEmpty()) {
                stack.pop();
            }
        }
        StringBuilder build = new StringBuilder();
        for(String st : stack) {
            build.append(st);
        }
        return build.length() > 0 ? build.toString() : "/" + build.toString();
    }
}

//coner case
// /..    /../   /home//foo/

