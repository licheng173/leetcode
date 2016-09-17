public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> roman = new HashMap<Character, Integer>();
        roman.put('I',1);roman.put('V',5);roman.put('X',10); roman.put('L',50);
        roman.put('C',100); roman.put('D',500); roman.put('M',1000);
        int sum = 0;
        for(int i = 0; i < s.length(); i++)
        {
            int tmp = roman.get(s.charAt(i));
            
            if(i + 1 < s.length())
            {
                int tp = roman.get(s.charAt(i + 1));
                if(tmp >= tp)
                    sum = sum + tmp;
                else
                    sum = sum - tmp;
            }
            else
            sum = sum + roman.get(s.charAt(i));
        }
        return sum;
    }
}

//more consize
public class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int[] nums = new int[s.length()];
        for(int i = 0; i < s.length(); i++)
        {
            switch (s.charAt(i)){
                case 'I': nums[i] = 1; break;        
                case 'V': nums[i] = 5; break;
                case 'X': nums[i] = 10; break;
                case 'L': nums[i] = 50; break;
                case 'C': nums[i] = 100; break;
                case 'D': nums[i] = 500; break;
                case 'M': nums[i] = 1000; break;
                }
        }
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]<nums[i+1])
                sum-=nums[i];
            else
                sum+=nums[i];
        }
        return sum+nums[nums.length-1];
    }
}