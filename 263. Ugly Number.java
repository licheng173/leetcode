public class Solution {
    public boolean isUgly(int num) {
        if(num == 1) return true;
        if(num == 0) return false;
        while(num%3 == 0 || num%5 == 0 || num %2 == 0)
        {
            if(num %3 == 0) num = num/3;
            else if(num %5 == 0) num = num/5;
            else if(num %2 == 0) num = num/2;
        }
        if(num == 1)
        return true;
        else return false;
    }
}
//
public boolean isUgly(int num) {
    if(num==1) return true;
    if(num==0) return false;
    while(num%2==0) num=num>>1;
    while(num%3==0) num=num/3;
    while(num%5==0) num=num/5;
    return num==1;
}