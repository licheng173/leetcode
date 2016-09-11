public class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int carry = 1;
        for(int i = 0; i < length; i++){
            int su = digits[length-1-i]+carry;
            digits[length - 1 - i] = su % 10;
            if((su - 10) >= 0)
            {
                carry = 1;
            }
            else
            carry = 0;
        }
        if(carry == 1)
        {
            int[] newdigits = new int[length + 1];
            newdigits[0] = 1;
            for(int j = 0; j < length; j++)
            {
                newdigits[j + 1] = digits[j];
            }
            return newdigits;
        }
        else
        return digits;
        
    }
}