//coner case :9133 0
public class Solution {
    public String multiply(String num1, String num2) {
        String[] nm1 = num1.split("");
        String[] nm2 = num2.split("");
        int length1 = nm1.length;
        int length2 = nm2.length;
        int[] num3 = new int[length1 + length2];
        int carry = 0;
        for(int i = 0; i < length1; i++) {
            carry = 0;
            for(int j = 0; j < length2; j++) {
                int n1 = Integer.valueOf(nm1[length1 - i - 1]);
                int n2 = Integer.valueOf(nm2[length2 - j - 1]);
                num3[i + j] += carry + n1*n2;
                 //System.out.println(carry);
                carry = num3[j + i] / 10;
                num3[i + j] = num3[i + j] % 10;
               
            }
            num3[i + length2] += carry;
        }
        boolean flag = false;
        StringBuilder build = new StringBuilder();
        for(int m = num3.length - 1; m >= 0; m--) {
            if(num3[m] == 0 && m != 0 && !flag ) {
                continue;
            }
            flag = true;
            build.append(String.valueOf(num3[m]));
        }
        return build.toString();
    }
}

//more beautiful
public String multiply(String num1, String num2) {
    int m = num1.length(), n = num2.length();
    int[] pos = new int[m + n];

    for(int i = m - 1; i >= 0; i--) {
        for(int j = n - 1; j >= 0; j--) {
            int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
            int p1 = i + j, p2 = i + j + 1;
            int sum = mul + pos[p2];

            pos[p1] += sum / 10;
            pos[p2] = (sum) % 10;
        }
    }  

    StringBuilder sb = new StringBuilder();
    for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
    return sb.length() == 0 ? "0" : sb.toString();
}

//other way to do this
public class Solution {
    public class Solution {
public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int carry = 0;
        StringBuilder build = new StringBuilder();
        for(int i = 0; i < (num1.length() + num2.length() - 1); i++) {
            int pro = 0;
            for(int j = 0; j <= i; j++) {
                if(j < num1.length() && (i - j) < num2.length()) {
                    pro += (num1.charAt(num1.length() - 1 - j) - '0') * (num2.charAt(num2.length() - 1 -(i - j)) - '0');
                }
            }
            pro += carry;
            build.append(pro % 10);
            carry = pro / 10;
        }
        if(carry > 0) {
            build.append(carry);
        }
        return build.reverse().toString();
    }
}
}