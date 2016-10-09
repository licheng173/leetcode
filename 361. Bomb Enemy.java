public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int max = 0;
        int row = 0; 
        int[] col = new int[grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            
            //col = new int[grid[0].length];
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 'W') {
                    continue;
                }
                if(j == 0 || grid[i][j - 1] == 'W') {
                    row = 0;
                    for(int k = j; k <grid[0].length && grid[i][k] != 'W'; k++) {
                        if(grid[i][k] == 'E') {
                            row++;
                        }
                        
                    }
                    
                }
                if(i == 0 || grid[i - 1][j] == 'W') {
                    col[j] = 0;
                    for(int k = i; k < grid.length && grid[k][j] != 'W'; k++) {
                        if(grid[k][j] == 'E') {
                            col[j]++;
                        }
                    }
                    //for(int m: col)
                    //System.out.println(m);
                }
                if(grid[i][j] == '0'){
                    max = Math.max(max, row + col[j]);
                }
            }
        }
        return max;
    }
}