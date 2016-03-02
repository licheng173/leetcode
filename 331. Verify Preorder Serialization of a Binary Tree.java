//using stack like construct tree

public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] preSeri = preorder.split(",");
        if((preSeri[0] == "#" && preSeri.length != 1) || preSeri.length == 0) return false;
        Stack<String> stack = new Stack<String>();
        stack.push(preSeri[0]);
        
        for(int i = 1; i < preSeri.length; i++) {
           String m = preSeri[i];
           while(m.equals("#") && !stack.empty() && stack.peek().equals("#")){
               stack.pop();
               System.out.println("ffd");
               while(stack.isEmpty()){
                   return false;
               }
               stack.pop();
               
           }
           //System.out.println(stack.toString());
           stack.push(preSeri[i]);
           //System.out.println(stack.toString());
        }
        if(stack.peek().equals("#") && stack.size() == 1){
            return true;
        }
        else
        return false;
    }
}