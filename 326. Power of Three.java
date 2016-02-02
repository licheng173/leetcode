public boolean isPowerOfThree(int n) {
    return Integer.toString(n, 3).matches("10*");
}

public boolean isPowerOfThree(int n) {
    if(n>1)
        while(n%3==0) n /= 3;
    return n==1;
}