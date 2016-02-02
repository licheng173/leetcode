public class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int rotate = k % length;
        int[] num2 = new int[length];
        for(int i = 0; i < length - rotate; i++){
            num2[i+rotate] = nums[i];
        }
        for(int i = 0; i < rotate; i++){
            num2[i] = nums[length - rotate + i];
        }
        for(int j = 0; j < length; j++){
            nums[j] = num2[j];
        }
    }
}

public class Solution{
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int rotate = k % length;
        int cur = 0;
        int i =0;
        int start = 0;
        int flag = nums[0];
        int tmp = 0;
        while(i < lenght){
            do
            {
                tmp = nums[(cur + rotate)% length];
                nums[(cur + rotate)% length] = flag;
                cur = cur + rotate;
                flag = tmp;
                i++;
             }while(cur != start);
             start ++;
             cur  = start;
             flag = nums[cur];
         }

}
}