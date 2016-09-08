public class Solution {
    public boolean isReflected(int[][] points) {
        HashSet<String> set = new HashSet<>();
        int row = points.length;
        StringBuilder s = new StringBuilder();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < row; i++) {
            min = Math.min(points[i][0], min);
            max = Math.max(points[i][0], max);
            set.add(points[i][0] + "" + points[i][1]);
        }
        int mid = (max + min);
        for(int i = 0; i < row; i++) {
            int x = mid - points[i][0];
            String tmp = x + "" + points[i][1];
            //System.out.println(tmp);
            if(!set.contains(tmp)) {
                return false;
            }
        }
        return true;
    }
}