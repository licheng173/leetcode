public class Solution {
    public int findPeakElement(int[] num) {    
    int low = 0;
    int high = num.length-1;
    int mid1 = (low+high)/2;
    while(low < high)
    {
        if(num[mid1] < num[mid1+1])
        {
            low = mid1+1;
            mid1 = (low+high)/2;
        }
                
        else
       {
           high = mid1;                
           mid1 = (low+high)/2;
       }
    }
    return low;
}
}