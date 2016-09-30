public class Solution {
  public int largestBSTSubtree(TreeNode root) {
    if(root == null) return 0;
      if(isValid(root, Integer.MAX_VALUE, Integer.MIN_VALUE)) return count(root);
      else return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
   }
  
  public int count (TreeNode n){
      if(n == null)
          return 0;
      return 1 + count(n.left) + count(n.right);
  }
   
  public boolean isValid(TreeNode n, int max, int min){
      if(n == null) return true;
      if(n.val < max && n.val > min) return isValid(n.left, n.val, min) && isValid(n.right, max, n.val);
      else return false;
  }
   
}

//using class
public class Solution {
    class Signal {
        int min; 
        int max;
        boolean isBST;
        int num;
        
        public Signal() {
            this.min = Integer.MAX_VALUE;
            this.max = Integer.MIN_VALUE;
            this.num = 0;
            this.isBST = true;
        }
    }
    public int largestBSTSubtree(TreeNode root) {
        return helper(root).num;
    }
    
    public Signal helper(TreeNode root) {
        Signal s = new Signal();
        if(root == null) {
            return s;
        }
        if(root.left == null && root.right == null) {
            s.min = root.val;
            s.max = root.val;
            s.num = 1;
            s.isBST = true;
            return s;
        }
        Signal left = helper(root.left);
        Signal right = helper(root.right);
        if(!left.isBST || !right.isBST) {
            s.isBST = false;
            s.num = Math.max(left.num, right.num);
        }
        else {
            if(root.val > left.max && root.val < right.min) {
                s.min = Math.min(root.val, left.min);
                s.max = Math.max(root.val, right.max);
                s.num = left.num + 1 + right.num;
                s.isBST = true;
            }
            else {
                s.isBST = false;
                s.num = Math.max(left.num, right.num);
            }
        }
        return s;
    }
}