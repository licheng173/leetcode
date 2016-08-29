public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sub = new ArrayList<List<Integer>>(); 
        List<Integer> empty = new ArrayList<Integer>();
        sub.add(empty);
        Arrays.sort(nums);
        int length = nums.length;
        int count = 1;
        for(int i = 0; i < ((int)Math.pow(2,length) - 1); i++)
        {
            List<Integer> subs = new ArrayList<Integer>();
            int c = count;
            for(int j = 0; j < length; j++)
            {
                if((c & 1) == 1)
                    subs.add(nums[j]);
                c = c >>> 1;
            }
            count++;
            sub.add(subs);
        }
        return sub;
    }
}

//second time
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        List<List<Integer>> outList = new ArrayList<List<Integer>>();
        int count = 0;
        while(count < (1 << length)) {
            List<Integer> list= new ArrayList<Integer>();
            int tmp = count;
            for(int i = 0; i < length; i++) {
                if((tmp >> i & 1) == 1) {
                    list.add(nums[i]);
                }
            }
            outList.add(list);
            count++;
        }
        return outList;
    }
}