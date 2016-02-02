public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int length1 = Math.abs(A - C);
        int width1 = Math.abs(B -D);
        int length2 = Math.abs(E - G);
        int width2 = Math.abs(H - F);
        int length, width;
        if(B >= H || F >= D || E >= C || A >= G)  length = width = 0;
        else
        {
            if(H >= D && B >= F)  width = width1;
            else if( D >= H && F >= B) width = width2;
            else if(D >= H && B >= F)  width = width2 - (B - F);
            else width = width2 - (H - D);
            if(E >= A && C >= G) length = length2;
            else if(A >= E && G >= C) length = length1;
            else if(A >= E && C >= G) length = length2 - (A -E);
            else length = length2 - (G - C);
        }
        return (length1*width1 + length2*width2 -length * width);
    }
}

public class Solution {
    int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    int left = max(A,E), right = max(min(C,G), left);
    int bottom = max(B,F), top = max(min(D,H), bottom);
    return (C-A)*(D-B) - (right-left)*(top-bottom) + (G-E)*(H-F);
    }
}