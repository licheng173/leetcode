public class Solution {
    public int countPrimes(int n) {
        boolean isPrime[] = new boolean[n];
        for(int i = 2; i < n; i++)
        {
            isPrime[i] = true;
        }
        
        for(int j = 2; j * j < n; j++)
        {
            if(!isPrime[j]) continue;
            for(int k = j * j; k < n; k += j)
            {
                isPrime[k] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
}


public class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

        return count;
    }
}