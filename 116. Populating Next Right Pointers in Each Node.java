public class Solution {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        if(root == null) return;
        q.add(root);
        while(!q.isEmpty()) {
            TreeLinkNode n = null;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeLinkNode t = q.remove();
                t.next = n;
                n = t;
                //System.out.println(t.val + "fdf");
                if(t.right != null) q.add(t.right);
                if(t.left != null) q.add(t.left);
            }
        }
    }
}

public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        TreeLinkNode cur = root;
        TreeLinkNode nextLeftmost = null;

        while(cur.left!=null){
            nextLeftmost = cur.left; // save the start of next level
            while(cur!=null){
                cur.left.next=cur.right;
                cur.right.next = cur.next==null? null : cur.next.left;
                cur=cur.next;
            }
            cur=nextLeftmost;  // point to next level 
        }
    }
}

//recursion
public void connect(TreeLinkNode root) {
    if(root == null)
        return;
        
    if(root.left != null){
        root.left.next = root.right;
        if(root.next != null)
            root.right.next = root.next.left;
    }
    
    connect(root.left);
    connect(root.right);
}