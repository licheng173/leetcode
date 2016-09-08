public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int m = map.get(nums[i]);
                map.put(nums[i], m + 1);
            }
            else {
                map.put(nums[i], 1);
            }
        }
        List<Integer>[] p = new List[nums.length + 1];
        for(int m: map.keySet()) {
            int f = map.get(m);
            if(p[f] == null) {
                p[f] = new ArrayList<>();
            }
            p[f].add(m);
        }
        List<Integer> dd = new ArrayList<Integer>();
        for(int l = p.length - 1; l >= 0 && dd.size() < k; l--) {
            if(p[l] != null) {
                dd.addAll(p[l]);
            }
        }
        return dd;
    }
}