public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n;
        int p1 = m;
        int p2 = n;
        for(int i = 0; i < k; i++){
            if(p1 == 0 && p2 > 0)
            {
                nums1[k-i-1] = nums2[p2 - 1];
                p2--;
            }
            if(p1 > 0 && p2 ==0)
            {
                nums1[k - i - 1] = nums1[p1 - 1];
                p1--;
            }
            if(p1 > 0 && p2 > 0)
            {
                if(nums1[p1-1] >= nums2[p2-1] ){
                   nums1[k-i-1] = nums1[p1 - 1];
                   p1--;
                 }
                 else
                 {
                    nums1[k-i-1] = nums2[p2 - 1];
                  p2--;
                  }
            }
        }
    }
}

//more simple
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
         int i = m-1;
        int j = n-1;
        for (int k = m+n-1; k >= 0; k--) {
            if (i < 0)              nums1[k] = nums2[j--];
            else if (j < 0)         nums1[k] = nums1[i--];
            else if (nums1[i] < nums2[j])   nums1[k] = nums2[j--];
            else                    nums1[k] = nums1[i--];
        }
    }
}