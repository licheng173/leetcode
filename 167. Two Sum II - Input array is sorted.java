public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        int[] index = new int[2];
        int end = length - 1;
        int first = 0;
        while(first < end) {
            if(numbers[first] > target/2 ) {
                return index;
            }
            int num2 = target - numbers[first];
            if(numbers[end] > num2) {
                end--;
            }
            else if(numbers[end] < num2) {
                first++;
            }
            else {
                index[0] = first + 1;
                index[1] = end + 1;
                break;
            }
        }
        return index;
    }
}