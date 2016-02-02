public class Solution {
    public void moveZeroes(int[] nums) {
        int pre = 0;
        int next = 1;
        if(nums.length <= 1)
        return;
        while(next < nums.length){
            if(nums[pre] == 0 && nums[next] != 0){
                nums[pre] = nums[next];
                nums[next] = 0;
                pre++;
                next++;
            }
            else if(nums[pre] == 0 && nums[next] == 0 ){
                next++;
            }
            else
            {
                pre++;
                next++;
            }
        }
    }
}

public class Solution {
    public void moveZeroes(int[] nums) {
    int k = 0;
    for(int i = 0; i < nums.length; i++){
        if(nums[i] != 0)
        {
            nums[k++] = nums[i];
        }
    }    
        while(k < nums.length){
            nums[k++] = 0;
        }
    }
}