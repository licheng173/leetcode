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
//bit manipulating
public class Solution{
    public int majorityElement(int[] nums){
        
    }
}