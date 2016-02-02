public class Solution {
    public String getHint(String secret, String guess) {
        int[] s = new int[10];
        int[] g = new int[10];
        int cBulls = 0;
        int cCows = 0;
        for(int i = 0; i < secret.length(); i++)
        {
            if(secret.charAt(i) == (guess.charAt(i)))
            {
                cBulls++;
                continue;
            }
            else
            {
                s[secret.charAt(i) - '0']++;
                g[guess.charAt(i) - '0']++;
            }
        }
        for(int j = 0; j < 10; j++)
        {
            if(s[j] != 0 && g[j] != 0)
                cCows = cCows + Math.min(s[j],g[j]);
        }
        return (cBulls + "A" + cCows + "B");
    }
}

//other version
public String getHint(String secret, String guess) {
    int bulls = 0;
    int cows = 0;
    int[] numbers = new int[10];
    for (int i = 0; i<secret.length(); i++) {
        if (secret.charAt(i) == guess.charAt(i)) bulls++;
        else {
            if (numbers[secret.charAt(i)-'0']++ < 0) cows++;
            if (numbers[guess.charAt(i)-'0']-- > 0) cows++;
        }
    }
    return bulls + "A" + cows + "B";
}