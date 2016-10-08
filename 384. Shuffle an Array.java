public class Solution {
    private int[] num;
    private int[] numm;
    //private List<
    private Random random;
    public Solution(int[] nums) {
        num = nums;
        numm = Arrays.copyOf(nums, nums.length);
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return num;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i = numm.length - 1; i >= 0; i--) {
            int t = random.nextInt(i + 1);
            int tm = numm[t];
            numm[t] = numm[i];
            numm[i] = tm;
        }
        return numm;
    }
}
