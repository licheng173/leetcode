
//523ms
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null) 
            return true;
        return helper(preorder, 0, preorder.length - 1);
    }
    public boolean helper(int[] preorder, int start, int end) {
        if(start > end) {
            return true;
        }
        if(start == end) {
            return true;
        }
        
        int f = preorder[start];
        int index = start + 1;
        int mid = 0;
        boolean pp = true;
        while(index <= end) {
            if(preorder[index] > preorder[start])
            break; 
            index++;
        }
        boolean left = helper(preorder, start + 1, index - 1);
        int i = index;
        while(i <= end) {
            if(preorder[i] <f)
            pp = false;
            i++;
        }
        boolean right = helper(preorder, index, end);
        return pp && left && right;
    }
}

//
public boolean verifyPreorder(int[] preorder) {
    int low = Integer.MIN_VALUE;
    Stack<Integer> path = new Stack();
    for (int p : preorder) {
        if (p < low)
            return false;
        while (!path.empty() && p > path.peek())
            low = path.pop();
        path.push(p);
    }
    return true;
}
