/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {

    private List<Integer> nums;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        this.nums = new ArrayList<Integer>();
    }
    
    public void addNum(int val) {
        if(!nums.contains(val)) {
            this.nums.add(val);
            Collections.sort(nums);
        }
    }
    
    public List<Interval> getIntervals() {
        List<Interval> list = new ArrayList<Interval>();
        int length = nums.size();
        int subLow = 0;
        int start = 0;
        int end = 0;
        for(int i = 0; i < length; i++) {
           int tmp = nums.get(i);
           while(i < (length - 1) && (nums.get(i+1) - nums.get(i)) == 1) {
               i++;
           }
           if(tmp == nums.get(i)) {
               list.add(new Interval(tmp,tmp));
           }
           else {
               list.add(new Interval(tmp, nums.get(i)));
           }
        }
        return list;
    }
}
