public class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<Integer> stack = new Stack<Integer>();
        return helper(root, stack);
    }
    
    public boolean helper(TreeNode root, Stack<Integer> stack) {
        if(root == null) return true;
        boolean left = helper(root.left, stack);
        if(!stack.isEmpty()) {
            if(stack.peek() >= root.val)
                return false;
        }
        stack.push(root.val);
        boolean right = helper(root.right, stack);
        return right && left;
    }
}

//more concise
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}

public boolean isValidBST (TreeNode root){
           Stack<TreeNode> stack = new Stack<TreeNode> ();
           TreeNode cur = root ;
           TreeNode pre = null ;           
           while (!stack.isEmpty() || cur != null) {               
               if (cur != null) {
                   stack.push(cur);
                   cur = cur.left ;
               } else {                
                   TreeNode p = stack.pop() ;
                   if (pre != null && p.val <= pre.val) {                      
                       return false ;
                   }                   
                   pre = p ;                       
                   cur = p.right ;
               }
           }
           return true ; 
       }