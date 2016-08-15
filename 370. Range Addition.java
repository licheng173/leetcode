public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int opSet = updates.length;
        int[] newArr = new int[length];
        for(int i = 0; i < opSet; i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int incre = updates[i][2];
            newArr[start] += incre;
            if(end <length - 1) {
                newArr[end + 1] -= incre;  
            }
        }
        int sum = 0;
        for(int j = 0; j < length; j++) {
            sum += newArr[j];
            newArr[j] = sum;
        }
        return newArr;
    }
}

