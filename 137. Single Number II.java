public int singleNumber(int[] A) {
    int ones = 0, twos = 0;
    for(int i = 0; i < A.length; i++){
        ones = (ones ^ A[i]) & ~twos;
        twos = (twos ^ A[i]) & ~ones;
    }
    return ones;
}


//
public int singleNumber(int[] A) {
     int x1 = 0;   
     int x2 = 0; 
     int mask = 0;

     for (int i : A) {
        x2 ^= x1 & i;
        x1 ^= i;
        mask = ~(x1 & x2);
        x2 &= mask;
        x1 &= mask;
     }

     return x1;  // p = 1, in binary form p = '01', then p1 = 1, so we should return x1; 
                 // if p = 2, in binary form p = '10', then p2 = 1, so we should return x2.
}