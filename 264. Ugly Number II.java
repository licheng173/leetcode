
//DP， 求下一个nth ugly number， 要设三个指针， 找到前一个乘以2 3 5 能得到当前数的的数， 得到的那个数的下一个数乘以2 3 5 就是可能的下个值
public class Solution {
    public int nthUglyNumber(int n) {
        if(n <= 0) return 0;
        int[] uglyList = new int[n];
        uglyList[0] = 1;
        int point2 = 0;
        int point3 = 0;
        int point5 = 0;
        for(int i = 1; i < n; i++) {
            int min = Math.min(Math.min(uglyList[point2]*2,uglyList[point3]*3), uglyList[point5]*5);
            uglyList[i] = min;
            if(uglyList[point2]*2 == uglyList[i]){ 
                point2++;
            }
            if(uglyList[point3]*3 == uglyList[i]){
                point3++;
            }
            if(uglyList[point5]*5 == uglyList[i]){
                point5++;
            }
        }
        return uglyList[n - 1];
    }
}