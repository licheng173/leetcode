
//two pointers
public class Solution {
public int removeDuplicates(int[] nums) {
    if(nums.length == 0 || nums.length == 1) return nums.length;
    int i=0, j=1;
    while(j<nums.length){
        if(nums[i] == nums[j]) j++;
        else{
            i++;
            nums[i] =nums[j];
            j++;
        }
    }
    return ++i;
}
}
//for scan
public class Solution {
    public int removeDuplicates(int[] nums) {
        int cont = 0;
        for(int i = 0; i < nums.length - 1; i++)
        {
            if(nums[i] == nums[i + 1])
            { continue;}
            else
            {
                cont++;
                nums[cont] = nums[i+1];
                
            }
        }
        return cont+1;
    }
}