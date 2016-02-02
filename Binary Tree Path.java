public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> l = new ArrayList<String>();
        StringBuilder s = new StringBuilder();
        if(root == null) return l;
        s.append(String.valueOf(root.val));
        if(root.left == null & root.right == null) 
        {
            l.add(s.toString());
            return l;
        }
        if(root.left != null)
        {
            List<String> m = binaryTreePaths(root.left);
           for(int i = 0; i < m.size(); i++)
            {
                StringBuilder tm = new StringBuilder();
                m.set(i,tm.append(s).append("->").append(m.get(i)).toString());
            }
            l.addAll(m);
        }
        if(root.right != null)
        {
             List<String> p = binaryTreePaths(root.right);
            for(int i = 0; i < p.size(); i++)
            {
               StringBuilder tm = new StringBuilder();
                p.set(i,tm.append(s).append("->").append(p.get(i)).toString());
            }
            l.addAll(p);
        }
        return l;
    }
}
//use recursion function
public List<String> binaryTreePaths(TreeNode root) {
    List<String> answer = new ArrayList<String>();
    if (root != null) searchBT(root, "", answer);
    return answer;
}
private void searchBT(TreeNode root, String path, List<String> answer) {
    if (root.left == null && root.right == null) answer.add(path + root.val);
    if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
    if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
}