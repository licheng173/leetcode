public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> lis = new ArrayList<Integer>();
        int length = nums.length;
        if(length == 0 || nums == null) return lis;
        int num1 = nums[0];
        int num2 = 0;
        int count1 = 1;
        int count2 = 0;
        for(int i = 1; i < length; i++) {
            if(nums[i] == num1) {
                count1++;
            }
            else if(nums[i] == num2) {
                count2++;
            }
            else if(count1 == 0) {
                num1 = nums[i];
                count1 = 1;
            }
            else if(count2 == 0) {
                num2 = nums[i];
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i = 0; i < length; i++) {
            if(nums[i] == num1) {
                count1++;
            }
            else if(nums[i] == num2) {
                count2++;
            }
        }
        if(count1 > length / 3) {
            lis.add(num1);    
        }
        if(count2 > length / 3) {
            lis.add(num2);
        }
        return lis;
    }
}