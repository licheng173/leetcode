public class Solution {
  public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int length = nums.length;
        int[] num = new int[length];
        int index = (a >= 0) ? length - 1 : 0;
        int i = 0;
        int j = length - 1;
        while(i <= j) {
            if(a >= 0) {
                if(qq(a ,b ,c , nums[i]) > qq(a ,b ,c , nums[j])) {
                    num[index] = qq(a ,b ,c , nums[i]);
                    i++;
                }
                else {
                    num[index] = qq(a, b, c, nums[j]);
                    j--;
                }
                index--;
            }
            else {
                if(qq(a, b, c, nums[i]) > qq(a, b, c, nums[j])) {
                    num[index] = qq(a, b, c, nums[j]);
                    j--;
                }
                else {
                    num[index] = qq(a, b, c, nums[i]);
                    i++;
                }
                index++;
            }
        }
        return num;
    }

    public int qq(int a, int b, int c, int x) {
        return a*x*x + b*x + c;
    }
}