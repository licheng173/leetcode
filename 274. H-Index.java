public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++) {
            if(citations[i] >= citations.length - i) return citations.length - i;
        }
        return 0;
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


//
public class Solution {
    public int hIndex(int[] citations) {
        int length = citations.length;
       int[] store = new int[length + 1];
       for(int i = 0; i < length; i++) {
           if(citations[i] > length) {
               store[0] += 1 ;
           }else if(citations[i] > 0) {
                store[citations[i]] += 1;
           }
       }
       int sum = 0;
       for(int j = length; j >= 1; j--) {
           sum += store[j];
           //System.out.println(j);
           if((sum + store[0]) >= j) return j;
       }
       return 0;
    }
}