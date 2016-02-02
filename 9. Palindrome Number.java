public class Solution {
    public boolean isPalindrome(int x) {
       
    if (x == 0) return true;
    // in leetcode, negative numbers and numbers with ending zeros
    // are not palindrome
    if (x < 0 || x % 10 == 0)
        return false;

    // reverse half of the number
    // the exit condition is y >= x
    // so that overflow is avoided.
    int y = 0;
    while (y < x) {
        y = y * 10 + (x % 10);
        if (x == y)  // to check numbers with odd digits
            return true;
        x /= 10;
    }
    return x == y; // to check numbers with even digits
}
}

public boolean isPalindrome(int x) {
    if (x<0 || (x!=0 && x%10==0)) return false;
    int rev = 0;
    while (x>rev){
        rev = rev*10 + x%10;
        x = x/10;
    }
    return (x==rev || x==rev/10);
}

//
public boolean isPalindrome(int x) {

    if (x < 0) return false;

    int p = x; 
    int q = 0; 

    while (p >= 10){
        q *=10; 
        q += p%10; 
        p /=10; 
    }

    return q == x / 10 && p == x % 10;
}

//whats the difference between these two 