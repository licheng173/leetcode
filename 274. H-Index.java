public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i;
        for(i = 0; i < citations.length; i++)
        {
            if((i+1) > citations[citations.length - i - 1])
            break;
        }
        return i;
    }
}
//
public class Solution {
    public int hIndex(int[] citations) {
       int length = citations.length;
       int[] newArray = new int[length + 1];
       for(int i = 0; i < length; i++)
       {
           if(citations[i] > length)
           {
               newArray[length]++;
           }
           else
           {
               newArray[citations[i]]++;
           }
       }
       int sum = 0;
       for(int j = length; j >= 0; j--)
       {
           sum = sum + newArray[j];
           if(sum >= j)
           return j;
       }
       return 0;
    }
}