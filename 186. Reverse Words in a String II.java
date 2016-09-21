public class Solution {
    public void reverseWords(char[] s) {
        int length = s.length;
        if(length < 1) return;
        //int[] space = new
        int start = 0;
        int index = 0;
        reverse(s, start, index, s.length);
    }

    public void reverse(char[] s, int start, int index, int length) {
        if(index == length) return;
        while(s[length - 1] != ' ' && index < length) {
            char tmp = s[length - 1];
            for(int i = length - 1; i >= start + 1; i--) {
                s[i] = s[i - 1];
            }
            s[start] = tmp;
            index++;
        }

        if(s[length - 1] == ' ') {
            for (int i = length - 1; i >= index; i--) {
                s[i] = s[i - 1];
                //
            }
            s[index] = ' ';
            index++;

        }
        reverse(s, index, index, length);
    }
}

//
public class Solution {
    public void reverseWords(char[] s) {
        int length = s.length;
        if(length < 1) return;
        //int[] space = new
        int start = 0;
        int index = 0;
        reverse(s, start, index, s.length);
    }

    public void reverse(char[] s, int start, int index, int length) {
        if(index == length) return;
        while(s[length - 1] != ' ' && index < length) {
            char tmp = s[length - 1];
            for(int i = length - 1; i >= start + 1; i--) {
                s[i] = s[i - 1];
            }
            s[start] = tmp;
            index++;
        }

        if(s[length - 1] == ' ') {
            for (int i = length - 1; i >= index; i--) {
                s[i] = s[i - 1];
                //
            }
            s[index] = ' ';
            index++;

        }
        reverse(s, index, index, length);
    }
}