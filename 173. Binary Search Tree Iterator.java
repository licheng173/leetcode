public class BSTIterator {
    TreeNode least;
    TreeNode root;
    TreeNode max;
    int count;
    public BSTIterator(TreeNode root) {
        this.root = root;
        count = 0;
        TreeNode tm = root;
        if(root != null) { 
            while(tm.right != null) {
                tm = tm.right;
            }
            max = tm;
            while(root.left != null) {
                root =root.left;
            }
            least = root;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(root == null) return false;
        if(count != 0)
        return least.val < max.val;
        return true;
    }

    /** @return the next smallest number */
    public int next() {
        if(count == 0) {
            count++;
            return least.val;
        }
        else {
            least =  suc(root);
            return least.val;
        }
    }
    
    public TreeNode suc(TreeNode root) {
        if(root == null) {
            return null;
        }
        
        if(least.val >= root.val) {
            return suc(root.right);
        }
        else {
            TreeNode tmp = suc(root.left);
            return tmp == null ? root : tmp;
        }
    }
}

////
public class BSTIterator {
    List<Integer> l;
    Iterator<Integer> t;
    public BSTIterator(TreeNode root) {
        Stack<TreeNode> q = new Stack<TreeNode>();
        l = new ArrayList<Integer>();
        
        while(!q.isEmpty() || root != null) {
            while(root != null) {
                q.push(root);
                root = root.left;
            }
            TreeNode t = q.pop();
            l.add(t.val);
            root = t.right;
        }
        t = l.iterator();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return t.hasNext();
    }

    /** @return the next smallest number */
    public int next() {
        return t.next();
    }
}

//
public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmpNode = stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }
    
    private void pushAll(TreeNode node) {
        for (; node != null; stack.push(node), node = node.left);
    }
}
