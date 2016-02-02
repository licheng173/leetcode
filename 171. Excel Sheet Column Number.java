public class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++)
        {
            sum = sum + (s.charAt(i) - '@')*((int)Math.pow(26, (s.length()-1-i)));
        }
        return sum;
    }
}

public class Solution {
    public int titleToNumber(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); result = result * 26 + (s.charAt(i) - 'A' + 1), i++);
		return result;
	}
}