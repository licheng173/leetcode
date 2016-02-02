public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        if(ishappy(set,n) > 0)
        return true;
        else 
        return false;
    }
    public int ishappy(HashSet<Integer> set, int num)
    {
        int div = num;
        int mod = 0;
        int sum = 0;
        String nums = String.valueOf(num);
        for(int i = 0; i < nums.length(); i++)
        {
            mod = div%10;
            div = div/10;
            sum = (int)Math.pow(mod,2) + sum;
        }
        if(sum == 1)
        return 1;
        if(!set.contains(sum))
            set.add(sum);
        else
            return -1;
        return ishappy(set, sum);
    }
}

//good idea use O(1) space  ****
public class Solution {
    public boolean isHappy(int n) {
        int x = n;
        int y = n;
        while(x>1){
            x = cal(x) ;
            if(x==1) return true ;
            y = cal(cal(y));
            if(y==1) return true ;

            if(x==y) return false;
        }
        return true ;
    }
    public int cal(int n){
        int x = n;
        int s = 0;
        while(x>0){
            s = s+(x%10)*(x%10);
            x = x/10;
        }
        return s ;
    }
}

// find 1 or 7
public boolean isHappy(int n) {
        if(n<=0) return false;
        while(true){
            int sum=0;
            while(n!=0){
              sum+=(n%10)*(n%10);
              n=n/10;
            }
            if(sum/10==0){
               if(sum==1||sum==7) return true;
               else return false;
            }
            n=sum;
        }
    }