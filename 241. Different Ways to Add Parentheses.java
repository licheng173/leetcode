public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' ) {
                char operator = input.charAt(i);
                int index = i;
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));
                for(Integer num1: left) {
                    for(Integer num2:right) {
                        if(operator == '+') {
                            l.add(num1 + num2);
                        }
                        else if(operator == '-') {
                            l.add(num1 - num2);
                        }
                        else {
                            l.add(num1 * num2);
                        }
                    }
                }
            }
        }
        if(l.size() == 0) {
            l.add(Integer.valueOf(input));
        }
        return l;
    }
}