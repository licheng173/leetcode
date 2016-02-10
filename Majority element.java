//41ms HashMap
public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> ele = new HashMap<Integer,Integer>();
        int len = nums.length;
        if(len == 1)
        return nums[0];
        for(int i = 0; i < nums.length; i++)
        {
            if(!ele.containsKey(nums[i])){
                ele.put(nums[i],1);
            }
            else
            {
                int t = ele.get(nums[i]);
                ele.put(nums[i],t+1);
                if(ele.get(nums[i]) > len/2)
                     {return nums[i];}
            }
        }
        return -1;
    }
}


//Moore voting Algorithms
public class Solution{
    public int majorityElement(int[] nums){
        int major = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++)
        {
            if(count == 0)
            {
                major = nums[i];
                count = 1;
            }
            else if(major == nums[i])
                count++;
            else
                count--;
        }
        return major;      
    }
}
//bit manipulating  *********
public class Solution{
public int majorityElement(int[] nums) {
    int[] bit = new int[32];
    for (int num: nums)
        for (int i=0; i<32; i++) 
            if ((num>>(31-i) & 1) == 1)
                bit[i]++;
    int ret=0;
    for (int i=0; i<32; i++) {
        bit[i]=bit[i]>nums.length/2?1:0;
        ret += bit[i]*(1<<(31-i));
    }
    return ret;
}
}