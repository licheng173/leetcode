//top down
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < triangle.size(); i++)
        {
            for(int j = 0; j < triangle.get(i).size(); j++)
            {
                if(j == 0)
                    triangle.get(i).set(j,(triangle.get(i - 1).get(j) +  triangle.get(i).get(j)));
                else if(j == (triangle.get(i).size() - 1))
                    triangle.get(i).set(j,(triangle.get(i - 1).get(j -1) +  triangle.get(i).get(j)));
                else
                    triangle.get(i).set(j,(Math.min(triangle.get(i - 1).get(j),triangle.get(i - 1).get(j - 1)) +triangle.get(i).get(j)));
            }
        }
        
        for(int i = 0; i < triangle.get(triangle.size()-1).size(); i++)
        {
            if(min > triangle.get(triangle.size()-1).get(i))
            min = triangle.get(triangle.size()-1).get(i);
        }
        return min;
    }
}

///more concise version bottom up
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] minlen = new int[n];
        for(int i =0; i < n; i++)
        {
            minlen[i] = triangle.get(n -1).get(i);
        }
        for (int layer = n-2; layer >= 0; layer--) 
        {
            for (int i = 0; i <= layer; i++) 
            {
                minlen[i] = Math.min(minlen[i], minlen[i+1]) + triangle.get(layer).get(i); 
            }
        }
        return minlen[0];
    }
}
